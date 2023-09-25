package com.school42.malaga.avaj.tower;

import com.school42.malaga.avaj.Coordinates;
import com.school42.malaga.avaj.WeatherProvider;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates p_coordinates) {
        return WeatherProvider.getInstance().getCurrentWeather(p_coordinates);
    }

    public void changeWeather() {
        super.conditionChanged();
    }
}
