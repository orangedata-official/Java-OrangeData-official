package models;

import com.google.gson.annotations.SerializedName;
import enums.DocumentType;

import java.util.List;

/**
 * Created by Alexey Padyukov on 19.06.2017.
 */
public class Document {

    @SerializedName("Type")
    private DocumentType type;
    @SerializedName("Positions")
    private List<Bill> positions;
    @SerializedName("CheckClose")
    private CheckClose checkClose;
    @SerializedName("CustomerContact")
    private String customerContact;

    public Document(DocumentType type, List<Bill> positions, CheckClose checkClose, String customerContact) {
        this.type = type;
        this.positions = positions;
        this.checkClose = checkClose;
        this.customerContact = customerContact;
    }

    public DocumentType getType() {
        return type;
    }

    public List<Bill> getPositions() {
        return positions;
    }

    public CheckClose getCheckClose() {
        return checkClose;
    }

    public String getCustomerContact() {
        return customerContact;
    }
}
