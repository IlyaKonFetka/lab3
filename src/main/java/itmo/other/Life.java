package itmo.other;

import itmo.enums.*;
import itmo.interfaces.SuperProperty;

import javax.tools.DocumentationTool;
import java.awt.*;
import java.util.ArrayList;

public class Life {
    public static void main(String[] args){
        List list = new List();
        list.add(String.valueOf(OutProperty.ALIVE));
        Human malysh = new Human(
                "Малыш",
                100,
                80,
                80,
                12,
                10,
                null,
                Location.HOME,
                Mood.CALM,
                Gender.MALE,
                8020,
                123456,
                "Россия",
                "Башкортостан",
                "Уфа",
                2005,
                1,
                1,
                "Малышевич",
                null,
                OutProperty.ALIVE, OutProperty.UNBROKEN
                );
        HumanWithPropeller karlson = new HumanWithPropeller(
                "Карлсон",
                100,
                99,
                1,
                33,
                50,
                null,
                Location.HOME,
                Mood.CALM,
                Gender.MALE,
                0,
                0,
                "Россия",
                "Башкортостан",
                "Уфа",
                1990,
                19,
                1,
                "Карлсонович",
                null,
                20,
                OutProperty.ALIVE,OutProperty.UNBROKEN
        );
        malysh.addProperties(InProperty.DISSENTING);
        malysh.changeMood(Mood.SELF_CONFIDENT);
        karlson.changeMood(Mood.ANGRY);
        karlson.flyTo(Location.HOUSE_ON_THE_ROOF);
        for(int i = 0; i < 2; i++) malysh.say("Прилетай скорей!",karlson);
        karlson.comeBack();
        malysh.changeLocation(Location.COOK_TABLE);
        karlson.changeLocation(Location.COOK_TABLE);

    }
}
