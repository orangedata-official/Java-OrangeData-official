package models;

import com.google.gson.annotations.SerializedName;
import constants.PaymentMethodType;
import constants.PaymentSubjectType;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

/**
 * Created by Alexey Padyukov on 19.06.2017.
 */
public class Bill {

    //Десятичное число с точностью до 3 символов после точки
    @SerializedName("Quantity")
    public Double quantity;
    //Десятичное число с точностью до 2 символов после точки
    @SerializedName("Price")
    public Double price;
    //Число от 1 до 6
    @SerializedName("Tax")
    public int tax;
    //Строка до 128 символов
    @SerializedName("Text")
    public String text;
    //Признак способа расчета
    @SerializedName("PaymentMethodType")
    public int paymentMethodType;
    //Признак способа расчета
    @SerializedName("PaymentSubjectType")
    public int paymentSubjectType;
    //     Код товарной номенклатуры
    @SerializedName("NomenclatureCode")
    public String nomenclatureCode;
    //     Код маркировки, 2000
    @SerializedName("ItemCode")
    public String itemCode;
    //     Планируемый статус, 2003
    @SerializedName("PlannedStatus")
    public Byte plannedStatus;
    //     Данные поставщика
    @SerializedName("SupplierInfo")
    public SupplierInfo supplierInfo;
    //     ИНН поставщика
    @SerializedName("SupplierINN")
    public String supplierINN;
    //     Признак агента по предмету расчета
    @SerializedName("AgentType")
    public Integer agentType;
    //     Данные агента
    @SerializedName("AgentInfo")
    public AgentInfo agentInfo;
    //     Единица измерения предмета расчета
    @SerializedName("UnitOfMeasurement")
    public String unitOfMeasurement;
    //     Мера количества предмета расчета, 2108
    @SerializedName("QuantityMeasurementUnit")
    public Byte quantityMeasurementUnit;
    //     Дополнительный реквизит предмета расчета
    @SerializedName("AdditionalAttribute")
    public String additionalAttribute;
    //     Код страны происхождения товара
    @SerializedName("ManufacturerCountryCode")
    public String manufacturerCountryCode;
    //     Номер таможенной декларации
    @SerializedName("CustomsDeclarationNumber")
    public String customsDeclarationNumber;
    //     Акциз
    @SerializedName("Excise")
    public Double excise;
    // Сумма НДС за предмет расчета, 1200
    @SerializedName("TaxSum")
    public Double taxSum;
    // Размер НДС за единицу предмета расчета, 1198
    @SerializedName("UnitTaxSum")
    public Double unitTaxSum;
    // Дробное количество маркированного товара, 1291
    @SerializedName("FractionalQuantity")
    public HashMap<String, Long> fractionalQuantity;
    // Отраслевой реквизит чека
    @SerializedName("IndustryAttribute")
    public HashMap<String, String> industryAttribute;
    // Штрих-коды предмета расчета
    @SerializedName("Barcodes")
    public HashMap<String, String> barcodes;

    public Bill(Double quantity, Double price, int tax, String text,int paymentMethodType,int paymentSubjectType,
                @Nullable String nomenclatureCode,@Nullable String itemCode,@Nullable Byte plannedStatus,@Nullable SupplierInfo supplierInfo,String supplierINN,
                @Nullable Integer agentType,@Nullable AgentInfo agentInfo,@Nullable String unitOfMeasurement,@Nullable Byte quantityMeasurementUnit,
                @Nullable String additionalAttribute,@Nullable String manufacturerCountryCode,@Nullable String customsDeclarationNumber,
                @Nullable Double excise,@Nullable Double taxSum,@Nullable Double unitTaxSum,@Nullable HashMap<String, Long> fractionalQuantity,
                @Nullable HashMap<String, String> industryAttribute,@Nullable HashMap<String, String> barcodes) {
        this.quantity = quantity;
        this.price = price;
        this.tax = tax;
        this.text = text;
        this.paymentMethodType = paymentMethodType>0 ? paymentMethodType : PaymentMethodType.Full;
        this.paymentSubjectType = paymentSubjectType>0 ? paymentSubjectType : PaymentSubjectType.Product;
        this.nomenclatureCode=nomenclatureCode;
        this.itemCode=itemCode;
        this.plannedStatus=plannedStatus;
        this.supplierInfo=supplierInfo;
        this.supplierINN=supplierINN;
        this.agentType=agentType;
        this.agentInfo=agentInfo;
        this.unitOfMeasurement=unitOfMeasurement;
        this.quantityMeasurementUnit=quantityMeasurementUnit;
        this.additionalAttribute=additionalAttribute;
        this.manufacturerCountryCode=manufacturerCountryCode;
        this.customsDeclarationNumber=customsDeclarationNumber;
        this.excise=excise;
        this.taxSum=taxSum;
        this.unitTaxSum=unitTaxSum;
        this.fractionalQuantity=fractionalQuantity;
        this.industryAttribute=industryAttribute;
        this.barcodes=barcodes;
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
}
