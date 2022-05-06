package models;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public class ReqAccessStatus {
    /// <summary>
    ///     ИНН организации, для которой пробивается чек
    /// </summary>
    public String inn;

    /// <summary>
    ///     Группа устройств, с помощью которых будет пробит чек
    /// </summary>
    public String group;

    /// <summary>
    ///     Название ключа
    /// </summary>
    public String key;

    public ReqAccessStatus(String inn,String group,String key){
        this.inn=inn;
        this.group=group;
        this.key=key;
    }

    public interface RequestService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("/api/v2/check")
        Call<Void> postDocument(@Header("X-Signature") String signature, @Body ReqAccessStatus requestBody);
    }
}
