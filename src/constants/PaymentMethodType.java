package constants;

public class PaymentMethodType {
    /// <summary>
    ///     Предоплата 100%
    /// </summary>
    public static int Prepay = 1;
    /// <summary>
    ///     Частичная предоплата
    /// </summary>
    public static int PartialPrepay=2;
    /// <summary>
    ///     Аванс
    /// </summary>
    public static int Advance=3;
    /// <summary>
    ///     Полный расчёт
    /// </summary>
    public static int Full=4;
    /// <summary>
    ///     Частичный расчёт и кредит
    /// </summary>
    public static int PartialAndCredit=5;
    /// <summary>
    ///     Передача в кредит
    /// </summary>
    public static int CreditTransfer=6;
    /// <summary>
    ///     Оплата кредита
    /// </summary>
    public static int CreditPayment=7;
}
