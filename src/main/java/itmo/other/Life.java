package itmo.other;

import itmo.enums.*;
import itmo.exceptions.NegativeAmountOfJam;

import java.io.File;

public class Life {
    public static void main(String[] args){
        Human malish = new Human(
                "Малыш",
                Gender.MALE,
                null,
                Location.HOME,
                50,
                8020,
                001234,
                2015,
                1,
                1,
                Country.RUSSIA,
                null,
                Mood.NORMAL,
                Property.UNBROKEN,
                Property.ALIVE
        );
        HumanWithPropeller karlson = new HumanWithPropeller(
                "Карлсон",
                Gender.MALE,
                null,
                Location.HOME,
                50,
                8020,
                001235,
                2005,
                1,
                1,
                Country.RUSSIA,
                "A",
                Mood.NORMAL,
                25,
                Property.UNBROKEN,
                Property.ALIVE
        );
        Human father = new Human("Отец",
                Gender.MALE,
                null,
                Location.HOME,
                50,
                8020,
                132456,
                1990,
                1,
                1,
                Country.RUSSIA,
                null,
                Mood.NORMAL,
                Property.UNBROKEN,
                Property.ALIVE);
        malish.changeDegreeOfAgreement(0);
        malish.changeMood(Mood.CAPRICIOUS);
        karlson.changeMood(Mood.ANGRY);
        try {
            karlson.flyTo(Location.HOUSE_ON_THE_ROOF);
        } catch (NegativeAmountOfJam e) {
            throw new RuntimeException("Карлсон кончился :(", e);
        }
        for(int i = 0; i < 2; i++) malish.say("Прилетай скорей!",karlson);
        try {
            karlson.comeBack();
        } catch (NegativeAmountOfJam e) {
            throw new RuntimeException("Карлсон кончился :(", e);
        }
        malish.changeLocation(Location.COOK_TABLE);
        karlson.changeLocation(Location.COOK_TABLE);
        karlson.upAmountOfJam(new Goods.BottleOfJam(
                80,
                12345600,
                5
        ));


        /**
        //СИТУАЦИЯ НОМЕР 1 НЕПРОВЕРЯЕМОЕ ИСКЛ
        karlson.flyTo(Location.HOUSE_ON_THE_ROOF);
        malish.changeLocation(Location.HOUSE_ON_THE_ROOF);
        malish.losePersonalDocument();
        father.changeMood(Mood.ANGRY);
        father.say("Малыш, достань своё Свидетельство о рождении!", malish);
        try{
            malish.say(malish.getPersonalDocument().series + " ", father);
        }catch (NullPointerException e){
            throw new NoPersonalDocumentException("У гражданина отсутствует документ, удостоверяющий личность!", e);
        }
        **/

        /**
        //СИТУАЦИЯ НОМЕР 2 ПРОВЕРЯЕМОЕ ИСКЛ
        try {
            karlson.flyTo(Location.IN_AIR);
        } catch (NegativeAmountOfJam e) {
            throw new RuntimeException("Карлсон кончился :(", e);
        }
        **/

        //АНОНИМНЫЙ КЛАСС
        Human domomuchitelnica = new Human("Домомучительница",
                Gender.WOMAN,
                null,
                Location.HOME,
                50,
                8020,
                435232,
                1970,
                1,
                1,
                Country.RUSSIA,
                null,
                Mood.NORMAL,
                Property.UNBROKEN,
                Property.ALIVE){
            @Override
            public void say(String replica, Creature creature) {
                System.out.println(
                                "Объект " +
                                this.getTypeName()  + " " +
                                this.name +
                                " прокряхтела объекту " +
                                creature.getTypeName() + " " +
                                creature.name + ": \"" +
                                replica + "\".");
            }
        };
        domomuchitelnica.say("Как ты мог потерять документ, Малыш?!", malish);

        //ЛОКАЛЬНЫЙ КЛАСС
        File text = new File("KarlsonMessage.txt");
        karlson.writeTheTelegram(
                new Goods.PostageStamp(5,
                        123,
                        "Почта России",
                        Country.RUSSIA),
                text,
                Country.RUSSIA,
                father
        );
    }
}