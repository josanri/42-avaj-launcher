package com.school42.malaga.avaj;

public class WeatherProvider {
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
    private static WeatherProvider singleton;

    private WeatherProvider() {

    }

    public static WeatherProvider getInstance() {
        if (WeatherProvider.singleton == null) WeatherProvider.singleton = new WeatherProvider();
        return WeatherProvider.singleton;
    }

    public String getCurrentWeather(Coordinates p_coordinate) {
        int index = Math.abs(p_coordinate.getHeight() + p_coordinate.getLatitude() + p_coordinate.getLongitude()) % 4;
        return this.weather[index];
    }
}
