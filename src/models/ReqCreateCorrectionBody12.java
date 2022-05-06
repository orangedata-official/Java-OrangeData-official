package models;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public class ReqCreateCorrectionBody12 {
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
    public CorrectionContent12 content;
    ///     Название ключа который должен быть использован для проверки подпись.
    ///     Опциональный параметр.
    ///     Если имя ключа не указано для проверки подписи будет использован ключ, заданный по умолчанию.
    @SerializedName("Key")
    @Nullable public String key;

    /// URL для отправки результатов обработки чека POST запросом
    @SerializedName("CallbackUrl")
    @Nullable public String callbackUrl;

    /// Метаданные запроса
    @SerializedName("Meta")
    @Nullable public String meta;

    /// Флаг указывающий стоит ли игнорировать проверку КМ
    @SerializedName("IgnoreItemCodeCheck")
    @Nullable public Boolean ignoreItemCodeCheck;

    public ReqCreateCorrectionBody12(String id, String inn, @Nullable String group, CorrectionContent12 content,@Nullable String key,
                                   @Nullable String callbackUrl,@Nullable String meta,@Nullable Boolean ignoreItemCodeCheck){
        this.id=id;
        this.inn=inn;
        this.group = group;
        this.content = content;
        this.key=key;
        this.callbackUrl=callbackUrl;
        this.meta=meta;
        if(ignoreItemCodeCheck==null)
            this.ignoreItemCodeCheck=false;
        else
            this.ignoreItemCodeCheck = ignoreItemCodeCheck;
    }

    public interface RequestService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("/api/v2/correction12")
        Call<Void> postDocument(@Header("X-Signature") String signature, @Body ReqCreateCorrectionBody12 requestBody);
    }
}
