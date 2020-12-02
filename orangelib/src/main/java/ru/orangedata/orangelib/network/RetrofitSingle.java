package ru.orangedata.orangelib.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.annotation.Nullable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alexey Padyukov on 19.06.2017.
 */
public class RetrofitSingle {

    private static String url = "https://apip.orangedata.ru:2443";

    private static Retrofit retrofit;

    public static Retrofit getRetrofit(@Nullable String setUrl) {
        if (retrofit == null || (url != null && !url.equals(setUrl))) {
            url = setUrl != null ? setUrl : url;
            createRetrofit();
        }
        return retrofit;
    }

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            createRetrofit();
        }
        return retrofit;
    }

    private static void createRetrofit() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();
        OkHttpClient client = new CustomTrust().getClient();
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
    }

}
