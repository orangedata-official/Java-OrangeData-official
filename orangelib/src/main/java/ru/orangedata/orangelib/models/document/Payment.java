package ru.orangedata.orangelib.models.document;

import com.google.gson.annotations.SerializedName;
import ru.orangedata.orangelib.models.Validator;


/**
 * Created by Alexey Padyukov on 19.06.2017.
 */
public class Payment extends Validator {

    /**
     * “ип оплаты
     * „исло от 1 до 16. ѕараметр об¤зательный.
     * @see ru.orangedata.orangelib.constants.PaymentType
     */
    @SerializedName("Type")
    private int type;

    /**
     * —умма оплаты
     * ƒес¤тичное число с точностью до 2 символов после точки*. ѕараметр об¤зательный.
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
