package itmo.other;

import itmo.enums.*;
import itmo.exceptions.NegativeAmountOfJam;
import itmo.interfaces.Flyable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class HumanWithPropeller
        extends Human
        implements Flyable {

    public static final String typeName = "'Human with propeller'";

    private int amountOfJam;

    public HumanWithPropeller(String name,
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
                              int amountOfJam,
                              Property... properties) {
        super(name, gender, previousLocation, location, degreeOfAgreement, series, number, yearOfBirth, monthOfBirth, dayOfBirth, countryOfBirth, militaryDuty, mood, properties);
        this.amountOfJam = amountOfJam;
    }

    public void upAmountOfJam(Goods.BottleOfJam bottleOfJam){
        this.amountOfJam += bottleOfJam.volume;
        System.out.println(
                        "Объект " +
                        this.getTypeName()  + " " +
                        this.getName() +
                        " пополнил уровень джема до " +
                        this.amountOfJam + " литров."
        );
    }

    @Override
    public String getTypeName() {
        return typeName;
    }
    public void flyTo(Location locationTo) throws NegativeAmountOfJam {
        this.amountOfJam -= 10;
        this.setPreviousLocation(this.getLocation());
        this.setLocation(locationTo);
        System.out.println(
                        "Объект " +
                        this.getTypeName()  + " " +
                        this.getName() +
                        " улетел в локацию " +
                        locationTo + " и потратил 10 литров джема."
        );
        if (this.amountOfJam <= 0){
            throw new NegativeAmountOfJam("Объект потратил слишком много джема.");
        }
    }

    @Override
    public void comeBack() throws NegativeAmountOfJam {
        super.comeBack();
        this.amountOfJam -= 10;
        System.out.println(
                "Объект " +
                        this.getTypeName()  + " " +
                        this.getName() +
                        " потратил 10 литров джема."
        );
        if (this.amountOfJam <= 0){
            throw new NegativeAmountOfJam("Объект потратил слишком много джема.");
        }
    }
}
