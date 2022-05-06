package models;

import com.google.gson.annotations.SerializedName;

public class OperationalAttribute {
    // Дата, время операции, 1273 (Время в виде строки в формате ISO8601)
    @SerializedName("Date")
    public String date;

    // Идентификатор операции, 1271
    @SerializedName("Id")
    public byte id;

    // Данные операции, 1272
    @SerializedName("Value")
    public String value;

    public OperationalAttribute(String date,byte id,String value){
        this.date=date;
        this.id=id;
        this.value=value;
    }
}
