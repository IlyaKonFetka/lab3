package itmo.interfaces;

import itmo.enums.OutProperty;

import java.util.ArrayList;
import java.util.List;

public interface Propertyable extends Entityable{
    default void addProperties(SuperProperty... varArgProperties) {
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
    default void removeProperties(SuperProperty... varArgProperties) {
        this.getProperties().removeAll(List.of(varArgProperties));
        System.out.print(
                        "Объект " +
                        this.getTypeName() + " " +
                        this.getName() + " " +
                        "лишён свойств: "
        );
        for (int i = 0; i < varArgProperties.length; i++) {
            System.out.print(varArgProperties[i]);
            if (i != varArgProperties.length - 1) System.out.print(", ");
        }
        System.out.println(".");
    }
    default void updateProperties(SuperProperty... varArgProperties) {
        this.cleanProperties();
        this.addProperties(varArgProperties);
    }
    default void cleanProperties() {
        this.getProperties().clear();
        System.out.println(
                        "Объект " +
                        this.getTypeName() + " " +
                        this.getName() + " " +
                        "лишился всех свойств."
        );
    }


    ArrayList<SuperProperty> getProperties();
    void setProperties(ArrayList<SuperProperty> properties);
}
