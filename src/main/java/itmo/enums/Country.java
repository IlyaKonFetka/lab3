package itmo.enums;

public enum Country {
    RUSSIA("Россия"),
    ;

    public final String letter;

    Country(String s) {
        this.letter = s;
    }

    @Override
    public String toString(){
        return this.letter;
    }
}
