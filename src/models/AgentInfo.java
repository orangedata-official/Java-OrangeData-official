package models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AgentInfo {
    /// <summary>
    ///     Телефон оператора перевода
    /// </summary>
    @SerializedName("PaymentTransferOperatorPhoneNumbers")
    public List<String> paymentTransferOperatorPhoneNumbers ;

    /// <summary>
    ///     Операция платежного агента
    /// </summary>
    @SerializedName("PaymentAgentOperation")
    public String paymentAgentOperation ;

    /// <summary>
    ///     Телефон платежного агента
    /// </summary>
    @SerializedName("PaymentAgentPhoneNumbers")
    public List<String> paymentAgentPhoneNumbers ;

    /// <summary>
    ///     Телефон оператора по приему платежей
    /// </summary>
    @SerializedName("PaymentOperatorPhoneNumbers")
    public List<String> paymentOperatorPhoneNumbers ;

    /// <summary>
    ///    Наименование оператора перевода
    /// </summary>
    @SerializedName("PaymentOperatorName")
    public String paymentOperatorName ;

    /// <summary>
    ///     Адрес оператора перевода
    /// </summary>
    @SerializedName("PaymentOperatorAddress")
    public String paymentOperatorAddress ;

    /// <summary>
    ///     ИНН оператора перевода
    /// </summary>
    @SerializedName("PaymentOperatorINN")
    public String paymentOperatorINN ;

    public AgentInfo(List<String> paymentTransferOperatorPhoneNumbers,
                     String paymentAgentOperation,
                     List<String> paymentAgentPhoneNumbers,
                     List<String> paymentOperatorPhoneNumbers,
                     String paymentOperatorName,
                     String paymentOperatorAddress,
                     String paymentOperatorINN) {
        this.paymentTransferOperatorPhoneNumbers=paymentTransferOperatorPhoneNumbers;
        this.paymentAgentOperation = paymentAgentOperation;
        this.paymentAgentPhoneNumbers=paymentAgentPhoneNumbers;
        this.paymentOperatorPhoneNumbers=paymentOperatorPhoneNumbers;
        this.paymentOperatorName=paymentOperatorName;
        this.paymentOperatorAddress=paymentOperatorAddress;
        this.paymentOperatorINN=paymentOperatorINN;
    }
}
