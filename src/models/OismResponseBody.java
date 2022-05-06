package models;

public class OismResponseBody {
    ///     Дата и время запроса, 2114
    public String DateTime;

    ///     Коды обработки запроса, 2105
    public Byte ResultCode;

    ///     Тип кода маркировки, 2100
    public Byte ItemCodeType;

    ///     Ответ ОИСМ о статусе товара, 2109
    public Byte OismStatus;

    ///     Результаты обработки запроса, 2005
    public Byte ProcessingResults;

    ///     Идентификатор товара, 2101
    public String ItemId;
}
