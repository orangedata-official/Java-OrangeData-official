package ru.orangedata.orangelib.models.document;

import com.google.gson.annotations.SerializedName;
import ru.orangedata.orangelib.models.Validator;

public class Payment extends Validator {

    /**
     * Тип оплаты
     * Число от 1 до 16. ѕараметр обязательный.
     *
     * @see ru.orangedata.orangelib.models.constants.PaymentType
     */
    @SerializedName("Type")
    private int type;

    /**
     * Сумма оплаты
     * Десятичное число с точностью до 2 символов после точки. Параметр обязательный.
     */
    @SerializedName("Amount")
    private Double amount;

    public Payment(int type, Double amount) {
        this.type = type;
        this.amount = amount;
    }

    public int getType() {
        return type;
    }

    public Double getAmount() {
        return amount;
    }

    @Override
    public String validate() {
        return check("type", type, 1, 16, false) +
                check("amount", amount, 2, false);
    }
}
