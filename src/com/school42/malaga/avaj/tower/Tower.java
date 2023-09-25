package com.school42.malaga.avaj.tower;

import com.school42.malaga.avaj.aircraft.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    List<Flyable> observers = new ArrayList<>();

    public void register(Flyable p_flyable) {
        this.observers.add(p_flyable);
        System.out.println("Tower says: " + p_flyable.toString() + " registered to weather tower.");
    }

    public void unregister(Flyable p_flyable) {
        this.observers.remove(p_flyable);
        System.out.println("Tower says: " + p_flyable.toString() + " unregistered from weather tower.");
    }

    protected void conditionChanged() {
        if (observers.size() == 0) return;
        List<Flyable> observersCopy = new ArrayList<>(observers);
        observersCopy.forEach(Flyable::updateConditions);
    }
}
