package itmo.other;

import itmo.enums.Location;
import itmo.enums.OutProperty;
import itmo.interfaces.Locationable;
import itmo.interfaces.Propertyable;
import itmo.interfaces.SuperProperty;

import java.util.ArrayList;

public abstract class Item extends Entity implements Locationable, Propertyable {
    public static final String typeName = "'Item'";
    private Location previousLocation;
    private Location location;
    private ArrayList<SuperProperty> properties;
    public Item(String name) {
        super(name);
    }

    @Override
    public Location getPreviousLocation() {
        return previousLocation;
    }

    @Override
    public void setPreviousLocation(Location previousLocation) {
        this.previousLocation = previousLocation;
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public ArrayList<SuperProperty> getProperties() {
        return properties;
    }

    @Override
    public void setProperties(ArrayList<SuperProperty> properties) {
        this.properties = properties;
    }
}
