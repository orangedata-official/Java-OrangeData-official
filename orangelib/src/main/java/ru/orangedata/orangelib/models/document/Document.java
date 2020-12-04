package ru.orangedata.orangelib.models.document;

import com.google.gson.annotations.SerializedName;
import ru.orangedata.orangelib.models.Validator;

import javax.annotation.Nullable;
import java.util.List;

public class Document extends Validator {

    /**
     * Признак расчета, 1054
     * Число. Параметр обязательный.
     */
    @SerializedName("type")
    private int type;

    /**
     * Список предметов расчета, 1059
     * Массив структур п.2.1.1.2
     */
    @SerializedName("positions")
    private List<Bill> positions;

    /**
     * Параметры закрытия чека
     * Структура п.2.1.1.3
     */
    @SerializedName("checkClose")
    private CheckClose checkClose;

    /**
     * Телефон или электронный адрес покупателя, 1008
     * Строка от 1 до 64 символов, формат +{Ц} или {С}@{C}. Параметр обязательный.
     */

    @SerializedName("customerContact")
    private String customerContact;

    /**
     * Признак агента, 1057
     * Число от 1 до 127, необязательное поле
     */
    @Nullable
    @SerializedName("agentType")
    private Integer agentType;

    /**
     * Телефон оператора перевода, 1075
     * Массив строк длиной от 1 до 19 символов, формат +{Ц}, необязательное поле
     */
    @Nullable
    @SerializedName("paymentTransferOperatorPhoneNumbers")
    private List<String> paymentTransferOperatorPhoneNumbers;

    /**
     * Операция платежного агента, 1044
     * Строка длиной от 1 до 24 символов, необязательное поле
     */
    @Nullable
    @SerializedName("paymentAgentOperation")
    private String paymentAgentOperation;

    /**
     * Телефон платежного агента, 1073
     * Массив строк длиной от 1 до 19 символов, формат +{Ц}, необязательное поле
     */
    @Nullable
    @SerializedName("paymentAgentPhoneNumbers")
    private List<String> paymentAgentPhoneNumbers;

    /**
     * Телефон оператора по приему платежей, 1074
     * Массив строк длиной от 1 до 19 символов, формат +{Ц}, необязательное поле
     */
    @Nullable
    @SerializedName("paymentOperatorPhoneNumbers")
    private List<String> paymentOperatorPhoneNumbers;

    /**
     * Наименование оператора перевода, 1026
     * Строка длиной от 1 до 64 символов, необязательное поле
     */
    @Nullable
    @SerializedName("paymentOperatorName")
    private String paymentOperatorName;

    /**
     * Адрес оператора перевода, 1005
     * Строка длиной от 1 до 243 символов, необязательное поле
     */
    @Nullable
    @SerializedName("paymentOperatorAddress")
    private String paymentOperatorAddress;

    /**
     * ИНН оператора перевода, 1016
     * Строка длиной от 10 до 12 символов, формат ЦЦЦЦЦЦЦЦЦЦ, необязательное поле
     */
    @Nullable
    @SerializedName("paymentOperatorINN")
    private String paymentOperatorINN;

    /**
     * Телефон поставщика, 1171
     * Массив строк длиной от 1 до 19 символов, формат +{Ц}, необязательное поле
     */
    @Nullable
    @SerializedName("supplierPhoneNumbers")
    private List<String> supplierPhoneNumbers;

    /**
     * Дополнительный реквизит пользователя, 1084
     * Структура п.2.1.1.5, необязательное поле
     */
    @Nullable
    @SerializedName("additionalUserAttribute")
    private List<AdditionalUserAttribute> additionalUserAttribute;

    /**
     * Дополнительный реквизит чека(БСО), 1192
     * Строка от 1 до 16 символов, необязательное поле
     */
    @Nullable
    @SerializedName("additionalAttribute")
    private String additionalAttribute;

    /**
     * Номер автомата, 1036
     * Строка длиной от 1 до 20 символов, обязательное поле, если группа имеет признак передачи данных автомата, в противном случае не должно передаваться.
     * Только для вендинга и транспорта.
     */
    @Nullable
    @SerializedName("automatNumber")
    private String automatNumber;

