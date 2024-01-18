package itmo.other;

import itmo.enums.Gender;
import itmo.enums.Location;
import itmo.enums.Property;
import itmo.exceptions.NegativeAmountOfJam;
import itmo.interfaces.Locationable;
import itmo.interfaces.Propertyable;

import java.util.ArrayList;
import java.util.List;

public abstract class Creature implements Locationable, Propertyable {

    public static final String typeName = "'Creature'";

    protected String name;
    protected Location previousLocation;
    protected Location location;
    protected ArrayList<Property> properties;
    protected Gender gender;

    public Creature() {
    }

    public Creature(String name,
                    Location previousLocation,
                    Location location,
                    Gender gender,
                    Property...properties) {
        this.name = name;
        this.previousLocation = previousLocation;
        this.location = location;
        this.properties = new ArrayList<Property>();
        this.gender = gender;
        this.properties.addAll(List.of(properties));
    }

    public void changeLocation(Location locationTo){
        this.setPreviousLocation(this.getLocation());
        this.setLocation(locationTo);
        System.out.println(
                "Объект " +
                        this.getTypeName() + " " +
                        this.getName() + " " +
                        "сменил локацию на " +
                        locationTo + ".");
    }

    public void comeBack() throws NegativeAmountOfJam {
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

    public void cleanProperties() {
        this.getProperties().clear();
        System.out.println(
                "Объект " +
                        this.getTypeName() + " " +
                        this.getName() + " " +
                        "лишился всех свойств."
        );
    }

    public void addProperties(Property... varArgProperties) {
        this.getProperties().addAll(List.of(varArgProperties));
        System.out.print(
                "Объекту " +
                        this.getTypeName() + " " +
                        this.getName() + " " +
                        "добавлены свойства: ");
        for (int i = 0; i < varArgProperties.length; i++) {
            System.out.print(varArgProperties[i]);
            if (i != varArgProperties.length - 1) System.out.print(", ");
        }
        System.out.println(".");
    }

    public String getName() {
        return name;
    }
    public String getTypeName() {
        return typeName;
    }
    public Location getPreviousLocation() {
        return previousLocation;
    }
    public void setPreviousLocation(Location previousLocation) {
        this.previousLocation = previousLocation;
    }
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public ArrayList<Property> getProperties() {
        return properties;
    }
}
