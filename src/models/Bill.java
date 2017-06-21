package models;

import com.google.gson.annotations.SerializedName;
import enums.Tax;

/**
 * Created by Alexey Padyukov on 19.06.2017.
 */
public class Bill {

    //Десятичное число с точностью до 3 символов после точки
    @SerializedName("Quantity")
    private Double quantity;
    //Десятичное число с точностью до 2 символов после точки
    @SerializedName("Price")
    private Double price;
    //Число от 1 до 6
    @SerializedName("Tax")
    private Tax tax;
    //Строка до 128 символов
    @SerializedName("Text")
    private String text;

    public Bill(Double quantity, Double price, Tax tax, String text) {
        this.quantity = quantity;
        this.price = price;
        this.tax = tax;
        this.text = text;
    }

    public Double getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Tax getTax() {
        return tax;
    }

    public String getText() {
        return text;
    }
}
