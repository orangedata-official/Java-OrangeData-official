package models;

import com.google.gson.annotations.SerializedName;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

import java.util.Date;

public class CorrectionState {
    //Идентификатор документа
    //Строка от 1 до 32 символов
    public String id;

    //Заводской номер устройства пробившего чек
    //Строка до 20 символов
    public String deviceSN;

    //Регистрационный номер устройства пробившего чек
    //Строка до 20 символов
    public String deviceRN;

    //Номер фискального накопителя
    //Строка 16 символов
    public String fsNumber;

    //Наименование ОФД
    //Строка до 256 символов
    public String ofdName;

    //Web-сайт ОФД
    //Строка до 58? символов
    public String ofdWebsite;

    //ИНН ОФД
    //Строка 12 символов
    @SerializedName("odfINN")
    public String ofdInn;

    //Web-сайт ФНС
    //Строка до 256 символов
    public String fnsWebsite;

    //ИНН пользователя
    //Строка 12 символов
    public String companyINN;

    //Наименование пользователя
    //Строка до 256 символов
    public String companyName;

    //Номер ФД
    //Число
    public int documentNumber;

    //Номер смены
    //Число
    public int shiftNumber;

    //Номер чека за смену
    //Число
    public int documentIndex;

    //Время регистрации фискального документа в ФН
    //Время в виде строки в формате yyyy-MM-dd'T'HH:mm:ss
    public String processedAt;

    //Содержимое документа
    //Структура Document
    public CorrectionContent content;

    //Фискальный признак
    //Строка 10 символов
    public int fp;

    //URL для отправки результатов обработки чека
    //POST запросом
    public String callbackUrl;

    //Метаданные запроса 
    public String meta;

    public interface RequestService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("/api/v2/corrections/{inn}/status/{document_id}")
        Call<CorrectionState> getDocumentState(@Path("inn") String inn, @Path("document_id") String documentId);
    }
}
