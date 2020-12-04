package ru.orangedata.orangelib.models.correction;

import com.google.gson.annotations.SerializedName;
import ru.orangedata.orangelib.models.Validator;

import javax.annotation.Nullable;

public class CorrectionDocument extends Validator {

    /**
     * Тип коррекции 1173:
     * 0. Самостоятельно
     * 1. По предписанию
     * Число. Параметр обязательный.
     *
     * @see ru.orangedata.orangelib.models.constants.CorrectionType
     */
    @SerializedName("correctionType")
    private int correctionType;

    /**
     * Признак расчета, 1054:
     * 1. Приход
     * 3. Расход
     * Число. Параметр обязательный.
     *
     * @see ru.orangedata.orangelib.models.constants.DocumentType
     */
    @SerializedName("type")
    private int type;

    /**
     * Дата документа основания для коррекции 1178.
     * В данном реквизите время всегда указывать, как 00:00:00
     * Время в виде строки в формате ISO8601. Параметр обязательный.
     */
    @SerializedName("causeDocumentDate")
    private String causeDocumentDate;

    /**
     * Номер документа основания для коррекции, 1179
     * Строка от 1 до 32 символов. Параметр обязательный.
     */
    @SerializedName("causeDocumentNumber")
    private String causeDocumentNumber;

    /**
     * Сумма расчета, указанного в чеке (БСО), 1020
     * Десятичное число с точностью до 2 символов после точки. Параметр обязательный.
     */
    @SerializedName("totalSum")
    private Double totalSum;

    /**
     * Сумма по чеку (БСО) наличными, 1031
     * Десятичное число с точностью до 2 символов после точки
     */
    @Nullable
    @SerializedName("cashSum")
    private Double cashSum;

    /**
     * Сумма по чеку (БСО) безналичными, 1081
     * Десятичное число с точностью до 2 символов после точки
     */
    @Nullable
    @SerializedName("eCashSum")
    private Double eCashSum;

    /**
     * Сумма по чеку (БСО) предоплатой (зачетом аванса и (или) предыдущих платежей), 1215
     * Десятичное число с точностью до 2 символов после точки
     */
    @Nullable
    @SerializedName("prepaymentSum")
    private Double prepaymentSum;

    /**
     * Сумма по чеку (БСО) постоплатой (в кредит), 1216
     * Десятичное число с точностью до 2 символов после точки
     */
    @Nullable
    @SerializedName("postpaymentSum")
    private Double postpaymentSum;

    /**
     * Сумма по чеку (БСО) встречным предоставлением, 1217
     * Десятичное число с точностью до 2 символов после точки
     */
    @Nullable
    @SerializedName("otherPaymentTypeSum")
    private Double otherPaymentTypeSum;

    /**
     * Сумма НДС чека по ставке 20%, 1102
     * Десятичное число с точностью до 2 символов после точки
     */
    @Nullable
    @SerializedName("tax1Sum")
    private Double tax1Sum;

    /**
     * Сумма НДС чека по ставке 10%, 1103
     * Десятичное число с точностью до 2 символов после точки
     */
    @Nullable
    @SerializedName("tax2Sum")
    private Double tax2Sum;

    /**
     * Сумма расчета по чеку с НДС по ставке 0%, 1104
     * Десятичное число с точностью до 2 символов после точки
     */
    @Nullable
    @SerializedName("tax3Sum")
    private Double tax3Sum;

    /**
     * Сумма расчета по чеку без НДС, 1105
     * Десятичное число с точностью до 2 символов после точки
     */
    @Nullable
    @SerializedName("tax4Sum")
    private Double tax4Sum;

    /**
     * Сумма НДС чека по расч. ставке 20/120, 1106
     * Десятичное число с точностью до 2 символов после точки, необязательное поле
     */
    @Nullable
    @SerializedName("tax5Sum")
    private Double tax5Sum;

    /**
     * Сумма НДС чека по расч. ставке 10/110, 1107
     * Десятичное число с точностью до 2 символов после точки, необязательное поле
     */
    @Nullable
    @SerializedName("tax6Sum")
    private Double tax6Sum;

