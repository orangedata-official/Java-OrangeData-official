package models;

public class CheckKMResultBody {
    ///     Результат проверки КМ, 2004
    public Byte FsCheckStatus;

    ///     Причина, по которой не была проведена локальная проверка
    public Byte FsCheckStatusCause;

    ///     Тип кода маркировки, 2100
    public Byte FsItemCodeType;

    ///     Результат проверки сведений о товаре, 2106
    public Byte CheckResult;

    ///     Код ответа ФН на команду онлайн-проверки
    public Byte OismCheckResultCode;

    ///     Код ответа ФН на команду онлайн-проверки
    public OismResponseBody OismResponse;
}
