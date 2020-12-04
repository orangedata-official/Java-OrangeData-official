package ru.orangedata.orangelib.network;

public class NetworkCodes {

    /**
     * 200 Ok - чек обработан, тело ответа п.2.2.1
     */
    public static final int OK = 200;

    /**
     * 201 Created - чек создан и добавлен в очередь на обработку, пустое тело ответа
     */
    public static final int CREATED = 201;

    /**
     * 202 Accepted – чек создан и добавлен в очередь на обработку, но еще не обработан, пустое тело ответа
     */
    public static final int ACCEPTED = 202;

    /**
     * 400 Bad Request - переданные данные содержат ошибки валидации, либо подпись не прошла проверку, тело ответа п.2.1.2
     */
    public static final int BAD_REQUEST = 400;

    /**
     * 401 Unauthorized - клиентский сертификат не прошел проверку
     */
    public static final int UNAUTHORIZED = 401;

    /**
     * 404 Unauthorized - чек не найден
     */
    public static final int NOT_FOUND = 404;

    /**
     * 409 Conflict - чек с данным идентификатором уже был создан в системе, пустое тело ответа
     */
    public static final int CONFLICT = 409;

    /**
     * 503 Service Unavailable - очередь документов переполнена, в ответе возвращается хидер Retry-After с таймаутом в секундах, через который стоит повторить запрос, тело ответа п.2.1.2.
     */
    public static final int SERVICE_UNAVAILABLE = 503;

    /**
     * 524 Document Expired Before Processing – серверу не удалось за отведенное время обработать документ, отправьте чек с новым идентификатором для повторной обработки, пустое тело ответа
     */
    public static final int DOCUMENT_EXPIRED_BEFORE_PROCESSING = 524;

}
