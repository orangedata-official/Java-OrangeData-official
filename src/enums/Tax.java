package enums;

/**
 * Created by Alexey Padyukov on 19.06.2017.
 */

//Ставка НДС:
public enum Tax {

    //ставка НДС 18%
    NDS_18(1),
    //ставка НДС 10%
    NDS_10(2),
    //ставка НДС расч. 18/118
    RASCH_18_118(3),
    //ставка НДС расч. 10/110
    RASCH_10_110(4),
    //ставка НДС 0%
    NDS_0(5),
    //НДС не облагается
    NONE(6);

    private int code;

    Tax(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
