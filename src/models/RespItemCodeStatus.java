package models;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public class RespItemCodeStatus {

    ///     Идентификатор документа
    public String Id;

    ///     Заводской номер устройства пробившего чек
    public String DeviceSN;

    ///     Регистрационный номер устройства пробившего чек
    public String DeviceRN;

    ///     Номер фискального накопителя
    public String FSNumber;

    ///     Время регистрации фискального документа в ФН
    public String ProcessedAt;

    ///     Содержимое документа
    public ItemCodeContent Content;

    ///     Результат проверки
    public CheckKMResultBody CheckResult;

    /// URL для отправки результатов обработки чека POST запросом
    public String CallbackUrl;

    /// Метаданные запроса
    public String Meta;

    public interface RequestService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("/api/v2/itemcode/{inn}/status/{documentId}")
        Call<RespItemCodeStatus> getItemCodeStatus(@Path("inn") String inn, @Path("documentId") String documentId);
    }
}
