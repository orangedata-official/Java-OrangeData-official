package constants;

/**
 * Created by Alexey Padyukov on 19.06.2017.
 */
public class PaymentType {

    //Наличными
    public static final int CASH = 1;
    //Сумма по чеку электронными
    public static final int Emoney = 2;
    //Предвариательная оплата(Аванс)
    public static final int Advance = 14;
    //Последующая оплата(Кредит)
    public static final int CREDIT = 15;
    //Сумма по чеку (БСО) встречным предоставлением
    public static final int BSO = 16;
}
