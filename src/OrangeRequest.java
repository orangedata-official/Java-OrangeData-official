import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.istack.internal.Nullable;
import models.DocumentState;
import models.PostResponse;
import models.RequestBody;
import org.apache.commons.codec.binary.Base64;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by Alexey Padyukov on 19.06.2017.
 */
public class OrangeRequest {



    public void postDocument(RequestBody requestBody, String derKeyPath, @Nullable PostBillCallback postBillCallback) throws IOException {

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

        RequestBody.RequestService requestService = RetrofitSingle.getRetrofit().create(RequestBody.RequestService.class);
        Call<Void> call = requestService.postDocument(signature, requestBody);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                System.out.println("onResponse. Response code: " + response.code());
                switch (response.code()) {
                    case 201:
                        if (postBillCallback != null) {
                            postBillCallback.onSuccess();
                        }
                        break;
                    case 401:
                        if (postBillCallback != null) {
                            postBillCallback.onRequestFailure(new Throwable("Wrong certificate"));
                        }
                        break;
                    case 409:
                        if (postBillCallback != null) {
                            postBillCallback.onRequestFailure(new Throwable("Document with id \"" + requestBody.getId() + "\" already exists"));
                        }
                        break;
                    case 400:
                        if (postBillCallback != null) {
                            try {
                                PostResponse postResponse = gson.fromJson(response.errorBody().string(), PostResponse.class);
                                postBillCallback.onValidationErrors(postResponse.getErrors());
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
                if (postBillCallback != null) {
                    postBillCallback.onRequestFailure(throwable);
                }
            }
        });
    }

    public void getDocument(String documentId, String inn, GetDocumentCallback callback) {
        DocumentState.RequestService requestService = RetrofitSingle.getRetrofit().create(DocumentState.RequestService.class);
        Call<DocumentState> call = requestService.getDocumentState(inn, documentId);
        call.enqueue(new Callback<DocumentState>() {
            @Override
            public void onResponse(Call<DocumentState> call, Response<DocumentState> response) {
                System.out.println("onResponse. Response code: " + response.code());
                switch (response.code()) {
                    case 200:
                        if (callback != null) {
                            callback.onSuccess(response.body());
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
            public void onFailure(Call<DocumentState> call, Throwable throwable) {
                System.out.println("onFailure. throwable: " + throwable.getLocalizedMessage());
                if (callback != null) {
                    callback.onRequestFailure(throwable);
                }
            }
        });
    }


}
