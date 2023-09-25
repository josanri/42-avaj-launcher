package com.school42.malaga.avaj.aircraft;

import com.school42.malaga.avaj.Coordinates;

public class JetPlane extends Aircraft {
    public JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    @Override
    public void updateConditions() {
        switch (this.weatherTower.getWeather(this.coordinate)) {
            case "SUN" -> {
                this.coordinate.updateLatitude(10);
                this.coordinate.updateHeight(2);
                System.out.println(this + ": What a great sunny day");
            }
            case "RAIN" -> {
                this.coordinate.updateLatitude(5);
                System.out.println(this + ": It's raining. Better watch out for lightnings.");
            }
            case "FOG" -> {
                this.coordinate.updateLatitude(1);
                System.out.println(this + ": We might have to land before we crash, I cannot continue like this.");
            }
            case "SNOW" -> {
                this.coordinate.updateHeight(-7);
                System.out.println(this + ": OMG! Winter is coming!");
            }
        }
        if (this.coordinate.getHeight() == 0) {
            System.out.println(this + ": landing.");
            this.weatherTower.unregister(this);
        }
    }

    @Override
    public String toString() {
        return "JetPlane#" + this.name + "(" + this.id + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof JetPlane)) return false;
        else return super.equals(o);
    }
}
