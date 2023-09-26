package com.school42.malaga.avaj.aircraft;

import com.school42.malaga.avaj.Coordinates;

public class Helicopter extends Aircraft {
    public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    @Override
    public void updateConditions() {
        switch (this.weatherTower.getWeather(this.coordinate)) {
            case "SUN" -> {
                this.coordinate.updateLongitude(10);
                this.coordinate.updateHeight(2);
                System.out.println(this + ": This is hot.");
            }
            case "RAIN" -> {
                this.coordinate.updateLongitude(5);
                System.out.println(this + ": My rotor is going to freeze!");
            }
            case "FOG" -> {
                this.coordinate.updateLongitude(1);
                System.out.println(this + ": This is not looking good");
            }
            case "SNOW" -> {
                this.coordinate.updateHeight(-12);
                System.out.println(this + ": My rotor is going to freeze!");
            }
        }
        if (this.coordinate.getHeight() == 0) {
            System.out.println(this + ": landing.");
            this.weatherTower.unregister(this);
        }
    }

    @Override
    public String toString() {
        return "Helicopter#" + this.name + "(" + this.id + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Helicopter)) return false;
        else return super.equals(o);
    }
}
