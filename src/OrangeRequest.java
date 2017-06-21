import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.PostResponse;
import models.RequestBody;
import org.apache.commons.codec.binary.Base64;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.annotation.Nullable;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

/**
 * Created by Alexey Padyukov on 19.06.2017.
 */
public class OrangeRequest {

    public void post(RequestBody requestBody, @Nullable PostBillCallback postBillCallback) throws IOException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        byte[] textBytes = gson.toJson(requestBody).getBytes("UTF-8");
        byte[] data = Encryptor.signData(textBytes, Encryptor.getRSAKey());
        String signature = Base64.encodeBase64String(data);

        RequestBody.RequestService requestService = RetrofitSingle.getRetrofit().create(RequestBody.RequestService.class);
        Call<PostResponse> call = requestService.postDocument(signature, requestBody);
        call.enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
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
            public void onFailure(Call<PostResponse> call, Throwable throwable) {
                System.out.println("onFailure. throwable: " + throwable.getLocalizedMessage());
                if (postBillCallback != null) {
                    postBillCallback.onRequestFailure(throwable);
                }
            }
        });
    }

}
