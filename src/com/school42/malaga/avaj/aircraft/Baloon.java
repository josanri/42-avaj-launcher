package com.school42.malaga.avaj.aircraft;

import com.school42.malaga.avaj.Coordinates;

public class Baloon extends Aircraft {
    public Baloon(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    @Override
    public void updateConditions() {
        switch (this.weatherTower.getWeather(this.coordinate)) {
            case "SUN" -> {
                this.coordinate.updateLongitude(2);
                this.coordinate.updateHeight(4);
                System.out.println(this + ": Let's enjoy the good weather and take some pics.");
            }
            case "RAIN" -> {
                this.coordinate.updateHeight(-5);
                System.out.println(this + ": Damn you rain! You messed up my baloon.");
            }
            case "FOG" -> {
                this.coordinate.updateHeight(-3);
                System.out.println(this + ": Oh, I can't see anything");
            }
            case "SNOW" -> {
                this.coordinate.updateHeight(-15);
                System.out.println(this + ": It's snowing. We're gonna crash.");
            }
        }
        if (this.coordinate.getHeight() == 0) {
            System.out.println(this + ": landing.");
            this.weatherTower.unregister(this);
        }
    }

    @Override
    public String toString() {
        return "Baloon#" + this.name + "(" + this.id + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Baloon)) return false;
        else return super.equals(o);
    }
}
