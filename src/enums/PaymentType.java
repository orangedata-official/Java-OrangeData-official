package enums;

/**
 * Created by Alexey Padyukov on 19.06.2017.
 */
public enum PaymentType {

    //Наличными
    CASH(1),
    //Картой Мир
    CARD_MIR(2),
    //Картой Visa
    CARD_VISA(3),
    //Картой MasterCard
    CARD_MASTERCARD(4),
    //Расширенная оплата 1
    EXTENDED_1(5),
    //Расширенная оплата 2
    EXTENDED_2(6),
    //Расширенная оплата 3
    EXTENDED_3(7),
    //Расширенная оплата 4
    EXTENDED_4(8),
    //Расширенная оплата 5
    EXTENDED_5(9),
    //Расширенная оплата 6
    EXTENDED_6(10),
    //Расширенная оплата 7
    EXTENDED_7(11),
    //Расширенная оплата 8
    EXTENDED_8(12),
    //Расширенная оплата 9
    EXTENDED_9(13),
    //Предвариательная оплата(Аванс)
    PREPAY(14),
    //Последующая оплата(Кредит)
    CREDIT(15),
    //Иная форма оплаты
    OTHER(16);

    private int code;

    PaymentType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
