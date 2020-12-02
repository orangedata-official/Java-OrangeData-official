package ru.orangedata.orangelib.models.document;

import com.google.gson.annotations.SerializedName;
import javax.annotation.Nullable;
import ru.orangedata.orangelib.models.Validator;


/**
 * Created by Alexey Padyukov on 19.06.2017.
 */
public class Bill extends Validator {

    /**
     * Количество предмета расчета, 1023
     * Десятичное число с точностью до 6 символов после точки*. Параметр обязательный.
     */
    @SerializedName("quantity")
    private Double quantity;

    /**
     * Цена за единицу предмета расчета с учетом скидок и наценок, 1079
     * Десятичное число с точностью до 2 символов после точки*. Параметр обязательный.
     */
    @SerializedName("price")
    private Double price;

    /**
     * Ставка НДС, 1199
     * Число от 1 до 6. Параметр обязательный.
     * @see constants.Tax
     */
    @SerializedName("tax")
    private int tax;

    /**
     * Наименование предмета расчета, 1030
     * Строка до 128 символов. Параметр обязательный.
     */
    @SerializedName("text")
    private String text;

    /**
     * Сумма НДС за предмет расчета, 1200
     * Десятичное число с точностью до 2 символов после точки, необязательное поле
     */
    @Nullable
    @SerializedName("taxSum")
    private Double taxSum;

    /**
     * Признак способа расчета, 1214
     * Число от 1 до 7 или null. Если передано null, то в предмет расчета будет передано значение 4, Полный расчет.
     */
    @Nullable
    @SerializedName("paymentMethodType")
    private Integer paymentMethodType;

    /**
     * Признак предмета расчета, 1212
     * Число от 1 до 26 или null. Если передано null, то в предмет расчета будет передано значение 1, Товар.
     */
    @Nullable
    @SerializedName("paymentSubjectType")
    private Integer paymentSubjectType;

    /**
     * Код товарной номенклатуры, 1162
     * Строка, содержащая base64 кодированный массив от 8 до 32 байт либо null
     */
    @Nullable
    @SerializedName("nomenclatureCode")
    private String nomenclatureCode;

    /**
     * Данные поставщика, 1224
     * Структура п.2.1.1.6, либо null
     */
    @Nullable
    @SerializedName("supplierInfo")
    private SupplierInfo supplierInfo;

    /**
     * ИНН поставщика, 1226
     * Строка длиной от 10 до 12 символов, формат ЦЦЦЦЦЦЦЦЦЦ, необязательное поле
     */
    @Nullable
    @SerializedName("supplierINN")
    private String supplierINN;

    /**
     * Признак агента по предмету расчета, 1222
     * Число от 1 до 127, необязательное поле
     */
    @Nullable
    @SerializedName("agentType")
    private Integer agentType;

    /**
     * Данные агента, 1223
     * Структура п.2.1.1.7, либо null. На текущий момент длина сериализованных данных тэга не должна превышать 243 байта.
     */
    @Nullable
    @SerializedName("agentInfo")
    private AgentInfo agentInfo;

    /**
     * Единица измерения предмета расчета, 1197
     * Строка от 1 до 16 символов, необязательное поле
     */
    @Nullable
    @SerializedName("unitOfMeasurement")
    private String unitOfMeasurement;

    /**
     * Дополнительный реквизит предмета расчета, 1191
     * Строка от 1 до 64 символов, необязательное поле
     */
    @Nullable
    @SerializedName("additionalAttribute")
    private String additionalAttribute;

    /**
     * Код страны происхождения товара, 1230
     * Строка длиной от 1 до 3 символов, формат ЦЦЦ, необязательное поле.
     * Сервис автоматически дополнит строку до 3 символов пробелами.
     */
    @Nullable
    @SerializedName("manufacturerCountryCode")
    private String manufacturerCountryCode;

    /**
     * Номер таможенной декларации, 1231
     * Строка от 1 до 32 символов, необязательное поле
     */
    @Nullable
    @SerializedName("customsDeclarationNumber")
    private String customsDeclarationNumber;

    /**
     * Акциз, 1229
     * Десятичное число с точностью до 2 символов после точки, необязательное поле
     */
    @Nullable
    @SerializedName("excise")
    private Double excise;

