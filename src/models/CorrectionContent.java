package models;

import com.google.gson.annotations.SerializedName;
import constants.CorrectionType;
import constants.DocumentType;
import constants.TaxationSystem;

import java.util.Date;

public class CorrectionContent {
    
    ///     Тип коррекции
    @SerializedName("CorrectionType")
    public Integer correctionType;

    
    ///     Признак расчета
    @SerializedName("Type")
    public Integer type;

    
    ///     Дата документа основания для коррекции
    ///     В данном реквизите время всегда указывать, как 00:00:00
    @SerializedName("CauseDocumentDate")
    public Date causeDocumentDate;

    
    ///     Номер документа основания для коррекции
    @SerializedName("CauseDocumentNumber")
    public String causeDocumentNumber;

    
    ///     Сумма расчета, указанного в чеке (БСО
    @SerializedName("TotalSum")
    public Double totalSum;

    
    ///     Сумма по чеку (БСО) наличными
    @SerializedName("CashSum")
    public Double cashSum;

    
    ///     Сумма по чеку (БСО) электронными
    @SerializedName("ECashSum")
    public Double eCashSum;

    
    ///     Сумма по чеку (БСО) предоплатой (зачетом аванса и (или) предыдущих платежей)
    @SerializedName("PrepaymentSum")
    public Double prepaymentSum;

    
    ///     Сумма по чеку (БСО) постоплатой (в кредит)
    @SerializedName("PostpaymentSum")
    public Double postpaymentSum;

    
    ///     Сумма по чеку (БСО) встречным предоставлением
    @SerializedName("OtherPaymentTypeSum")
    public Double otherPaymentTypeSum;

    
    ///     Сумма НДС чека по ставке 18%
    @SerializedName("Tax1Sum")
    public Double tax1Sum;

    
    ///     Сумма НДС чека по ставке 10%
    @SerializedName("Tax2Sum")
    public Double tax2Sum;

    
    ///     Сумма расчета по чеку с НДС по ставке 0%
    @SerializedName("Tax3Sum")
    public Double tax3Sum;

    
    ///     Сумма расчета по чеку без НДС
    @SerializedName("Tax4Sum")
    public Double tax4Sum;

    
    ///     Сумма НДС чека по расч. ставке 18/118
    @SerializedName("Tax5Sum")
    public Double tax5Sum;

    
    ///     Сумма НДС чека по расч. ставке 10/110
    @SerializedName("Tax6Sum")
    public Double tax6Sum;

    
    ///     Применяемая система налогообложения
    @SerializedName("TaxationSystem")
    public Integer taxationSystem;

    public CorrectionContent(Integer correctionType,Integer type,
                             Date causeDocumentDate,String causeDocumentNumber,Double totalSum,
                             Double cashSum,Double eCashSum,Double prepaymentSum,Double postpaymentSum,
                             Double otherPaymentTypeSum,Double tax1Sum,Double tax2Sum,Double tax3Sum,
                             Double tax4Sum,Double tax5Sum,Double tax6Sum,Integer taxationSystem){
        this.correctionType=correctionType;
        this.type=type;
        this.causeDocumentDate=causeDocumentDate;
        this.causeDocumentNumber=causeDocumentNumber;
        this.totalSum=totalSum;
        this.cashSum=cashSum;
        this.eCashSum=eCashSum;
        this.prepaymentSum=prepaymentSum;
        this.postpaymentSum=postpaymentSum;
        this.otherPaymentTypeSum=otherPaymentTypeSum;
        this.tax1Sum=tax1Sum;
        this.tax2Sum=tax2Sum;
        this.tax3Sum=tax3Sum;
        this.tax4Sum=tax4Sum;
        this.tax5Sum=tax5Sum;
        this.tax6Sum=tax6Sum;
        this.taxationSystem=taxationSystem;
    }
}
