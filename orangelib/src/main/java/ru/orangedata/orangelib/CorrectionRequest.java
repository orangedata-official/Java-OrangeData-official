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
import ru.orangedata.orangelib.models.correction.CorrectionRequestBody;
import ru.orangedata.orangelib.network.Encryptor;
import ru.orangedata.orangelib.network.RetrofitSingle;

import javax.annotation.Nullable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class CorrectionRequest {

    public void postCorrection(CorrectionRequestBody requestBody, String derKeyPath, @Nullable PostCallback postCallback) throws IOException {
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
        byte[] data = new byte[0];
        data = Encryptor.signData(textBytes, derKeyPath);
        String signature = Base64.encodeBase64String(data);

        RequestService requestService = RetrofitSingle.getRetrofit().create(RequestService.class);
        Call<Void> call = requestService.postCorrection(signature, requestBody);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                System.out.println("onResponse. Response code: " + response.code());
                switch (response.code()) {
                    case 201:
                        if (postCallback != null) {
                            postCallback.onSuccess();
                        }
                        break;
                    case 401:
                        if (postCallback != null) {
                            postCallback.onRequestFailure(new Throwable("Wrong certificate"));
                        }
                        break;
                    case 409:
                        if (postCallback != null) {
                            postCallback.onRequestFailure(new Throwable("Document with id \"" + requestBody.getId() + "\" already exists"));
                        }
                        break;
                    case 400:
                        if (postCallback != null) {
                            try {
                                PostResponse postResponse = gson.fromJson(response.errorBody().string(), PostResponse.class);
                                postCallback.onValidationErrors(postResponse.getErrors());
                            } catch (IOException e) {
                                e.printStackTrace();
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

    public void getCorrection(String documentId, String inn, GetDocumentCallback callback) {
        RequestService requestService = RetrofitSingle.getRetrofit().create(RequestService.class);
        Call<ResponseBody> call = requestService.getCorrectionState(inn, documentId);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                System.out.println("onResponse. Response code: " + response.code());
                switch (response.code()) {
                    case 200:
                        if (callback != null) {
                            try {
                                callback.onSuccess(response.body().string());
                            } catch (Exception e) {
                                callback.onRequestFailure(e);
                            }
                        }
                        break;
                    case 202:
                        if (callback != null) {
                            callback.onRequestFailure(new Throwable("Check had been created but has not been proceeded"));
                        }
                        break;
                    case 404:
                        if (callback != null) {
                            callback.onRequestFailure(new Throwable("No check found"));
                        }
                        break;
                    case 401:
                        if (callback != null) {
                            callback.onRequestFailure(new Throwable("Unauthorized"));
                        }
                        break;
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                System.out.println("onFailure. throwable: " + throwable.getLocalizedMessage());
                if (callback != null) {
                    callback.onRequestFailure(throwable);
                }
            }
        });
    }

    interface RequestService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("/api/v2/corrections/")
        Call<Void> postCorrection(@Header("X-Signature") String signature, @Body CorrectionRequestBody requestBody);

        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("/api/v2/corrections/{inn}/status/{document_id}")
        Call<ResponseBody> getCorrectionState(@Path("inn") String inn, @Path("document_id") String documentId);
    }
}
