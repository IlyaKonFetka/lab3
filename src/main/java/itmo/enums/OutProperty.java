package itmo.enums;

import itmo.interfaces.SuperProperty;

public enum OutProperty implements SuperProperty {
    DEAD("мертвый"),
    ALIVE("живой"),
    INJURED("раненый"),
    COLD("холодный"),
    FROZEN("замёрзший"),
    HOT("жаркий"),
    FIRE("горящий"),
    BROKEN("сломанный"),
    SCRATCHED("поцарананный"),
    UNBROKEN("невредимый"),
    MELT("растаявший"),
    ;
    public final String letter;

    OutProperty(String letter) {
        this.letter = letter;
    }

    @Override
    public String toString(){
        return this.letter;
    }
}