    /**
     * Адрес расчетов, 1009
     * Строка длиной от 1 до 243 символов, обязательное поле, если группа имеет признак передачи данных автомата, в противном случае не должно передаваться.
     * Только для вендинга и транспорта.
     */
    @Nullable
    @SerializedName("settlementAddress")
    private String settlementAddress;

    /**
     * Место расчетов, 1187
     * Строка длиной от 1 до 243 символов, обязательное поле, если группа имеет признак передачи данных автомата, в противном случае не должно передаваться.
     * Только для вендинга и транспорта.
     */
    @Nullable
    @SerializedName("settlementPlace")
    private String settlementPlace;

    /**
     * Покупатель (клиент), 1227
     * Строка от 1 до 243 символов, необязательное поле
     */
    @Nullable
    @SerializedName("customer")
    private String customer;

    /**
     * ИНН покупателя (клиента), 1228
     * Строка длиной от 10 до 12 символов, формат ЦЦЦЦЦЦЦЦЦЦ, необязательное поле
     */
    @Nullable
    @SerializedName("customerINN")
    private String customerINN;

    /**
     * Кассир, 1021
     * Строка от 1 до 64 символов, необязательное поле
     */
    @Nullable
    @SerializedName("cashier")
    private String cashier;

    /**
     * ИНН кассира, 1203
     * Строка длиной 12 символов, формат ЦЦЦЦЦЦЦЦЦЦЦЦ, необязательное поле
     */
    @Nullable
    @SerializedName("cashierINN")
    private String cashierINN;

    /**
     * Адрес электронной почты отправителя чека, 1117
     * Строка от 1 до 64 символов, необязательное поле
     */
    @Nullable
    @SerializedName("senderEmail")
    private String senderEmail;

    /**
     * Сумма расчета, указанного в чеке (БСО), 1020.
     * Десятичное число с точностью до 2 символов после точки, необязательное поле
     */
    @Nullable
    @SerializedName("totalSum")
    private Double totalSum;

    /**
     * Сумма НДС чека по ставке 20%, 1102
     * Десятичное число с точностью до 2 символов после точки, необязательное поле
     */
    @Nullable
    @SerializedName("vat1Sum")
    private Double vat1Sum;

    /**
     * Сумма НДС чека по ставке 10%, 1103
     * Десятичное число с точностью до 2 символов после точки, необязательное поле
     */
    @Nullable
    @SerializedName("vat2Sum")
    private Double vat2Sum;

    /**
     * Сумма расчета по чеку с НДС по ставке 0%, 1104
     * Десятичное число с точностью до 2 символов после точки, необязательное поле
     */
    @Nullable
    @SerializedName("vat3Sum")
    private Double vat3Sum;

    /**
     * Сумма расчета по чеку без НДС, 1105
     * Десятичное число с точностью до 2 символов после точки, необязательное поле
     */
    @Nullable
    @SerializedName("vat4Sum")
    private Double vat4Sum;

    /**
     * Сумма НДС чека по расч. ставке 20/120, 1106
     * Десятичное число с точностью до 2 символов после точки, необязательное поле
     */
    @Nullable
    @SerializedName("vat5Sum")
    private Double vat5Sum;

    /**
     * Сумма НДС чека по расч. ставке 10/110, 1107
     * Десятичное число с точностью до 2 символов после точки, необязательное поле
     */
    @Nullable
    @SerializedName("vat6Sum")
    private Double vat6Sum;