    public Bill(
            Double quantity,
            Double price,
            int tax,
            String text) {
        this.quantity = quantity;
        this.price = price;
        this.tax = tax;
        this.text = text;
        this.taxSum = null;
        this.paymentMethodType = null;
        this.paymentSubjectType = null;
        this.nomenclatureCode = null;
        this.supplierInfo = null;
        this.supplierINN = null;
        this.agentType = null;
        this.agentInfo = null;
        this.unitOfMeasurement = null;
        this.additionalAttribute = null;
        this.manufacturerCountryCode = null;
        this.customsDeclarationNumber = null;
        this.excise = null;
    }

    public Bill(
            Double quantity,
            Double price,
            int tax,
            String text,
            @Nullable Double taxSum,
            @Nullable int paymentMethodType,
            @Nullable int paymentSubjectType,
            @Nullable String nomenclatureCode,
            @Nullable SupplierInfo supplierInfo,
            @Nullable String supplierINN,
            @Nullable int agentType,
            @Nullable AgentInfo agentInfo,
            @Nullable String unitOfMeasurement,
            @Nullable String additionalAttribute,
            @Nullable String manufacturerCountryCode,
            @Nullable String customsDeclarationNumber,
            @Nullable Double excise
    ) {
        this.quantity = quantity;
        this.price = price;
        this.tax = tax;
        this.text = text;
        this.taxSum = taxSum;
        this.paymentMethodType = paymentMethodType;
        this.paymentSubjectType = paymentSubjectType;
        this.nomenclatureCode = nomenclatureCode;
        this.supplierInfo = supplierInfo;
        this.supplierINN = supplierINN;
        this.agentType = agentType;
        this.agentInfo = agentInfo;
        this.unitOfMeasurement = unitOfMeasurement;
        this.additionalAttribute = additionalAttribute;
        this.manufacturerCountryCode = manufacturerCountryCode;
        this.customsDeclarationNumber = customsDeclarationNumber;
        this.excise = excise;
    }

    public Double getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public int getTax() {
        return tax;
    }

    public String getText() {
        return text;
    }

    @Nullable
    public Double getTaxSum() {
        return taxSum;
    }

    @Nullable
    public int getPaymentMethodType() {
        return paymentMethodType;
    }

    @Nullable
    public int getPaymentSubjectType() {
        return paymentSubjectType;
    }

    @Nullable
    public String getNomenclatureCode() {
        return nomenclatureCode;
    }

    @Nullable
    public SupplierInfo getSupplierInfo() {
        return supplierInfo;
    }

    @Nullable
    public String getSupplierINN() {
        return supplierINN;
    }

    @Nullable
    public int getAgentType() {
        return agentType;
    }

    @Nullable
    public AgentInfo getAgentInfo() {
        return agentInfo;
    }

    @Nullable
    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    @Nullable
    public String getAdditionalAttribute() {
        return additionalAttribute;
    }

    @Nullable
    public String getManufacturerCountryCode() {
        return manufacturerCountryCode;
    }

    @Nullable
    public String getCustomsDeclarationNumber() {
        return customsDeclarationNumber;
    }

    @Nullable
    public Double getExcise() {
        return excise;
    }

    @Override
    public String validate() {
        String res = check("quantity", quantity, 6, false) +
                check("price", price, 2, false) +
                check("tax", tax, 1, 6, false) +
                check("text", text, 1, 128, false) +
                check("taxSum", taxSum, 2, true) +
                check("paymentMethodType", paymentMethodType, 1, 7, true) +
                check("paymentSubjectType", paymentSubjectType, 1, 26, true) +
                checkBase64("nomenclatureCode", nomenclatureCode, 8, 32, true) +
                check("supplierINN", supplierINN, 10, 12, true) +
                check("agentType", agentType, 1, 127, true) +
                check("agentType", agentType, 1, 127, true) +
                check("unitOfMeasurement", unitOfMeasurement, 1, 16, true) +
                check("additionalAttribute", additionalAttribute, 1, 64, true) +
                check("manufacturerCountryCode", manufacturerCountryCode, 1, 3, true) +
                check("customsDeclarationNumber", manufacturerCountryCode, 1, 32, true) +
                check("excise", excise, 2, true);
        if (supplierInfo != null) res += supplierInfo.validate() + NEW_LINE;
        if (agentInfo != null) res += agentInfo.validate() + NEW_LINE;
        return res;
    }
}
