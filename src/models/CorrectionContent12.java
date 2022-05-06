package models;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;
import java.util.function.DoubleToIntFunction;

public class CorrectionContent12 {
    ///     Номер версии ФФД, 1209(ФФД 1.2 - 4)
    @SerializedName("FfdVersion")
    public Integer ffdVersion;

    ///     Признак расчета
    @SerializedName("Type")
    public Integer type;

    ///     Список предметов расчета
    @SerializedName("Positions")
    public List<Bill> positions;

    ///     Параметры закрытия чека
    @SerializedName("CheckClose")
    public CheckClose checkClose;

    ///     Телефон или e-mail покупателя
    @SerializedName("CustomerContact")
    public String customerContact;

    ///     Тип коррекции
    @SerializedName("CorrectionType")
    public Integer correctionType;

    ///     Дата документа основания для коррекции
    ///     В данном реквизите время всегда указывать, как 00:00:00
    @SerializedName("CauseDocumentDate")
    public String causeDocumentDate;

    ///     Номер документа основания для коррекции
    @SerializedName("CauseDocumentNumber")
    public String causeDocumentNumber;

    ///     Дополнительный реквизит пользователя
    @SerializedName("AdditionalUserAttribute")
    public Map<String, String> additionalUserAttribute;

    ///     Дополнительный реквизит чека(БСО)
    @SerializedName("AdditionalAttribute")
    public String additionalAttribute;

    ///     Номер автомата
    @SerializedName("AutomatNumber")
    public String automatNumber;

    ///     Адрес расчетов
    @SerializedName("SettlementAddress")
    public String settlementAddress;

    ///     Место расчетов
    @SerializedName("SettlementPlace")
    public String settlementPlace;

    /// Кассир, 1021
    @SerializedName("Cashier")
    public String cashier;

    /// ИНН кассира, 1203
    @SerializedName("CashierInn")
    public String cashierInn;

    /// Адрес электронной почты отправителя чека, 1117
    @SerializedName("SenderEmail")
    public String senderEmail;

    ///     Сумма расчета, указанного в чеке (БСО
    @SerializedName("TotalSum")
    public Double totalSum;

    /// Сумма НДС чека по ставке 20%, 1102
    @SerializedName("Vat1Sum")
    public Double vat1Sum;

    /// Сумма НДС чека по ставке 10%, 1103
    @SerializedName("Vat2Sum")
    public Double vat2Sum;

    /// Сумма расчета по чеку с НДС по ставке 0%, 1104
    @SerializedName("Vat3Sum")
    public Double vat3Sum;

    /// Сумма расчета по чеку без НДС, 1105
    @SerializedName("Vat4Sum")
    public Double vat4Sum;

    /// Сумма НДС чека по расч. ставке 20/120, 1106
    @SerializedName("Vat5Sum")
    public Double vat5Sum;

    /// Сумма НДС чека по расч. ставке 10/110, 1107
    @SerializedName("Vat6Sum")
    public Double vat6Sum;

    ///     Информация о покупателе (клиенте)
    @SerializedName("CustomerInfo")
    public Map<String, String> customerInfo;

    /// Операционный реквизит чека
    @SerializedName("OperationalAttribute")
    public OperationalAttribute operationalAttribute;

    /// Отраслевой реквизит чека
    @SerializedName("IndustryAttribute")
    public Map<String, String> industryAttribute;

    public CorrectionContent12(Integer ffdVersion, Integer type, List<Bill> positions, CheckClose checkClose,
                               String customerContact, Integer correctionType, String causeDocumentDate,
                               String causeDocumentNumber, Map<String,String> additionalUserAttribute,
                               String additionalAttribute, String automatNumber, String settlementAddress,
                               String settlementPlace, String cashier, String cashierInn, String senderEmail,
                               Double totalSum, Double vat1Sum,Double vat2Sum,Double vat3Sum,
                               Double vat4Sum,Double vat5Sum,Double vat6Sum,Map<String,String> customerInfo,
                               OperationalAttribute operationalAttribute,Map<String,String> industryAttribute){
        this.ffdVersion=ffdVersion;
        this.type=type;
        this.positions=positions;
        this.checkClose=checkClose;
        this.customerContact=customerContact;
        this.correctionType=correctionType;
        this.causeDocumentDate=causeDocumentDate;
        this.causeDocumentNumber=causeDocumentNumber;
        this.additionalUserAttribute=additionalUserAttribute;
        this.additionalAttribute=additionalAttribute;
        this.automatNumber=automatNumber;
        this.cashier=cashier;
        this.cashierInn=cashierInn;
        this.settlementAddress=settlementAddress;
        this.settlementPlace=settlementPlace;
        this.senderEmail=senderEmail;
        this.totalSum=totalSum;
        this.vat1Sum=vat1Sum;
        this.vat2Sum=vat2Sum;
        this.vat3Sum=vat3Sum;
        this.vat4Sum=vat4Sum;
        this.vat5Sum=vat5Sum;
        this.vat6Sum=vat6Sum;
        this.customerInfo=customerInfo;
        this.operationalAttribute=operationalAttribute;
        this.industryAttribute=industryAttribute;
    }
}
