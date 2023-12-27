package itmo.other;

import itmo.enums.*;

import java.util.Calendar;
import java.util.Date;

public class Life {
    public static void main(String[] args){
        Human malysh = new Human(
                8020,
                123456,
                new Date(2005, Calendar.AUGUST,29),
                Country.RUSSIA,
                "Малыш",
                Gender.MALE,
                null,
                Location.HOME,
                Property.ALIVE, Property.UNBROKEN
        );
        HumanWithPropeller karlson = new HumanWithPropeller(
                8020,
                321654,
                new Date(1999,Calendar.APRIL,1),
                Country.RUSSIA,
                "Карлсон",
                Gender.MALE,
                null,
                Location.HOME,
                Property.ALIVE, Property.UNBROKEN);

        malysh.changeMood(Mood.SELF_CONFIDENT);
        karlson.changeMood(Mood.ANGRY);
        karlson.flyTo(Location.HOUSE_ON_THE_ROOF);
        for(int i = 0; i < 2; i++) malysh.say("Прилетай скорей!",karlson);
        karlson.comeBack();
        malysh.changeLocation(Location.COOK_TABLE);
        karlson.changeLocation(Location.COOK_TABLE);

    }
}
