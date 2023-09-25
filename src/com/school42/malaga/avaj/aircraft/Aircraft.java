package com.school42.malaga.avaj.aircraft;

import com.school42.malaga.avaj.Coordinates;

public class Aircraft extends Flyable {
    protected long id;
    protected String name;
    protected Coordinates coordinate;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinate) {
        this.id = p_id;
        this.name = p_name;
        this.coordinate = p_coordinate;

    }

    @Override
    public void updateConditions() { }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Aircraft)) return false;
        else {
            Aircraft aircraft = (Aircraft) o;
            return this.id == aircraft.id;
        }
    }

    @Override
    public int hashCode() {
        return Long.hashCode(this.id);
    }
}
