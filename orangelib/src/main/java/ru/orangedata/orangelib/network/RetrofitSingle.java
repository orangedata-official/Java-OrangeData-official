package ru.orangedata.orangelib.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.annotation.Nullable;

public class RetrofitSingle {

    private static final String PROD_ENDPOINT = "https://api.orangedata.ru:12003";

    public static Retrofit getRetrofit(@Nullable String url) {
        if ((url != null)) {
            return createRetrofit(url);
        } else {
            return createRetrofit(PROD_ENDPOINT);
        }
    }

    private static Retrofit createRetrofit(String url) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();
        OkHttpClient client = new CustomTrust().getClient();
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
    }

}