    public Document(int type, List<Bill> positions, CheckClose checkClose, String customerContact) {
        this.type = type;
        this.positions = positions;
        this.checkClose = checkClose;
        this.customerContact = customerContact;
        this.agentType = null;
        this.paymentTransferOperatorPhoneNumbers = null;
        this.paymentAgentOperation = null;
        this.paymentAgentPhoneNumbers = null;
        this.paymentOperatorPhoneNumbers = null;
        this.paymentOperatorName = null;
        this.paymentOperatorAddress = null;
        this.paymentOperatorINN = null;
        this.supplierPhoneNumbers = null;
        this.additionalUserAttribute = null;
        this.additionalAttribute = null;
        this.automatNumber = null;
        this.settlementAddress = null;
        this.settlementPlace = null;
        this.customer = null;
        this.customerINN = null;
        this.cashier = null;
        this.cashierINN = null;
        this.senderEmail = null;
        this.totalSum = null;
        this.vat1Sum = null;
        this.vat2Sum = null;
        this.vat3Sum = null;
        this.vat4Sum = null;
        this.vat5Sum = null;
        this.vat6Sum = null;
    }

    public Document(
            int type,
            List<Bill> positions,
            CheckClose checkClose,
            String customerContact,
            @Nullable Integer agentType,
            @Nullable List<String> paymentTransferOperatorPhoneNumbers,
            @Nullable String paymentAgentOperation,
            @Nullable List<String> paymentAgentPhoneNumbers,
            @Nullable List<String> paymentOperatorPhoneNumbers,
            @Nullable String paymentOperatorName,
            @Nullable String paymentOperatorAddress,
            @Nullable String paymentOperatorINN,
            @Nullable List<String> supplierPhoneNumbers,
            @Nullable List<AdditionalUserAttribute> additionalUserAttribute,
            @Nullable String additionalAttribute,
            @Nullable String automatNumber,
            @Nullable String settlementAddress,
            @Nullable String settlementPlace,
            @Nullable String customer,
            @Nullable String customerINN,
            @Nullable String cashier,
            @Nullable String cashierINN,
            @Nullable String senderEmail,
            @Nullable Double totalSum,
            @Nullable Double vat1Sum,
            @Nullable Double vat2Sum,
            @Nullable Double vat3Sum,
            @Nullable Double vat4Sum,
            @Nullable Double vat5Sum,
            @Nullable Double vat6Sum
    ) {
        this.type = type;
        this.positions = positions;
        this.checkClose = checkClose;
        this.customerContact = customerContact;
        this.agentType = agentType;
        this.paymentTransferOperatorPhoneNumbers = paymentTransferOperatorPhoneNumbers;
        this.paymentAgentOperation = paymentAgentOperation;
        this.paymentAgentPhoneNumbers = paymentAgentPhoneNumbers;
        this.paymentOperatorPhoneNumbers = paymentOperatorPhoneNumbers;
        this.paymentOperatorName = paymentOperatorName;
        this.paymentOperatorAddress = paymentOperatorAddress;
        this.paymentOperatorINN = paymentOperatorINN;
        this.supplierPhoneNumbers = supplierPhoneNumbers;
        this.additionalUserAttribute = additionalUserAttribute;
        this.additionalAttribute = additionalAttribute;
        this.automatNumber = automatNumber;
        this.settlementAddress = settlementAddress;
        this.settlementPlace = settlementPlace;
        this.customer = customer;
        this.customerINN = customerINN;
        this.cashier = cashier;
        this.cashierINN = cashierINN;
        this.senderEmail = senderEmail;
        this.totalSum = totalSum;
        this.vat1Sum = vat1Sum;
        this.vat2Sum = vat2Sum;
        this.vat3Sum = vat3Sum;
        this.vat4Sum = vat4Sum;
        this.vat5Sum = vat5Sum;
        this.vat6Sum = vat6Sum;
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

    @Nullable
    public int getAgentType() {
        return agentType;
    }

    @Nullable
    public List<String> getPaymentTransferOperatorPhoneNumbers() {
        return paymentTransferOperatorPhoneNumbers;
    }

    @Nullable
    public String getPaymentAgentOperation() {
        return paymentAgentOperation;
    }

    @Nullable
    public List<String> getPaymentAgentPhoneNumbers() {
        return paymentAgentPhoneNumbers;
    }

    @Nullable
    public List<String> getPaymentOperatorPhoneNumbers() {
        return paymentOperatorPhoneNumbers;
    }

    @Nullable
    public String getPaymentOperatorName() {
        return paymentOperatorName;
    }

    @Nullable
    public String getPaymentOperatorAddress() {
        return paymentOperatorAddress;
    }

    @Nullable
    public String getPaymentOperatorINN() {
        return paymentOperatorINN;
    }

    @Nullable
    public List<String> getSupplierPhoneNumbers() {
        return supplierPhoneNumbers;
    }

    @Nullable
    public List<AdditionalUserAttribute> getAdditionalUserAttribute() {
        return additionalUserAttribute;
    }

    @Nullable
    public String getAdditionalAttribute() {
        return additionalAttribute;
    }

    @Nullable
    public String getAutomatNumber() {
        return automatNumber;
    }

    @Nullable
    public String getSettlementAddress() {
        return settlementAddress;
    }

    @Nullable
    public String getSettlementPlace() {
        return settlementPlace;
    }

    @Nullable
    public String getCustomer() {
        return customer;
    }

    @Nullable
    public String getCustomerINN() {
        return customerINN;
    }

    @Nullable
    public String getCashier() {
        return cashier;
    }

    @Nullable
    public String getCashierINN() {
        return cashierINN;
    }

    @Nullable
    public String getSenderEmail() {
        return senderEmail;
    }

    @Nullable
    public Double getTotalSum() {
        return totalSum;
    }

    @Nullable
    public Double getVat1Sum() {
        return vat1Sum;
    }

    @Nullable
    public Double getVat2Sum() {
        return vat2Sum;
    }

    @Nullable
    public Double getVat3Sum() {
        return vat3Sum;
    }

    @Nullable
    public Double getVat4Sum() {
        return vat4Sum;
    }

    @Nullable
    public Double getVat5Sum() {
        return vat5Sum;
    }

    @Nullable
    public Double getVat6Sum() {
        return vat6Sum;
    }

    @Override
    public String validate() {
        String res = check("type", type, 1, Integer.MAX_VALUE, false) +
                check("positions", positions, false) +
                check("customerContact", customerContact, 1, 64, false) +
                check("agentType", agentType, 1, 127, true) +
                check("paymentTransferOperatorPhoneNumbers", paymentTransferOperatorPhoneNumbers, 1, 19, true) +
                check("paymentAgentOperation", paymentAgentOperation, 1, 24, true) +
                check("paymentAgentPhoneNumbers", paymentAgentPhoneNumbers, 1, 19, true) +
                check("paymentOperatorPhoneNumbers", paymentOperatorPhoneNumbers, 1, 19, true) +
                check("paymentOperatorName", paymentOperatorName, 1, 64, true) +
                check("paymentOperatorAddress", paymentOperatorAddress, 1, 243, true) +
                check("paymentOperatorINN", paymentOperatorINN, 10, 12, true) +
                check("supplierPhoneNumbers", supplierPhoneNumbers, 1, 19, true) +
                check("additionalUserAttribute", additionalUserAttribute, true) +
                check("additionalAttribute", additionalAttribute, 1, 16, true) +
                check("automatNumber", automatNumber, 1, 20, true) +
                check("settlementAddress", settlementAddress, 1, 243, true) +
                check("settlementPlace", settlementPlace, 1, 243, true) +
                check("customer", customer, 1, 243, true) +
                check("customerINN", customerINN, 10, 12, true) +
                check("cashier", cashier, 1, 64, true) +
                check("cashierINN", cashierINN, 12, 12, true) +
                check("senderEmail", senderEmail, 12, 64, true) +
                check("totalSum", totalSum, 2, true) +
                check("vat1Sum", vat1Sum, 2, true) +
                check("vat2Sum", vat2Sum, 2, true) +
                check("vat3Sum", vat3Sum, 2, true) +
                check("vat4Sum", vat4Sum, 2, true) +
                check("vat5Sum", vat5Sum, 2, true) +
                check("vat6Sum", vat6Sum, 2, true);

        res += checkClose.validate();
        return res;
    }
}
