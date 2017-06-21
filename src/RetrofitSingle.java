import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.annotation.Nullable;

/**
 * Created by Alexey Padyukov on 19.06.2017.
 */
public class RetrofitSingle {

    private static String url = "https://46.28.89.45:2443";

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

        OkHttpClient client = new CustomTrust().getClient();
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

}
