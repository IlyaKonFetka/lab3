package itmo.other;

import itmo.enums.Gender;
import itmo.enums.Location;
import itmo.enums.Mood;
import itmo.interfaces.SuperProperty;

import java.util.ArrayList;
import java.util.List;

public class Human extends Creature {
    public static final String typeName = "'Human'";
    private Mood mood;
    private final Gender gender;

    public Human(String name, Gender gender) {
        super(name, Location.MATERNITY_HOSPITAL);
        this.mood = Mood.NORMAL;
        this.gender = gender;
    }
    public Human(String name, Location location, Gender gender) {
        super(name, location);
        this.mood = Mood.NORMAL;
        this.gender = gender;
    }

    public Human(String name,
                 int health,
                 int stamina,
                 int hunger,
                 int age,
                 int power,
                 Location previousLocation,
                 Location location,
                 Mood mood,
                 Gender gender,
                 SuperProperty...properties) {
        super(name, health, stamina, hunger, age, power, previousLocation, location, properties);
        this.mood = mood;
        this.gender = gender;
    }

    public void changeMood(Mood moodTo) {
        this.mood = moodTo;
        System.out.println(
                "Объект " +
                typeName  + " " +
                this.name +
                " сменил настроение на " +
                this.mood + ".");
    }

    public void shareMood(Creature creatureTo) {
        System.out.println(
                "Объект " +
                typeName  + " " +
                this.name +
                " поделился своим настроением с объектом " +
                creatureTo.getTypeName()  + " " +
                creatureTo.name + ": " +
                this.mood + ".");
    }

    public void shareMood(Mood moodTo, Creature creatureTo) {
        this.changeMood(moodTo);
        this.shareMood(creatureTo);
    }

    public void say(String replica) {
        System.out.println(
                "Объект " +
                typeName  + " " +
                this.name +
                " произнёс: \"" +
                replica + "\".");
    }

    public void say(String replica, Entity entity) {
        System.out.println(
                "Объект " +
                typeName  + " " +
                this.name +
                " произнёс объекту " +
                entity.getTypeName() + " " +
                entity.name + ": \"" +
                replica + "\".");
    }

    public void say(String replica, Entity... entities) {
        System.out.print(
                "Объект " +
                typeName  + " " +
                this.name +
                " произнёс объектам ");
        for (int i = 0; i < entities.length; i++) {
            System.out.print(entities[i].getTypeName() + " " + entities[i].name);
            if (i != entities.length - 1) System.out.print(", ");
        }
        System.out.println(
                ": \"" +
                replica +
                "\".");
    }


}
