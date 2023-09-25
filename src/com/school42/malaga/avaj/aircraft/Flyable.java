package com.school42.malaga.avaj.aircraft;

import com.school42.malaga.avaj.tower.WeatherTower;

public abstract class Flyable {
    WeatherTower weatherTower;

    public abstract void updateConditions();

    public void registerTower(WeatherTower p_tower) {
        this.weatherTower = p_tower;
        this.weatherTower.register(this);
    }
}
