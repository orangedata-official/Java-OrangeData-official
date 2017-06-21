package enums;

/**
 * Created by Alexey Padyukov on 19.06.2017.
 */

//Число от 0 до 5
public enum TaxationSystem {

    //Общая, ОСН
    OSN(0),
    //Упрощенная доход, УСН доход
    USN_INCOME(1),
    //Упрощенная доход минус расход, УСН доход - расход
    USN_INCOME_COSTS(2),
    //Единый налог на вмененный доход, ЕНВД
    ENVD(3),
    //Единый сельскохозяйственный налог, ЕСН
    ESN(4),
    //Патентная система налогообложения, Патент
    PATENT(5);

    private int code;

    TaxationSystem(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
