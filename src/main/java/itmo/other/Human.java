package itmo.other;

import itmo.enums.Gender;
import itmo.enums.Location;
import itmo.enums.Mood;
import itmo.interfaces.SuperProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Human extends Creature {

    public static final String typeName = "'Human'";

    protected String name;
    private int health;     // min = 0 max = 100
    private int stamina;    // min = 0 max = 100
    private int hunger;     // min = 0 max = 100
    private int age;        // def = 50
    private int power;      // min = 1 has no limit
    private Location previousLocation;
    private Location location;
    private ArrayList<SuperProperty> properties;
    private Mood mood;
    private final Gender gender;
    private Passport passport;

    public class Passport{
        private int series;
        private int number;
        private String country;
        private String region;
        private String city;
        private Date dateOfBorn;
        private String name;
        private String surname;
        private ArrayList<Human>children;

        public Passport(int series,
                        int number,
                        String country,
                        String region,
                        String city,
                        Date dateOfBorn,
                        String name,
                        String surname,
                        ArrayList<Human> children) {
            this.series = series;
            this.number = number;
            this.country = country;
            this.region = region;
            this.city = city;
            this.dateOfBorn = dateOfBorn;
            this.name = name;
            this.surname = surname;
            this.children = children;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Passport passport = (Passport) o;
            return (series == passport.series) && (number == passport.number) && Objects.equals(dateOfBorn, passport.dateOfBorn) && Objects.equals(name, passport.name) && Objects.equals(surname, passport.surname);
        }

        @Override
        public int hashCode() {
            return Objects.hash(series, number, dateOfBorn);
        }

        @Override
        public String toString() {
            return "Passport{" +
                    "series=" + series +
                    ", number=" + number +
                    ", country='" + country + '\'' +
                    ", region='" + region + '\'' +
                    ", city='" + city + '\'' +
                    ", dateOfBorn=" + dateOfBorn +
                    ", name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    '}';
        }
        //================= Getters And Setters =======================

        public int getSeries() {return series;}
        public void setSeries(int series) {this.series = series;}
        public int getNumber() {return number;}
        public void setNumber(int number) {this.number = number;}
        public String getCountry() {return country;}
        public void setCountry(String country) {this.country = country;}
        public String getRegion() {return region;}
        public void setRegion(String region) {this.region = region;}
        public String getCity() {return city;}
        public void setCity(String city) {this.city = city;}
        public Date getDateOfBorn() {return dateOfBorn;}
        public void setDateOfBorn(Date dateOfBorn) {this.dateOfBorn = dateOfBorn;}
        public String getName() {return name;}
        public void setName(String name) {this.name = name;}
        public String getSurname() {return surname;}
        public void setSurname(String surname) {this.surname = surname;}
        public ArrayList<Human> getChildren() {return children;}
        public void setChildren(ArrayList<Human> children) {this.children = children;}
    }

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
                 int series,
                 int number,
                 String country,
                 String region,
                 String city,
                 int year,
                 int month,
                 int date,
                 String surname,
                 ArrayList<Human> children,
                 SuperProperty...properties) {
        super(name, health, stamina, hunger, age, power, previousLocation, location, properties);
        this.mood = mood;
        this.gender = gender;
        this.passport = new Passport(
                series,
                number,
                country,
                region,
                city,
                new Date(year,month,date),
                name,
                surname,
                new ArrayList<>());
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human human)) return false;
        if (!super.equals(o)) return false;
        return getAge() == human.getAge() && Objects.equals(getName(), human.getName()) && gender == human.gender && Objects.equals(passport, human.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", power=" + power +
                ", gender=" + gender +
                ", passport=" + passport +
                ", name='" + name + '\'' +
                '}';
    }
}
