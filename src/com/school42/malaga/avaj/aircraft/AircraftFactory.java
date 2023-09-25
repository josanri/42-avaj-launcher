package com.school42.malaga.avaj.aircraft;

import com.school42.malaga.avaj.Coordinates;

public class AircraftFactory {
    private static AircraftFactory singleton;
    private long maxId;

    private AircraftFactory() {
        this.maxId = 1;
    }

    public static AircraftFactory getInstance() {
        if (AircraftFactory.singleton == null) {
            AircraftFactory.singleton = new AircraftFactory();
        }
        return AircraftFactory.singleton;
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinate) {
        if ("helicopter".equalsIgnoreCase(p_type))
            return new Helicopter(this.maxId++, p_name, p_coordinate);
        else if ("jetplane".equalsIgnoreCase(p_type))
            return new JetPlane(this.maxId++, p_name, p_coordinate);
        else if ("baloon".equalsIgnoreCase(p_type))
            return new Baloon(this.maxId++, p_name, p_coordinate);
        else
            throw new IllegalArgumentException(p_type + " is not an allowed aircraft type");
    }
}
