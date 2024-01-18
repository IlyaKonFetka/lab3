package itmo.other;

import itmo.enums.*;
import org.w3c.dom.Text;

import java.io.File;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Human extends Creature {

    public static final String typeName = "'Human'";

    private int degreeOfAgreement; // min = 0 max = 100 //
    private Mood mood;
    private PersonalDocument pDocument;

    public Human(String name, Location previousLocation, Location location, Gender gender, int degreeOfAgreement, Property... properties) {

    }

    public Human(String name,
                 Gender gender,
                 Location previousLocation,
                 Location location,
                 int degreeOfAgreement,
                 int series,
                 int number,
                 int yearOfBirth,
                 int monthOfBirth,
                 int dayOfBirth,
                 Country countryOfBirth,
                 String militaryDuty,
                 Mood mood,
                 Property... properties) {
        super(name, previousLocation, location, gender, properties);
        LocalDate dateOfBirth = LocalDate.of(yearOfBirth,monthOfBirth,dayOfBirth);
        if(Period.between(LocalDate.now(),dateOfBirth).getYears() >= 14){
            this.pDocument = new Passport(series,
                    number,
                    dateOfBirth,
                    name,
                    militaryDuty);
        }else {
            this.pDocument = new BirthCertificate(series,
                    number,
                    dateOfBirth,
                    countryOfBirth,
                    name);

        }
        this.degreeOfAgreement = degreeOfAgreement;
        this.mood = mood;
    }
    abstract public class PersonalDocument{
        public final int series;
        public final int number;
        public final LocalDate dateOfBorn;
        public final String name;

        public PersonalDocument(int series, int number, LocalDate dateOfBorn, String name) {
            this.series = series;
            this.number = number;
            this.dateOfBorn = dateOfBorn;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PersonalDocument that)) return false;
            return series == that.series && number == that.number && Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(series, number, name);
        }

        @Override
        public String toString() {
            return "PersonalDocument{" +
                    "series=" + series +
                    ", number=" + number +
                    ", dateOfBorn=" + dateOfBorn +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    public class Passport extends PersonalDocument{

        public String militaryDuty;

        public Passport(int series,
                        int number,
                        LocalDate dateOfBorn,
                        String name,
                        String militaryDuty
        ) {
            super(series, number, dateOfBorn, name);

            this.militaryDuty = militaryDuty;
        }

        @Override
        public String toString() {
            return "Passport{" +
                    "militaryDuty='" + militaryDuty + '\'' +
                    ", series=" + super.series +
                    ", number=" + super.number +
                    ", dateOfBorn=" + super.dateOfBorn +
                    ", name='" + super.name + '\'' +
                    '}';
        }
    }
    public class BirthCertificate extends PersonalDocument{
        public Country placeOfBirth;
        public BirthCertificate(int series,
                                int number,
                                LocalDate dateOfBorn,
                                Country birthPlace,
                                String name
                                ) {
            super(series, number, dateOfBorn, name);
            this.placeOfBirth = birthPlace;
        }

        @Override
        public String toString() {
            return "BirthCertificate{" +
                    "placeOfBirth=" + placeOfBirth +
                    ", series=" + super.series +
                    ", number=" + super.number +
                    ", dateOfBorn=" + super.dateOfBorn +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
    public void changeMood(Mood moodTo) {
        this.mood = moodTo;
        System.out.println(
                "Объект " +
                this.getTypeName()  + " " +
                this.getName() +
                " сменил настроение на " +
                this.mood + ".");
    }

    public void say(String replica, Creature creature) {
        System.out.println(
                "Объект " +
                this.getTypeName()  + " " +
                this.name +
                " произнёс объекту " +
                creature.getTypeName() + " " +
                creature.name + ": \"" +
                replica + "\".");
    }

    @Override
    public String getTypeName() {
        return typeName;
    }

    public void changeDegreeOfAgreement(int degreeOfAgreementTo){
        System.out.print(
                "Объект " +
                        this.getTypeName()  + " " +
                        this.name);
        System.out.print(degreeOfAgreementTo>=this.degreeOfAgreement?" повысил ":" понизил ");
        System.out.println("степень согласия до " +
                degreeOfAgreementTo +
                " процентов.");
        this.degreeOfAgreement = degreeOfAgreementTo;
    }

    public void losePersonalDocument() {
        this.pDocument =  null;
        System.out.println(
                        "Объект " +
                        this.getTypeName()  + " " +
                        this.name +
                        " потерял документ, удостоверяющий личность.");
    }

    public PersonalDocument getPersonalDocument() {
        return pDocument;
    }
    private interface Telegramable{
        String getMessage();
        Human getHumanTo();
        Country getCountryTo();
    }
    public Telegramable writeTheTelegram(Goods.PostageStamp postageStamp, File text, Country countryTo, Human humanTo){
        class Telegram implements Telegramable{
            public Goods.PostageStamp postageStamp;
            private File message;
            private Country countryTo;
            private Human humanTo;

            public Telegram(Goods.PostageStamp postageStamp, File message, Country countryTo, Human humanTo) {
                this.postageStamp = postageStamp;
                this.message = message;
                this.countryTo = countryTo;
                this.humanTo = humanTo;
            }

            @Override
            public String getMessage() {
                return "десериализованный текст";
            }
            @Override
            public Human getHumanTo() {
                return humanTo;
            }
            @Override
            public Country getCountryTo() {
                return countryTo;
            }
        }
        return new Telegram(postageStamp,text,countryTo,humanTo);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human human)) return false;
        return Objects.equals(pDocument, human.pDocument);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pDocument);
    }

    @Override
    public String toString() {
        return "Human{" +
                "pDocument=" + pDocument +
                ", gender=" + gender +
                '}';
    }
}