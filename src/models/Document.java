package models;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Alexey Padyukov on 19.06.2017.
 */
public class Document {


    @SerializedName("FfdVersion")
    public int ffdVersion;
    @SerializedName("Type")
    public int type;
    @SerializedName("Positions")
    public List<Bill> positions;
    @SerializedName("CheckClose")
    public CheckClose checkClose;
    @SerializedName("CustomerContact")
    public String customerContact;
    /// <summary>
    ///     Признак агента. Битовое поле, где номер бита обозначает, что оказывающий услугу покупателю (клиенту) пользователь является
    ///     Кассовый чек(БСО) может содержать реквизиты «признак агента» (тег 1057), только если отчет о регистрации и(или) текущий отчет о перерегистрации содержит реквизит «признак агента» (тег 1057), имеющий значение, идентичное значению реквизита «признак агента» (тег 1057) кассового чека.
    /// </summary>
    @SerializedName("AgentType")
    public Integer agentType;

    /// <summary>
    ///     Телефон оператора перевода
    /// </summary>
    @SerializedName("PaymentTransferOperatorPhoneNumbers")
    public String[] paymentTransferOperatorPhoneNumbers;

    /// <summary>
    ///     Операция платежного агента
    /// </summary>
    @SerializedName("PaymentAgentOperation")
    public String paymentAgentOperation;

    /// <summary>
    ///     Телефон платежного агента
    /// </summary>
    @SerializedName("PaymentAgentPhoneNumbers")
    public String[] paymentAgentPhoneNumbers;

    /// <summary>
    ///     Телефон оператора по приему платежей
    /// </summary>
    @SerializedName("PaymentOperatorPhoneNumbers")
    public String[] paymentOperatorPhoneNumbers;

    /// <summary>
    ///     Наименование оператора перевода
    /// </summary>
    @SerializedName("PaymentOperatorName")
    public String paymentOperatorName;

    /// <summary>
    ///     Адрес оператора перевода
    /// </summary>
    @SerializedName("PaymentOperatorAddress")
    public String paymentOperatorAddress;

    /// <summary>
    ///     ИНН оператора перевода
    /// </summary>
    @SerializedName("PaymentOperatorINN")
    public String paymentOperatorINN;

    /// <summary>
    ///     Телефон поставщика
    /// </summary>
    @SerializedName("SupplierPhoneNumbers")
    public String[] supplierPhoneNumbers;

    /// <summary>
    ///     Дополнительный реквизит пользователя
    /// </summary>
    @SerializedName("AdditionalUserAttribute")
    public HashMap<String, String> additionalUserAttribute;

    /// <summary>
    ///     Дополнительный реквизит чека(БСО)
    /// </summary>
    @SerializedName("AdditionalAttribute")
    public String additionalAttribute;

    /// <summary>
    ///     Номер автомата
    /// </summary>
    @SerializedName("AutomatNumber")
    public String automatNumber;

    /// <summary>
    ///     Адрес расчетов
    /// </summary>
    @SerializedName("SettlementAddress")
    public String settlementAddress;

    /// <summary>
    ///     Место расчетов
    /// </summary>
    @SerializedName("SettlementPlace")
    public String settlementPlace;

    /// <summary>
    ///     Покупатель (клиент)
    /// </summary>
    @SerializedName("Customer")
    public String customer;

    /// <summary>
    ///     ИНН покупателя (клиента)
    /// </summary>
    @SerializedName("CustomerINN")
    public String customerINN;

    ///<summary>
    ///     Информация о покупателе (клиенте)
    ///</summary>
    @SerializedName("CustomerInfo")
    public HashMap<String, String> customerInfo;

    /// <summary>
    /// Кассир, 1021
    /// </summary>
    @SerializedName("Cashier")
    public String cashier;

    /// <summary>
    /// ИНН кассира, 1203
    /// </summary>
    @SerializedName("CashierInn")
    public String cashierInn;

    /// <summary>
    /// Адрес электронной почты отправителя чека, 1117
    /// </summary>
    @SerializedName("SenderEmail")
    public String senderEmail;

    /// <summary>
    /// Сумма расчета, указанного в чеке (БСО), 1020.
    /// </summary>
    @SerializedName("TotalSum")
    public Double totalSum;

