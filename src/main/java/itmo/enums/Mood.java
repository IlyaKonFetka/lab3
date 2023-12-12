package itmo.enums;

public enum Mood {
    HAPPY("счастливое"),
    FUNNY("весёлое"),
    NORMAL("нормальное"),
    SAD("грустное"),
    GLAD("довольное"),
    SATISFIED("удовлетворенное"),
    ANGRY("злое"),
    KIND("доброе"),
    HORNY("озабоченное"),
    DEPRESSED("депрессивное"),
    CALM("спокойное"),
    SELF_CONFIDENT("уверенный")
    ;
    public final String letter;

    Mood(String letter) {
        this.letter = letter;
    }

    @Override
    public String toString(){
        return this.letter;
    }
}
