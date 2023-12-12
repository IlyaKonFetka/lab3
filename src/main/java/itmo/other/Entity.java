package itmo.other;

import itmo.interfaces.Entityable;

public abstract class Entity implements Entityable {
    protected String name;
    public static final String typeName = "'Entity'";

    public Entity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getTypeName() {
        return typeName;
    }

}
