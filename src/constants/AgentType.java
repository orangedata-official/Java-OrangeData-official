package constants;

public class AgentType {
    /// <summary>
    ///     Банковский платежный агент
    /// </summary>
    public static  int BankAgent = 1;
    /// <summary>
    ///     Банковский платежный субагент
    /// </summary>
    public static  int BankSubAgent = 1 << 1;
    /// <summary>
    ///     Платежный агент
    /// </summary>
    public static  int PayingAgent = 1 << 2;
    /// <summary>
    ///     Платежный субагент
    /// </summary>
    public static  int PayingSubAgent = 1 << 3;
    /// <summary>
    ///     Поверенный
    /// </summary>
    public static  int Attorney = 1 << 4;
    /// <summary>
    ///     Комиссионер
    /// </summary>
    public static  int Comissioner = 1 << 5;
    /// <summary>
    ///     Иной агент
    /// </summary>
    public static  int Other = 1 << 6;
}
