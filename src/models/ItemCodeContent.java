package models;

import com.google.gson.annotations.SerializedName;

import java.util.LongSummaryStatistics;
import java.util.Map;

public class ItemCodeContent {
    
    ///     Планируемый статус, 2003
    @SerializedName("PlannedStatus")
    public Byte plannedStatus;

    ///     Код маркировки, 2000
    @SerializedName("ItemCode")
    public String itemCode;

    ///     Мера количества предмета расчета, 2108
    @SerializedName("QuantityMeasurementUnit")
    public Byte quantityMeasurementUnit;
    
    ///     Количество предмета расчета, 1023
    @SerializedName("Quantity")
    public Double quantity;
    
    /// Дробное количество маркированного товара, 1291
    @SerializedName("FractionalQuantity")
    public Map<String, Long> fractionalQuantity;

    public ItemCodeContent(Byte plannedStatus, String itemCode, Byte quantityMeasurementUnit, Double quantity,
                           Map<String, Long> fractionalQuantity){
        this.plannedStatus=plannedStatus;
        this.itemCode=itemCode;
        this.quantityMeasurementUnit=quantityMeasurementUnit;
        this.quantity=quantity;
        this.fractionalQuantity=fractionalQuantity;
    }
}
