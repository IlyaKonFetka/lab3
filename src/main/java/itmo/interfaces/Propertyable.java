package itmo.interfaces;

import itmo.enums.Property;

import java.util.ArrayList;
import java.util.List;

public interface Propertyable{
    void addProperties(Property... varArgProperties);
    void cleanProperties();
    ArrayList<Property> getProperties();
}
