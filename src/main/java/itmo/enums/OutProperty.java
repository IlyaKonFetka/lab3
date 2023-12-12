package itmo.enums;

public enum Property {
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

    Property(String letter) {
        this.letter = letter;
    }
}
