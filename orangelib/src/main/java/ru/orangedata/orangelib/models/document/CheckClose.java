package ru.orangedata.orangelib.models.document;

import com.google.gson.annotations.SerializedName;
import ru.orangedata.orangelib.models.Validator;

import java.util.List;

public class CheckClose extends Validator {

    /**
     * Оплаты
     * Массив структур п.2.1.1.4
     */
    @SerializedName("Payments")
    private List<Payment> payments;

    /**
     * Система налогообложения, 1055
     * Число от 0 до 5
     *
     * @see ru.orangedata.orangelib.models.constants.TaxationSystem
     */
    @SerializedName("TaxationSystem")
    private int taxationSystem;

    public CheckClose(List<Payment> payments, int taxationSystem) {
        this.payments = payments;
        this.taxationSystem = taxationSystem;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public int getTaxationSystem() {
        return taxationSystem;
    }

    @Override
    public String validate() {
        return check("payments", payments, false) +
                check("taxationSystem", taxationSystem, 0, 5, false);
    }
}
