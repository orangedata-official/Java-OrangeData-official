package models;

import com.google.gson.annotations.SerializedName;
import com.sun.istack.internal.Nullable;
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

    public RequestBody(String id, String inn, Document content) {
        this.id = id;
        this.inn = inn;
        this.content = content;
    }

    public RequestBody(String id, String inn, @Nullable String group, Document content) {
        this.id = id;
        this.inn = inn;
        this.group = group;
        this.content = content;
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
        @POST("/api/v2/documents/")
        Call<Void> postDocument(@Header("X-Signature") String signature, @Body RequestBody requestBody);
    }

}