    /**
     * Применяемая система налогообложения, 1055:
     * 0. Общая
     * 1. Упрощенная доход
     * 2. Упрощенная доход минус расход
     * 3. Единый налог на вмененный доход
     * 4. Единый сельскохозяйственный налог
     * 5. Патентная система налогообложения
     *
     * @see ru.orangedata.orangelib.models.constants.TaxationSystem
     */
    @Nullable
    @SerializedName("taxationSystem")
    private Integer taxationSystem;

    /**
     * Сумма НДС чека по расч. ставке 10/110, 1107
     * Строка длиной от 1 до 20 символов, обязательное поле, если группа имеет признак передачи данных автомата, в противном случае не должно передаваться.
     * Только для вендинга и транспорта.
     */
    @Nullable
    @SerializedName("automatNumber")
    private String automatNumber;

    /**
     * Адрес расчетов
     * Строка длиной от 1 до 243 символов, обязательное поле, если группа имеет признак передачи данных автомата, в противном случае не должно передаваться.
     * Только для вендинга и транспорта.
     */
    @Nullable
    @SerializedName("settlementAddress")
    private String settlementAddress;

    /**
     * Место расчетов
     * Строка длиной от 1 до 243 символов, обязательное поле, если группа имеет признак передачи данных автомата, в противном случае не должно передаваться.
     * Только для вендинга и транспорта.
     */
    @Nullable
    @SerializedName("settlementPlace")
    private String settlementPlace;

    public CorrectionDocument(
            int correctionType,
            int type,
            String causeDocumentDate,
            String causeDocumentNumber,
            Double totalSum,
            @Nullable Double cashSum,
            @Nullable Double eCashSum,
            @Nullable Double prepaymentSum,
            @Nullable Double postpaymentSum,
            @Nullable Double otherPaymentTypeSum,
            @Nullable Double tax1Sum,
            @Nullable Double tax2Sum,
            @Nullable Double tax3Sum,
            @Nullable Double tax4Sum,
            @Nullable Double tax5Sum,
            @Nullable Double tax6Sum,
            @Nullable Integer taxationSystem,
            @Nullable String automatNumber,
            @Nullable String settlementAddress,
            @Nullable String settlementPlace) {
        this.correctionType = correctionType;
        this.type = type;
        this.causeDocumentDate = causeDocumentDate;
        this.causeDocumentNumber = causeDocumentNumber;
        this.totalSum = totalSum;
        this.cashSum = cashSum;
        this.eCashSum = eCashSum;
        this.prepaymentSum = prepaymentSum;
        this.postpaymentSum = postpaymentSum;
        this.otherPaymentTypeSum = otherPaymentTypeSum;
        this.tax1Sum = tax1Sum;
        this.tax2Sum = tax2Sum;
        this.tax3Sum = tax3Sum;
        this.tax4Sum = tax4Sum;
        this.tax5Sum = tax5Sum;
        this.tax6Sum = tax6Sum;
        this.taxationSystem = taxationSystem;
        this.automatNumber = automatNumber;
        this.settlementAddress = settlementAddress;
        this.settlementPlace = settlementPlace;
    }

    @Override
    public String validate() {
        return check("correctionType", correctionType, 0, 1, false) +
                check("type", type, 1, 4, false) +
                checkDate("causeDocumentDate", causeDocumentDate, false) +
                check("causeDocumentNumber", causeDocumentNumber, 1, 32, false) +
                check("totalSum", totalSum, 2, true) +
                check("cashSum", cashSum, 2, true) +
                check("eCashSum", eCashSum, 2, true) +
                check("prepaymentSum", prepaymentSum, 2, true) +
                check("postpaymentSum", postpaymentSum, 2, true) +
                check("otherPaymentTypeSum", otherPaymentTypeSum, 2, true) +
                check("tax1Sum", tax1Sum, 2, true) +
                check("tax2Sum", tax2Sum, 2, true) +
                check("tax3Sum", tax3Sum, 2, true) +
                check("tax4Sum", tax4Sum, 2, true) +
                check("tax5Sum", tax5Sum, 2, true) +
                check("tax6Sum", tax6Sum, 2, true) +
                check("taxationSystem", taxationSystem, 0, 5, true) +
                check("automatNumber", automatNumber, 1, 20, true) +
                check("settlementAddress", settlementAddress, 1, 243, true) +
                check("settlementPlace", settlementPlace, 1, 243, true)
                ;
    }
}
