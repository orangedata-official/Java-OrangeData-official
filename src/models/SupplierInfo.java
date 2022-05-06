package models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SupplierInfo {
    // <summary>
    ///     Телефон поставщика
    /// </summary>
    @SerializedName("PhoneNumbers")
    public List<String> phoneNumbers;

    /// <summary>
    ///     Наименование поставщика
    /// </summary>
    @SerializedName("Name")
    public String name;

    public SupplierInfo(List<String> phoneNumbers,String name){
        this.phoneNumbers=phoneNumbers;
        this.name=name;
    }
}
