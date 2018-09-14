package models;

import com.google.gson.annotations.SerializedName;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

import java.util.Date;

/**
 * Created by Alexey Padyukov on 19.06.2017.
 */
public class DocumentState {

    //Идентификатор документа
    //Строка от 1 до 32 символов
    private String id;

    //Заводской номер устройства пробившего чек
    //Строка до 20 символов
    private String deviceSN;

    //Регистрационный номер устройства пробившего чек
    //Строка до 20 символов
    private String deviceRN;

    //Номер фискального накопителя
    //Строка 16 символов
    private String fsNumber;

    //Наименование ОФД
    //Строка до 256 символов
    private String ofdName;

    //Web-сайт ОФД
    //Строка до 58? символов
    private String ofdWebsite;

    //ИНН ОФД
    //Строка 12 символов
    @SerializedName("odfINN")
    private String ofdInn;

    //Web-сайт ФНС
    //Строка до 256 символов
    private String fnsWebsite;

    //ИНН пользователя
    //Строка 12 символов
    private String companyINN;

    //Наименование пользователя
    //Строка до 256 символов
    private String companyName;

    //Номер ФД
    //Число
    private int documentNumber;

    //Номер смены
    //Число
    private int shiftNumber;

    //Номер чека за смену
    //Число
    private int documentIndex;

    //Время регистрации фискального документа в ФН
    //Время в виде строки в формате ISO8601
    private Date processedAt;

    //Содержимое документа
    //Структура Document
    private Document content;

    //Сдача
    //Десятичное число с точностью до 2 символов после точки
    private int change;

    //Фискальный признак
    //Строка 10 символов
    private int fp;

    public String getId() {
        return id;
    }

    public String getDeviceSN() {
        return deviceSN;
    }

    public String getDeviceRN() {
        return deviceRN;
    }

    public String getFsNumber() {
        return fsNumber;
    }

    public String getOfdName() {
        return ofdName;
    }

    public String getOfdWebsite() {
        return ofdWebsite;
    }

    public String getOfdInn() {
        return ofdInn;
    }

    public String getFnsWebsite() {
        return fnsWebsite;
    }

    public String getCompanyINN() {
        return companyINN;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getDocumentNumber() {
        return documentNumber;
    }

    public int getShiftNumber() {
        return shiftNumber;
    }

    public int getDocumentIndex() {
        return documentIndex;
    }

    public Date getProcessedAt() {
        return processedAt;
    }

    public Document getContent() {
        return content;
    }

    public int getChange() {
        return change;
    }

    public int getFp() {
        return fp;
    }


    public interface RequestService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("/api/v2/documents/{inn}/status/{document_id}")
        Call<DocumentState> getDocumentState(@Path("inn") String inn, @Path("document_id") String documentId);
    }

}
