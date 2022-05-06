package models;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.http.*;


/**
 * Created by Alexey Padyukov on 19.06.2017.
 */
public class RequestBody {

    //Строка от 1 до 32 символов
    @SerializedName("Id")
    private String id;
    //Строка 12 символов
    @SerializedName("INN")
    private String inn;
    //Строка от 1 до 32 символов или null
    @SerializedName("Group")
    @Nullable private String group;
    //Структура Document
    @SerializedName("Content")
    private Document content;
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

    /// <summary>
    /// Метаданные запроса
    /// </summary>
    @SerializedName("Meta")
    @Nullable public String meta;

    /// Флаг указывающий стоит ли игнорировать проверку КМ
    @SerializedName("IgnoreItemCodeCheck")
    @Nullable public Boolean ignoreItemCodeCheck;

    public RequestBody(String id, String inn, Document content) {
        this.id = id;
        this.inn = inn;
        this.content = content;
    }

    public RequestBody(String id, String inn, @Nullable String group, Document content,@Nullable String key,
                       @Nullable String callbackUrl,@Nullable String meta, @Nullable Boolean ignoreItemCodeCheck ) {
        this.id = id;
        this.inn = inn;
        this.group = group;
        this.content = content;
        this.key=key;
        this.callbackUrl=callbackUrl;
        this.meta=meta;
        if(ignoreItemCodeCheck==null)
            this.ignoreItemCodeCheck=false;
        else
            this.ignoreItemCodeCheck=ignoreItemCodeCheck;
    }

    public String getId() {
        return id;
    }

    public String getInn() {
        return inn;
    }

    public String getGroup() {
        return group;
    }

    public Document getContent() {
        return content;
    }

    public interface RequestService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("/api/v2/documents")
        Call<Void> postDocument(@Header("X-Signature") String signature, @Body RequestBody requestBody);
    }

}