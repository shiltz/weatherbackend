package com.shilton.weather.weatherapp.models;

import java.io.Serializable;

public class Coord implements Serializable{

    public static final long serialVersionUID = 1L;

    private double lon;

    private double lat;

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }

    @Override
    public String toString() {
        return "Coord{" +
                "lon=" + lon +
                ", lat=" + lat +
                '}';
    }
}

