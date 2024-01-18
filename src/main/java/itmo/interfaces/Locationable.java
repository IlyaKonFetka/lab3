package itmo.interfaces;

import itmo.enums.Location;
import itmo.exceptions.NegativeAmountOfJam;

public interface Locationable {
    void changeLocation(Location locationTo);
    void comeBack() throws NegativeAmountOfJam;
    Location getPreviousLocation();
    void setPreviousLocation(Location previousLocation);
}
