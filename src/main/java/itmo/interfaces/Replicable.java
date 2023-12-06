package itmo.interfaces;

import itmo.enums.Mood;
import itmo.enums.Replica;
import itmo.other.Creature;

public interface Replicable {
    void say(String message);
    void say(Replica replica, String message);
    void say(Replica replica, Creature toCreature, String message);
    void say(Replica replica, Creature toCreature, Mood emotion, String message);
    void say(Replica replica, Mood emotion, String message);

}
