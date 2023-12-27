package itmo.enums;

public enum Location {
    HOME("дом"),
    HOUSE_ON_THE_ROOF("домик на крыше"),
    COOK_TABLE("обеденный стол"),
    MOTHERS_WOMB("утроб матери"),
    MATERNITY_HOSPITAL("родильный дом"),
    IN_AIR("в воздухе"),
    ;
    public final String letter;

    Location(String s) {
        this.letter = s;
    }

    @Override
    public String toString(){
        return this.letter;
    }
}
