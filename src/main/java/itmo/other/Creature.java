package itmo.other;

import itmo.enums.Gender;
import itmo.enums.Location;
import itmo.enums.Property;
import itmo.interfaces.Entityable;
import itmo.interfaces.Locationable;
import itmo.interfaces.Propertyable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Creature implements Locationable, Propertyable, Entityable {

    public static final String typeName = "'Creature'";

    protected String name;
    protected Location previousLocation;
    protected Location location;
    protected ArrayList<Property> properties;
    protected Gender gender;

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
    public void setProperties(ArrayList<Property> properties) {
        this.properties = properties;
    }


}
