package itmo.other;

import itmo.enums.Location;
import itmo.enums.Property;

public class Creature extends Entity { // Живое существо



    Location location;
    Property property;

    int hunger;     // max = 100, min = 0
    int health;     // max = 100, min = 0
    int stamina;    // def = 50

    public Creature(String name) {
        super(name);
    }



    @Override
    public String toString(){
        return this.name;
    }

}
