package ru.orangedata.orangelib.models.document;

import com.google.gson.annotations.SerializedName;
import ru.orangedata.orangelib.models.Validator;

import javax.annotation.Nullable;
import java.util.List;


/**
 * Данные поставщика
 */
public class SupplierInfo extends Validator {

    /**
     * Телефон поставщика, 1171
     * Массив строк длиной от 1 до 19 символов, формат +{Ц}, необязательное поле
     */
    @Nullable
    @SerializedName("phoneNumbers")
    private List<String> phoneNumbers;

    /**
     * Наименование поставщика, 1225
     * Строка до 239 символов.
     * Внимание: в данные 243 символа включаются телефоны поставщика + 4 символа на каждый телефон.
     * Например, если передано 2 телефона поставщика длиной 12 и 14 символов, то максимальная длина наименования поставщика будет 239 – (12 + 4) – (14 + 4)  = 205 символов
     */
    @Nullable
    @SerializedName("name")
    private String name;

    public SupplierInfo(@Nullable List<String> phoneNumbers, @Nullable String name) {
        this.phoneNumbers = phoneNumbers;
        this.name = name;
    }

    @Nullable
    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    @Nullable
    public String getName() {
        return name;
    }

    @Override
    public String validate() {
        return check("phoneNumbers", phoneNumbers, 1, 19, false) +
                check("name", name, 1, 239, false);
    }
}
