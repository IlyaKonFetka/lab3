package itmo.other;

import itmo.enums.Gender;
import itmo.enums.Location;
import itmo.enums.Mood;
import itmo.interfaces.SuperProperty;

import java.util.ArrayList;

public class HumanWithPropeller extends Human{

    public static final String typeName = "'Human with propeller'";

    public HumanWithPropeller(String name, Gender gender) {
        super(name, gender);
    }

    public HumanWithPropeller(String name, Location location, Gender gender) {
        super(name, location, gender);
    }

    public HumanWithPropeller(String name,
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
        super(name, health, stamina, hunger, age, power, previousLocation, location, mood, gender,properties);
    }

    public void flyUp(){
        changeLocation(Location.IN_AIR);
        System.out.println(
                "Объект " +
                typeName  + " " +
                this.name +
                " взлетел в воздух."
                );
    }

    public void flyTo(Location locationTo){
        this.setPreviousLocation(this.getLocation());
        this.setLocation(locationTo);
        System.out.println(
                "Объект " +
                typeName  + " " +
                this.name +
                " улетел в локацию " +
                locationTo + "."
                );
    }


}
