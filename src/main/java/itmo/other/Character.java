package itmo.other;

import itmo.enums.Mood;
import itmo.enums.Replica;
import itmo.interfaces.Moodable;
import itmo.interfaces.Replicable;

public class Character extends Entity implements Moodable, Replicable { // Персонаж
    Mood mood;



    public Character(String name) {
        super(name);
    }

    public Character(String name, Mood mood) {
        super(name);
        this.mood = mood;
    }

    @Override
    public void getMood(Mood mood) {

    }

    @Override
    public void setMood(Mood mood) {

    }


    @Override
    public void say(String message) {

    }

    @Override
    public void say(Replica replica, String message) {
        System.out.println(this.name + ": \"" + message + "\"");
    }

    @Override
    public void say(Replica replica, Creature toCreature, String message) {
        System.out.println(this.name + " " + Replica.getSayVerb(this.mood) + toCreature);
    }

    @Override
    public void say(Replica replica, Creature toCreature, Mood emotion, String message) {
        this.mood = emotion;
        System.out.println(this.name + " " + Replica.getSayVerb(this.mood) + toCreature);
    }

    @Override
    public void say(Replica replica, Mood emotion, String message) {
        this.mood = emotion;
        System.out.println(this.name + " " + Replica.getSayVerb(this.mood));
    }
}
