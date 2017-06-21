package models;

import com.google.gson.annotations.SerializedName;
import enums.TaxationSystem;

import java.util.List;

/**
 * Created by Alexey Padyukov on 19.06.2017.
 */
public class CheckClose {

    //Массив структур {@link models.Payment}
    @SerializedName("Payments")
    private List<Payment> payments;
    //Число от 0 до 5
    @SerializedName("TaxationSystem")
    private TaxationSystem taxationSystem;

    public CheckClose(List<Payment> payments, TaxationSystem taxationSystem) {
        this.payments = payments;
        this.taxationSystem = taxationSystem;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public TaxationSystem getTaxationSystem() {
        return taxationSystem;
    }
}
