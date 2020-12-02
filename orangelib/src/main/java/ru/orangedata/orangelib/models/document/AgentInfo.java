package ru.orangedata.orangelib.models.document;

import com.google.gson.annotations.SerializedName;
import javax.annotation.Nullable;
import ru.orangedata.orangelib.models.Validator;


import java.util.List;

/**
 * Данные агента
 */
public class AgentInfo extends Validator {

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
    private List<String> paymentAgentOperation;

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

    public AgentInfo(
            @Nullable List<String> paymentTransferOperatorPhoneNumbers,
            @Nullable List<String> paymentAgentOperation,
            @Nullable List<String> paymentAgentPhoneNumbers,
            @Nullable List<String> paymentOperatorPhoneNumbers,
            @Nullable String paymentOperatorName,
            @Nullable String paymentOperatorAddress,
            @Nullable String paymentOperatorINN
    ) {
        this.paymentTransferOperatorPhoneNumbers = paymentTransferOperatorPhoneNumbers;
        this.paymentAgentOperation = paymentAgentOperation;
        this.paymentAgentPhoneNumbers = paymentAgentPhoneNumbers;
        this.paymentOperatorPhoneNumbers = paymentOperatorPhoneNumbers;
        this.paymentOperatorName = paymentOperatorName;
        this.paymentOperatorAddress = paymentOperatorAddress;
        this.paymentOperatorINN = paymentOperatorINN;
    }

    @Nullable
    public List<String> getPaymentTransferOperatorPhoneNumbers() {
        return paymentTransferOperatorPhoneNumbers;
    }

    @Nullable
    public List<String> getPaymentAgentOperation() {
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

    @Override
    public String validate() {
        return check("paymentTransferOperatorPhoneNumbers", paymentTransferOperatorPhoneNumbers, 1, 19, true) +
                check("paymentAgentOperation", paymentAgentOperation, 1, 24, true) +
                check("paymentAgentPhoneNumbers", paymentAgentPhoneNumbers, 1, 19, true) +
                check("paymentOperatorPhoneNumbers", paymentOperatorPhoneNumbers, 1, 19, true) +
                check("paymentOperatorName", paymentOperatorName, 1, 64, true) +
                check("paymentOperatorAddress", paymentOperatorAddress, 1, 243, true) +
                check("paymentOperatorINN", paymentOperatorINN, 10, 12, true);
    }
}

