package com.school42.malaga.avaj;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height) {
        if (longitude < 0)
            throw new IllegalArgumentException("longitude cannot be a negative number");
        if (latitude < 0)
            throw new IllegalArgumentException("latitude cannot be a negative number");
        if (height <= 0)
            throw new IllegalArgumentException("height cannot be a negative number or zero as a starting value");
        if (height > 100)
            throw new IllegalArgumentException("height cannot be a higher than 100.");
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getHeight() {
        return height;
    }

    public int getLatitude() {
        return latitude;
    }

    public void updateLatitude(int value) {
        if (this.latitude + value < 0) this.latitude = 0;
        else this.latitude += value;
    }

    public void updateLongitude(int value) {
        if (this.longitude + value < 0) this.longitude = 0;
        else this.longitude += value;
    }

    public void updateHeight(int value) {
        if (this.height + value < 0) this.height = 0;
        else this.height = Math.min(this.height + value, 100);
    }

    @Override
    public String toString() {
        return "Coordinates(" + longitude + ", " + latitude + ", " + height + ')';
    }

}
