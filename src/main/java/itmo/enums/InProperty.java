package itmo.enums;

import itmo.interfaces.SuperProperty;

public enum InProperty implements SuperProperty {
    DISSENTING("несогласный"),
    CONSONANT("согласный"),
    TIRED("уставший"),
    HORNY("озабоченный")
    ;
    public final String letter;

    InProperty(String letter) {
        this.letter = letter;
    }

    @Override
    public String toString(){
        return this.letter;
    }
}
