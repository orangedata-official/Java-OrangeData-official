package models;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public class ReqCreateCorrectionBody {
    //Строка от 1 до 32 символов
    @SerializedName("Id")
    public String id;
    //Строка 12 символов
    @SerializedName("INN")
    public String inn;
    //Строка от 1 до 32 символов или null
    @SerializedName("Group")
    @Nullable
    public String group;
    //Структура Document
    @SerializedName("Content")
    public CorrectionContent content;
    ///     Название ключа который должен быть использован для проверки подпись.
    ///     Опциональный параметр.
    ///     Если имя ключа не указано для проверки подписи будет использован ключ, заданный по умолчанию.
    @SerializedName("Key")
    @Nullable public String key;

    /// <summary>
    /// URL для отправки результатов обработки чека POST запросом
    /// </summary>
    @SerializedName("CallbackUrl")
    @Nullable public String callbackUrl;

    public ReqCreateCorrectionBody(String id, String inn, @Nullable String group, CorrectionContent content,@Nullable String key,
                                   @Nullable String callbackUrl){
        this.id=id;
        this.inn=inn;
        this.group = group;
        this.content = content;
        this.key=key;
        this.callbackUrl=callbackUrl;
    }

    public interface RequestService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("/api/v2/corrections")
        Call<Void> postDocument(@Header("X-Signature") String signature, @Body ReqCreateCorrectionBody requestBody);
    }
}