    /// <summary>
    /// Сумма НДС чека по ставке 20%, 1102
    /// </summary>
    @SerializedName("Vat1Sum")
    public Double vat1Sum;

    /// <summary>
    /// Сумма НДС чека по ставке 10%, 1103
    /// </summary>
    @SerializedName("Vat2Sum")
    public Double vat2Sum;

    /// <summary>
    /// Сумма расчета по чеку с НДС по ставке 0%, 1104
    /// </summary>
    @SerializedName("Vat3Sum")
    public Double vat3Sum;

    /// <summary>
    /// Сумма расчета по чеку без НДС, 1105
    /// </summary>
    @SerializedName("Vat4Sum")
    public Double vat4Sum;

    /// <summary>
    /// Сумма НДС чека по расч. ставке 20/120, 1106
    /// </summary>
    @SerializedName("Vat5Sum")
    public Double vat5Sum;

    /// <summary>
    /// Сумма НДС чека по расч. ставке 10/110, 1107
    /// </summary>
    @SerializedName("Vat6Sum")
    public Double vat6Sum;

    /// <summary>
    /// Операционный реквизит чека
    /// </summary>
    @SerializedName("OperationalAttribute")
    public OperationalAttribute operationalAttribute;

    /// <summary>
    /// Отраслевой реквизит чека
    /// </summary>
    @SerializedName("IndustryAttribute")
    public HashMap<String,String> industryAttribute;

    public Document(int ffdVersion,int type,List<Bill> positions,CheckClose checkClose,String customerContact,
                    Integer agentType,String[] paymentTransferOperatorPhoneNumbers,String paymentAgentOperation,
                    String[] paymentAgentPhoneNumbers,String[] paymentOperatorPhoneNumbers,
                    String paymentOperatorName,String paymentOperatorAddress,String paymentOperatorINN,
                    String[] supplierPhoneNumbers,HashMap<String, String> additionalUserAttribute,String additionalAttribute,
                    String automatNumber,String settlementAddress,String settlementPlace,String customer,
                    String customerINN,HashMap<String, String> customerInfo,String cashier,String cashierInn,
                    String senderEmail,Double totalSum,Double vat1Sum,Double vat2Sum,Double vat3Sum,
                    Double vat4Sum,Double vat5Sum,Double vat6Sum,OperationalAttribute operationalAttribute,HashMap<String,String> industryAttribute) {
        this.type = type;
        this.positions = positions;
        this.checkClose = checkClose;
        this.customerContact = customerContact;
        this.ffdVersion=ffdVersion;
        this.agentType=agentType;
        this.paymentTransferOperatorPhoneNumbers=paymentTransferOperatorPhoneNumbers;
        this.paymentAgentOperation=paymentAgentOperation;
        this.paymentAgentPhoneNumbers=paymentAgentPhoneNumbers;
        this.paymentOperatorPhoneNumbers=paymentOperatorPhoneNumbers;
        this.paymentOperatorName=paymentOperatorName;
        this.paymentOperatorAddress=paymentOperatorAddress;
        this.paymentOperatorINN=paymentOperatorINN;
        this.supplierPhoneNumbers=supplierPhoneNumbers;
        this.additionalUserAttribute=additionalUserAttribute;
        this.additionalAttribute=additionalAttribute;
        this.automatNumber=automatNumber;
        this.settlementAddress=settlementAddress;
        this.settlementPlace=settlementPlace;
        this.customer=customer;
        this.customerINN=customerINN;
        this.customerInfo=customerInfo;
        this.cashier=cashier;
        this.cashierInn=cashierInn;
        this.senderEmail=senderEmail;
        this.totalSum=totalSum;
        this.vat1Sum=vat1Sum;
        this.vat2Sum=vat2Sum;
        this.vat3Sum=vat3Sum;
        this.vat4Sum=vat4Sum;
        this.vat5Sum=vat5Sum;
        this.vat6Sum=vat6Sum;
        this.operationalAttribute=operationalAttribute;
        this.industryAttribute=industryAttribute;
    }

    public int getType() {
        return type;
    }

    public List<Bill> getPositions() {
        return positions;
    }

    public CheckClose getCheckClose() {
        return checkClose;
    }

    public String getCustomerContact() {
        return customerContact;
    }
}
