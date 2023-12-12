package itmo.interfaces;

import itmo.enums.Location;

public interface Locationable extends Entityable{
    default void changeLocation(Location locationTo){
        this.setPreviousLocation(this.getLocation());
        this.setLocation(locationTo);
        System.out.println(
                        "Объект " +
                        this.getTypeName() + " " +
                        this.getName() + " " +
                        "сменил локацию на " +
                        locationTo + ".");
    };
    default void comeBack(){
        Location prevLoc = this.getPreviousLocation();
        this.setPreviousLocation(this.getLocation());
        this.setLocation(prevLoc);
        System.out.println(
                        "Объект " +
                        this.getTypeName() + " " +
                        this.getName() + " " +
                        "вернулся в локацию " +
                        this.getLocation() + "."
        );
    }
    Location getLocation();
    void setLocation(Location location);
    Location getPreviousLocation();
    void setPreviousLocation(Location previousLocation);
}
