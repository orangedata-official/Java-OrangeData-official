package models;

public class DeviceInfo {
    /// <summary>
    ///     Заводской номер устройства
    /// </summary>
    public String deviceSN;

    /// <summary>
    ///     Номер фискального накопителя
    /// </summary>
    public String fsNumber;

    /// <summary>
    ///     Наименование ОФД
    /// </summary>
    public String ofdName;

    /// <summary>
    ///     Адрес/IP и порт отправки чеков в ОФД
    /// </summary>
    public String odfAddress;

    /// <summary>
    ///     Количество неотправленных документов
    /// </summary>
    public int unsentDocumentsCount;

    /// <summary>
    ///     Дата и время создания первого неотправленного документа
    /// </summary>
    public String firstUnsentDocumentDate;

    /// <summary>
    ///     Общее количество документов в ФН
    /// </summary>
    public int fsDocumentsCount;

    /// <summary>
    ///     Срок конца действия ФН
    /// </summary>
    public String fsExpirationDate;
}
