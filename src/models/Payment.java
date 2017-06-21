package models;

import com.google.gson.annotations.SerializedName;
import enums.DocumentType;
import enums.PaymentType;

/**
 * Created by Alexey Padyukov on 19.06.2017.
 */
public class Payment {

    //Число от 1 до 16
    @SerializedName("Type")
    private PaymentType type;
    //Десятичное число с точностью до 2 символов после точки
    @SerializedName("Amount")
    private Double amount;

    public Payment(PaymentType type, Double amount) {
        this.type = type;
        this.amount = amount;
    }

    public PaymentType getType() {
        return type;
    }

    public Double getAmount() {
        return amount;
    }
}
