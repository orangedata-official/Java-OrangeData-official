package models;

import com.google.gson.annotations.SerializedName;
import retrofit2.Call;
import retrofit2.http.Field;
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
    @SerializedName("Id")
    private String id;

    //Заводской номер устройства пробившего чек
    //Строка до 20 символов
    @SerializedName("DeviceSN")
    private String deviceSN;

    //Регистрационный номер устройства пробившего чек
    //Строка до 20 символов
    @SerializedName("DeviceRN")
    private String deviceRN;

    //Номер фискального накопителя
    //Строка 16 символов
    @SerializedName("FSNumber")
    private String fsNumber;

    //Наименование ОФД
    //Строка до 256 символов
    @SerializedName("OFDName")
    private String ofdName;

    //Web-сайт ОФД
    //Строка до 58? символов
    @SerializedName("OFDWebsite")
    private String ofdWebsite;

    //ИНН ОФД
    //Строка 12 символов
    @SerializedName("OFDINN")
    private String ofdInn;

    //Web-сайт ФНС
    //Строка до 256 символов
    @SerializedName("FNSWebsite")
    private String fnsWebsite;

    //ИНН пользователя
    //Строка 12 символов
    @SerializedName("CompanyINN")
    private String companyINN;

    //Наименование пользователя
    //Строка до 256 символов
    @SerializedName("CompanyName")
    private String companyName;

    //Номер ФД
    //Число
    @SerializedName("DocumentNumber")
    private int documentNumber;

    //Номер смены
    //Число
    @SerializedName("ShiftNumber")
    private int shiftNumber;

    //Номер чека за смену
    //Число
    @SerializedName("DocumentIndex")
    private int documentIndex;

    //Время регистрации фискального документа в ФН
    //Время в виде строки в формате ISO8601
    @SerializedName("ProcessedAt")
    private Date processedAt;

    //Содержимое документа
    //Структура Document
    @SerializedName("Content")
    private Document content;

    //Сдача
    //Десятичное число с точностью до 2 символов после точки
    @SerializedName("Change")
    private int change;

    //Фискальный признак
    //Строка 10 символов
    @SerializedName("FP")
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
