package itmo.interfaces;

import itmo.enums.Mood;

public interface Moodable {
    void getMood(Mood mood);
    void setMood(Mood mood);
}
