package ru.orangedata.orangelib.models.document;

import com.google.gson.annotations.SerializedName;
import javax.annotation.Nullable;
import ru.orangedata.orangelib.models.Validator;

/**
 * Created by Alexey Padyukov on 19.06.2017.
 */
public class DocumentRequestBody extends Validator {

    /**
     * Идентификатор документа
     * Строка от 1 до 64 символов. Параметр обязательный
     */
    @SerializedName("id")
    private String id;

    /**
     * ИНН организации, для которой пробивается чек
     * Строка 10 или 12 символов. Параметр обязательный.
     */
    @SerializedName("inn")
    private String inn;

    /**
     * Группа устройств, с помощью которых будет пробит чек
     * Строка от 1 до 32 символов или null
     */
    @SerializedName("group")
    @Nullable
    private String group;

    /**
     * Содержимое документа
     */
    @SerializedName("content")
    private Document content;

    /**
     * Название ключа, который должен быть использован для проверки подпись.
     * Строка от 1 до 32 символов.
     * Для клиентов используется их ИНН, для партнеров и платежных агентов код с маской 301****, для вендинга 401****.
     */
    @SerializedName("key")
    private String key;

    /**
     * URL для отправки результатов обработки чека POST запросом
     * Строка от 1 до 1024 символов или null
     */
    @Nullable
    @SerializedName("callbackUrl")
    private String callbackUrl;

  public DocumentRequestBody(String id, String inn, Document content, String key, @Nullable String callbackUrl) {
        this.id = id;
        this.inn = inn;
        this.content = content;
        this.key = key;
        this.callbackUrl = callbackUrl;
    }

    public DocumentRequestBody(String id, String inn, @Nullable String group, Document content, String key, @Nullable String callbackUrl) {
        this.id = id;
        this.inn = inn;
        this.group = group;
        this.content = content;
        this.key = key;
        this.callbackUrl = callbackUrl;
    }

    public String getId() {
        return id;
    }

    public String getInn() {
        return inn;
    }

    public String getGroup() {
        return group;
    }

    public Document getContent() {
        return content;
    }

    public String getKey() {
        return key;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    @Override
    public String validate() {
        return check("id", id, 1, 64, false) +
                check("inn", inn, 10, 12, false) +
                check("group", group, 1, 32, true) +
                content.validate() +
                check("key", key, 1, 32, true) +
                check("callbackUrl", callbackUrl, 1, 1024, true);
    }

}