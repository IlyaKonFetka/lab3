package itmo.other;

import itmo.enums.Location;

public abstract class Animal extends Creature {
    public static final String typeName = "'Animal'";

    public Animal(String name, Location location) {
        super(name, location);
    }
}
