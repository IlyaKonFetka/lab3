package itmo.enums;

public enum Gender {
    MALE("Мужчина"),
    WOMAN("Женщина"),
    WAR_HELICOPTER_MI_24("Боевой вертолёт Ми-24"),
    ;
    public final String letter;

    Gender(String s) {
        this.letter = s;
    }

    @Override
    public String toString(){
        return this.letter;
    }
}
