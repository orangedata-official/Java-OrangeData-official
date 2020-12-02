package ru.orangedata.orangelib.models.document;

import com.google.gson.annotations.SerializedName;
import ru.orangedata.orangelib.models.Validator;


/**
 * Дополнительный реквизит пользователя
 * Длина атрибутов name + value не должна суммарно превышать 235 символов
 */
public class AdditionalUserAttribute extends Validator {

    /**
     * Наименование дополнительного реквизита пользователя, 1085
     * Строка от 1 до 64 символов
     */
    @SerializedName("name")
    private String name;

    /**
     * Значение дополнительного реквизита пользователя, 1086
     * Строка от 1 до 234 символов.
     */
    @SerializedName("value")
    private String value;

    public AdditionalUserAttribute(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String validate() {
        return check("name", name, 1, 64, false) +
                check("value", value, 1, 234, false) +
                check("name+value", name + value, 1, 235, false);
    }
}
