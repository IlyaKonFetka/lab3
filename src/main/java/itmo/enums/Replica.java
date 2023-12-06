package itmo.enums;

public enum Replica { //Реплики персонажей
    THINK_PAST("считал"),
    HELLO("привет"),
    LET_FLY_BACK("прилетай"),
    FASTER("быстрее");




    private final String replica;

    private Replica(String s) {
        this.replica = s;
    }
    public static String getSayVerb(Mood emotion){
        return switch(emotion){
            case CALM -> "прошептал";
            case ANGRY -> "крикнул";
            case NORMAL -> "сказал";
            case HORNY -> "просигналил";

            default -> " ";
        };
    }
    @Override
    public String toString() {
        return this.replica;
    }
}
