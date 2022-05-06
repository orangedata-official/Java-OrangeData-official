package models;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public class RespKKTDevicesStatus {
    /// <summary>
    ///     Список устройств в группе
    /// </summary>
    public DeviceInfo[] devices;

    /// <summary>
    ///     Массив ошибок обработки запроса
    /// </summary>
    public List<String> errors;

    public interface RequestService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("/api/v2/devices/status/{inn}/{groupName}")
        Call<RespKKTDevicesStatus> getDevices(@Path("inn") String inn, @Path("groupName") String groupName);
    }
}
