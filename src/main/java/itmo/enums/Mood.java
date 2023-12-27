package itmo.enums;

public enum Mood {
    NORMAL("нормальное"),
    ANGRY("злое"),
    CALM("спокойное"),
    SELF_CONFIDENT("уверенное"),
    CAPRICIOUS("своенравное"),
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
