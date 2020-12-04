package ru.orangedata.orangelib;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.ResponseBody;
import org.apache.commons.codec.binary.Base64;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.*;
import ru.orangedata.orangelib.models.PostResponse;
import ru.orangedata.orangelib.models.document.DocumentRequestBody;
import ru.orangedata.orangelib.network.Encryptor;
import ru.orangedata.orangelib.network.NetworkCodes;
import ru.orangedata.orangelib.network.NetworkConstants;
import ru.orangedata.orangelib.network.RetrofitSingle;
import ru.orangedata.orangelib.network.exception.*;

import javax.annotation.Nullable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.atomic.AtomicInteger;

public class DocumentRequest {

    private final RequestService requestService;

    public DocumentRequest() {
        requestService = RetrofitSingle.getRetrofit(null).create(RequestService.class);
    }

    public DocumentRequest(String url) {
        requestService = RetrofitSingle.getRetrofit(url).create(RequestService.class);
    }

    public void postDocument(DocumentRequestBody requestBody, String derKeyPath, @Nullable PostCallback postCallback) throws IOException {
        AtomicInteger tryCount = new AtomicInteger(0);
        String validation = requestBody.validate();
        if (!validation.equals("")) {
            throw new IOException("ValidationError: " + validation);
        }
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        byte[] textBytes = new byte[0];
        try {
            textBytes = gson.toJson(requestBody).getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] data = Encryptor.signData(textBytes, derKeyPath);
        String signature = Base64.encodeBase64String(data);

        Call<Void> call = requestService.postDocument(signature, requestBody);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                System.out.println("onResponse. Response code: " + response.code());
                switch (response.code()) {
                    case NetworkCodes.CREATED:
                        if (postCallback != null) {
                            postCallback.onSuccess();
                        }
                        break;
                    case NetworkCodes.UNAUTHORIZED:
                        if (postCallback != null) {
                            postCallback.onRequestFailure(new WrongCertificateException());
                        }
                        break;
                    case NetworkCodes.CONFLICT:
                        if (postCallback != null) {
                            postCallback.onRequestFailure(new ConflictException(requestBody.getId()));
                        }
                        break;
                    case NetworkCodes.BAD_REQUEST:
                        if (postCallback != null) {
                            try {
                                PostResponse postResponse = gson.fromJson(response.errorBody().string(), PostResponse.class);
                                postCallback.onValidationErrors(postResponse.getErrors());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case NetworkCodes.SERVICE_UNAVAILABLE:
                        if (postCallback != null) {
                            if (tryCount.get() < NetworkConstants.BUSY_RETRY_COUNT) {
                                tryCount.incrementAndGet();
                                try {
                                    String retryString = response.headers().get("Retry-After");
                                    if (retryString != null) {
                                        int retryInt = Integer.parseInt(retryString);
                                        Thread.sleep(retryInt * 1000L);
                                        Call<Void> newCall = call.clone();
                                        newCall.enqueue(this);
                                    } else {
                                        postCallback.onRequestFailure(new ServiceUnavailableException("Service Unavailable: wrong Retry-After header"));
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    postCallback.onRequestFailure(new ServiceUnavailableException("Service Unavailable", e));
                                }
                            } else {
                                postCallback.onRequestFailure(new ServiceUnavailableException("Service Unavailable: max retries"));
                            }
                        }
                        break;
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {
                System.out.println("onFailure. throwable: " + throwable.getLocalizedMessage());
                if (postCallback != null) {
                    postCallback.onRequestFailure(throwable);
                }
            }
        });
    }

    public void getDocument(String documentId, String inn, GetDocumentCallback callback) {
        Call<ResponseBody> call = requestService.getDocumentState(inn, documentId);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                System.out.println("onResponse. Response code: " + response.code());
                switch (response.code()) {
                    case NetworkCodes.OK:
                        if (callback != null) {
                            try {
                                callback.onSuccess(response.body().string());
                            } catch (Exception e) {
                                callback.onRequestFailure(new OrangeException(e));
                            }
                        }
                        break;
                    case NetworkCodes.ACCEPTED:
                        if (callback != null) {
                            callback.onRequestFailure(new CreatedNotProceedException());
                        }
                        break;
                    case NetworkCodes.UNAUTHORIZED:
                        if (callback != null) {
                            callback.onRequestFailure(new UnauthorizedException());
                        }
                    case NetworkCodes.NOT_FOUND:
                        if (callback != null) {
                            callback.onRequestFailure(new CheckNotFoundException());
                        }
                        break;
                    case NetworkCodes.DOCUMENT_EXPIRED_BEFORE_PROCESSING:
                        if (callback != null) {
                            callback.onRequestFailure(new DocumentExpiredBeforeProcessingException());
                        }
                        break;
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                System.out.println("onFailure. throwable: " + throwable.getLocalizedMessage());
                if (callback != null) {
                    callback.onRequestFailure(new OrangeException(throwable));
                }
            }
        });
    }

    interface RequestService {

        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("/api/v2/documents/")
        Call<Void> postDocument(@Header("X-Signature") String signature, @Body DocumentRequestBody requestBody);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("/api/v2/documents/{inn}/status/{document_id}")
        Call<ResponseBody> getDocumentState(@Path("inn") String inn, @Path("document_id") String documentId);

    }

}
