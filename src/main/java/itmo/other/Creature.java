package itmo.other;

import itmo.enums.Location;
import itmo.enums.OutProperty;
import itmo.interfaces.Locationable;
import itmo.interfaces.Propertyable;
import itmo.interfaces.SuperProperty;

import javax.management.timer.Timer;
import java.util.ArrayList;
import java.util.List;

public abstract class Creature extends Entity implements Locationable, Propertyable {
    public static final String typeName = "'Creature'";
    private int health;     // min = 0 max = 100
    private int stamina;    // min = 0 max = 100
    private int hunger;     // min = 0 max = 100
    private int age;        // def = 50
    private int power;      // min = 1 has no limit
    private Location previousLocation;
    private Location location;
    private ArrayList<SuperProperty> properties;



    public Creature(String name, Location location) {
        super(name);
        this.health = 100;
        this.stamina = 50;
        this.hunger = 50;
        this.age = 0;
        this.power = 1;
        this.previousLocation = Location.MOTHERS_WOMB;
        this.properties = new ArrayList<SuperProperty>();
        this.properties.add(OutProperty.UNBROKEN);
    }

    public Creature(String name,
                    int health,
                    int stamina,
                    int hunger,
                    int age,
                    int power,
                    Location previousLocation,
                    Location location,
                    SuperProperty...properties) {
        super(name);
        this.health = health;
        this.stamina = stamina;
        this.hunger = hunger;
        this.age = age;
        this.power = power;
        this.previousLocation = previousLocation;
        this.location = location;
        this.properties = new ArrayList<SuperProperty>();
        this.properties.addAll(List.of(properties));
    }

    private void plusAge(){
        this.age++;
        System.out.println(
                        "Объект " +
                        this.getTypeName() + " " +
                        this.name + " " +
                        "стал старше на год. Теперь ему " +
                        this.age + "."
        );

    }

    public void takeTreatment(int plusHealth) {
        this.health = plusHealth > 100 - this.health?100:this.health + plusHealth;
        System.out.println(
                        "Объект " +
                        this.getTypeName() + " " +
                        this.name + " " +
                        "получил лечение в размере " +
                        plusHealth + " единиц.");
    }

    public void takeDamage(int damage) {
        this.health = damage > this.health?0:this.health - damage;
        System.out.println(
                        "Объект " +
                        this.getTypeName() + " " +
                        this.name + " " +
                        "получил урон в размере " +
                        damage + " единиц.");
    }

    public int getHealth(){
        return this.health;
    }

    public void upStamina(int plusStamina) {
        this.stamina = plusStamina > 100 - this.stamina?100:this.stamina + plusStamina;
        System.out.println(
                        "Объект " +
                        this.getTypeName() + " " +
                        this.name + " " +
                        "восстановил выносливость до значения " +
                        this.stamina + "единиц.");
    }

    public void downStamina(int minusStamina) {
        this.stamina = minusStamina > this.stamina?0:this.stamina - minusStamina;
        System.out.println(
                        "Объект " +
                        this.getTypeName() + " " +
                        this.name + " " +
                        "потратил выносливость до значения " +
                        this.stamina + "единиц.");
    }

    public void eat(int food) {
        this.hunger = food > 100 - this.hunger?100:this.hunger + food;
        System.out.println(
                        "Объект " +
                        this.getTypeName() + " " +
                        this.name + " " +
                        "восстановил насыщение до  " +
                        this.hunger + "единиц.");
    }

    public void toHunger(int minusHunger) {
        this.hunger = minusHunger > this.hunger?0:this.hunger - minusHunger;
        System.out.println(
                        "Объект " +
                        this.getTypeName() + " " +
                        this.name + " " +
                        "потратил насыщение до  " +
                        this.hunger + "единиц.");
    }

    public int getHunger(){
        return this.health;
    }

    public int getPower() {
        return power;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getStamina(){
        return this.stamina;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPower(int power) {
        this.power = power;
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

    public ArrayList<SuperProperty> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<SuperProperty> properties) {
        this.properties = properties;
    }

    public void upPower(int powerUp) {
        this.power += powerUp;
        System.out.println(
                        "Объект " +
                        this.getTypeName() + " " +
                        this.name + " " +
                        "увеличил физическую силу до " +
                        this.power + "единиц.");
    }

    public void downPower(int powerDown){
        this.power = Math.max(this.power - powerDown, 1);
        System.out.println(
                        "Объект " +
                        this.getTypeName() + " " +
                        this.name + " " +
                        "уменьшил физическую силу до " +
                        this.power + "единиц.");
    }
}
