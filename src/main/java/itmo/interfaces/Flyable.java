package itmo.interfaces;

import itmo.enums.Location;

public interface Flyable extends Locationable,Entityable{
    default void flyTo(Location locationTo){
        this.setPreviousLocation(this.getLocation());
        this.setLocation(locationTo);
        System.out.println(
                "Объект " +
                        this.getTypeName()  + " " +
                        this.getName() +
                        " улетел в локацию " +
                        locationTo + "."
        );
    }
}
