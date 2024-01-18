package itmo.interfaces;

import itmo.enums.Location;
import itmo.exceptions.NegativeAmountOfJam;

@FunctionalInterface
public interface Flyable{
     void flyTo(Location locationTo) throws NegativeAmountOfJam;
}
