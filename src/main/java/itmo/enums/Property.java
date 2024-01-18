package itmo.enums;

public enum Property                            {
    ALIVE("живой"),
    UNBROKEN("невредимый"),
    ;
    public final String letter;

    Property(String letter) {
        this.letter = letter;
    }

    @Override
    public String toString(){
        return this.letter;
    }
}
