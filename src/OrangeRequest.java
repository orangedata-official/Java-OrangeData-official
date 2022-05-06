import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import models.*;
import org.jetbrains.annotations.Nullable;
import org.apache.commons.codec.binary.Base64;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * Created by Alexey Padyukov on 19.06.2017.
 */
public class OrangeRequest {



    public void postDocument(RequestBody requestBody, String derKeyPath, @Nullable PostBillCallback postBillCallback) throws IOException {

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.disableHtmlEscaping().create();
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
                    case 503:
                        if (postBillCallback != null) {
                            postBillCallback.onRequestFailure(new Throwable(" Service Unavailable"));
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

    public void postCorrection(ReqCreateCorrectionBody requestBody, String keyPath, @Nullable PostBillCallback postBillCallback) throws IOException {

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        byte[] textBytes = new byte[0];
        try {

            String text=gson.toJson(requestBody);
            textBytes = text.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] data = new byte[0];
        data = Encryptor.signData(textBytes, keyPath);
        String signature = Base64.encodeBase64String(data);

        ReqCreateCorrectionBody.RequestService requestService = RetrofitSingle.getRetrofit().create(ReqCreateCorrectionBody.RequestService.class);
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
                            postBillCallback.onRequestFailure(new Throwable("Document with id \"" + requestBody.id + "\" already exists"));
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
                    case 503:
                        if (postBillCallback != null) {
                            postBillCallback.onRequestFailure(new Throwable(" Service Unavailable"));
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

    public void postCorrection12(ReqCreateCorrectionBody12 requestBody, String keyPath, @Nullable PostBillCallback postBillCallback) throws IOException {

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.disableHtmlEscaping().create();
        byte[] textBytes = new byte[0];
        try {
            String text= gson.toJson(requestBody);
            textBytes = text.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] data = new byte[0];
        data = Encryptor.signData(textBytes, keyPath);
        String signature = Base64.encodeBase64String(data);

        ReqCreateCorrectionBody12.RequestService requestService = RetrofitSingle.getRetrofit().create(ReqCreateCorrectionBody12.RequestService.class);
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
                            postBillCallback.onRequestFailure(new Throwable("Document with id \"" + requestBody.id + "\" already exists"));
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
                    case 503:
                        if (postBillCallback != null) {
                            postBillCallback.onRequestFailure(new Throwable(" Service Unavailable"));
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
                    case 422:
                        if (callback != null) {
                            try {
                                String errors=response.errorBody().string();
                                callback.onRequestFailure(new Throwable(errors));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case 401:
                        if (callback != null) {
                            callback.onRequestFailure(new Throwable("Unauthorized"));
                        }
                        break;
                    case 400,404:
                        if (callback != null) {
                            callback.onRequestFailure(new Throwable("No check found"));
                        }
                        break;
                    case 524:
                        if (callback != null) {
                            callback.onRequestFailure(new Throwable("Document Expired Before Processing"));
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

    public void getCorrectionState(String documentId, String inn, GetCorrectionCallback callback) {
        CorrectionState.RequestService requestService = RetrofitSingle.getRetrofit().create(CorrectionState.RequestService.class);
        Call<CorrectionState> call = requestService.getDocumentState(inn, documentId);
        call.enqueue(new Callback<CorrectionState>() {
            @Override
            public void onResponse(Call<CorrectionState> call, Response<CorrectionState> response) {
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
                    case 400,404:
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
            public void onFailure(Call<CorrectionState> call, Throwable throwable) {
                System.out.println("onFailure. throwable: " + throwable.getLocalizedMessage());
                if (callback != null) {
                    callback.onRequestFailure(throwable);
                }
            }
        });


    }

    public void getCorrectionState12(String documentId, String inn, GetCorrectionCallback12 callback) {
        CorrectionState12.RequestService requestService = RetrofitSingle.getRetrofit().create(CorrectionState12.RequestService.class);
        Call<CorrectionState12> call = requestService.getDocumentState(inn, documentId);
        call.enqueue(new Callback<CorrectionState12>() {
            @Override
            public void onResponse(Call<CorrectionState12> call, Response<CorrectionState12> response) {
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
                    case 400,404:
                        if (callback != null) {
                            callback.onRequestFailure(new Throwable("No check found"));
                        }
                        break;
                    case 401:
                        if (callback != null) {
                            callback.onRequestFailure(new Throwable("Unauthorized"));
                        }
                        break;
                    case 422:
                        if (callback != null) {
                            try {
                                String errors=response.errorBody().string();
                                callback.onRequestFailure(new Throwable(errors));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case 524:
                        if (callback != null) {
                            callback.onRequestFailure(new Throwable("Document Expired Before Processing"));
                        }
                        break;
                }
            }

            @Override
            public void onFailure(Call<CorrectionState12> call, Throwable throwable) {
                System.out.println("onFailure. throwable: " + throwable.getLocalizedMessage());
                if (callback != null) {
                    callback.onRequestFailure(throwable);
                }
            }
        });
    }

    public void getAccessState(ReqAccessStatus requestBody, String keyPath, @Nullable PostBillCallback postBillCallback) throws IOException {

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        byte[] textBytes = new byte[0];
        try {
            textBytes = gson.toJson(requestBody).getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] data = new byte[0];
        data = Encryptor.signData(textBytes, keyPath);
        String signature = Base64.encodeBase64String(data);

        ReqAccessStatus.RequestService requestService = RetrofitSingle.getRetrofit().create(ReqAccessStatus.RequestService.class);
        Call<Void> call = requestService.postDocument(signature, requestBody);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                System.out.println("onResponse. Response code: " + response.code());
                switch (response.code()) {
                    case 200:
                        if (postBillCallback != null) {
                            postBillCallback.onSuccess();
                        }
                        break;
                    case 401:
                        if (postBillCallback != null) {
                            postBillCallback.onRequestFailure(new Throwable("Wrong certificate"));
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

    public void getKKTDeviceState(String inn,String groupName, GetDevicesCallback callback) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        RespKKTDevicesStatus.RequestService requestService = RetrofitSingle.getRetrofit().create(RespKKTDevicesStatus.RequestService.class);
        Call<RespKKTDevicesStatus> call = requestService.getDevices(inn, groupName);
        call.enqueue(new Callback<RespKKTDevicesStatus>() {
            @Override
            public void onResponse(Call<RespKKTDevicesStatus> call, Response<RespKKTDevicesStatus> response) {
                System.out.println("onResponse. Response code: " + response.code());
                switch (response.code()) {
                    case 200:
                        if (callback != null) {
                            callback.onSuccess(response.body());
                        }
                        break;
                    case 400:
                        if (callback != null) {
                            try {
                                String errors="";
                                PostResponse postResponse = gson.fromJson(response.errorBody().string(), PostResponse.class);
                                for(String err: postResponse.getErrors())
                                    errors+=err+"\n";
                                callback.onRequestFailure(new Throwable(errors));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
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
            public void onFailure(Call<RespKKTDevicesStatus> call, Throwable throwable) {
                System.out.println("onFailure. throwable: " + throwable.getLocalizedMessage());
                if (callback != null) {
                    callback.onRequestFailure(throwable);
                }
            }
        });
    }

    public void postItemCodeCheck(ReqItemCodeCheck requestBody, String keyPath, @Nullable PostBillCallback postBillCallback) throws IOException {

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        byte[] textBytes = new byte[0];
        try {
            textBytes = gson.toJson(requestBody).getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] data = new byte[0];
        data = Encryptor.signData(textBytes, keyPath);
        String signature = Base64.encodeBase64String(data);

        ReqItemCodeCheck.RequestService requestService = RetrofitSingle.getRetrofit().create(ReqItemCodeCheck.RequestService.class);
        Call<Void> call = requestService.postItemcode(signature, requestBody);
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
                    case 409:
                        if (postBillCallback != null) {
                            postBillCallback.onRequestFailure(new Throwable("Document with id \"" + requestBody.id + "\" already exists"));
                        }
                        break;
                    case 503:
                        if (postBillCallback != null) {
                            postBillCallback.onRequestFailure(new Throwable(" Service Unavailable"));
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

    public void getItemCodeState(String inn,String documentId, GetItemCodeStateCallback callback) {
        RespItemCodeStatus.RequestService requestService = RetrofitSingle.getRetrofit().create(RespItemCodeStatus.RequestService.class);
        Call<RespItemCodeStatus> call = requestService.getItemCodeStatus(inn, documentId);
        call.enqueue(new Callback<RespItemCodeStatus>() {
            @Override
            public void onResponse(Call<RespItemCodeStatus> call, Response<RespItemCodeStatus> response) {
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
                    case 400,404:
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
            public void onFailure(Call<RespItemCodeStatus> call, Throwable throwable) {
                System.out.println("onFailure. throwable: " + throwable.getLocalizedMessage());
                if (callback != null) {
                    callback.onRequestFailure(throwable);
                }
            }
        });
    }
}
