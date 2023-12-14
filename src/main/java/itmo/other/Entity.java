package itmo.other;

import itmo.interfaces.Entityable;

import java.util.Objects;

public abstract class Entity implements Entityable {

    public static final String typeName = "'Entity'";

    protected String name;

    public Entity(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(getName(), entity.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return "Entity{" +
                "name='" + name + '\'' +
                '}';
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
