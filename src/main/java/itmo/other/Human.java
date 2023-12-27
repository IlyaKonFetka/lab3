package itmo.other;

import itmo.enums.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Human extends Creature {

    public static final String typeName = "'Human'";

    private Mood mood;
    private Passport passport;

    public Human(int series,
                 int number,
                 Date dateOfBorn,
                 Country birthPlace, //for example - Country
                 String name,
                 Gender gender,
                 Location previousLocation,
                 Location location,
                 Property... properties) {
        super(name, previousLocation, location, gender, properties);
        this.passport = new Passport(
                series,
                number,
                dateOfBorn,
                birthPlace,
                name);

    }

    public class Passport{
        private int series;
        private int number;
        private Date dateOfBorn;
        private Country birthPlace;
        private String name;


        public Passport(int series,
                        int number,
                        Date dateOfBorn,
                        Country birthPlace, //for example - Country
                        String name
        ) {
            this.series = series;
            this.number = number;
            this.dateOfBorn = dateOfBorn;
            this.birthPlace = birthPlace;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Passport passport = (Passport) o;
            return (series == passport.series) &&
                    (number == passport.number) &&
                    Objects.equals(dateOfBorn, passport.dateOfBorn) &&
                    Objects.equals(name, passport.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(series, number, dateOfBorn,name);
        }

        @Override
        public String toString() {
            return "Passport{" +
                    "series=" + series +
                    ", number=" + number +
                    ", dateOfBorn=" + dateOfBorn +
                    ", birthPlace=" + birthPlace +
                    ", name='" + name + '\'' +
                    '}';
        }
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

    public void say(String replica) {
        System.out.println(
                "Объект " +
                typeName  + " " +
                this.name +
                " произнёс: \"" +
                replica + "\".");
    }

    public void say(String replica, Creature creature) {
        System.out.println(
                "Объект " +
                typeName  + " " +
                this.name +
                " произнёс объекту " +
                creature.getTypeName() + " " +
                creature.name + ": \"" +
                replica + "\".");
    }

    public void say(String replica, Creature... creatures) {
        System.out.print(
                "Объект " +
                typeName  + " " +
                this.name +
                " произнёс объектам ");
        for (int i = 0; i < creatures.length; i++) {
            System.out.print(creatures[i].getTypeName() + " " + creatures[i].name);
            if (i != creatures.length - 1) System.out.print(", ");
        }
        System.out.println(
                ": \"" +
                replica +
                "\".");
    }

    @Override
    public String getTypeName() {
        return typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human human)) return false;
        return Objects.equals(passport, human.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", passport=" + passport +
                ", name='" + name + '\'' +
                '}';
    }
}