package com.shilton.weather.weatherapp.models;

import java.io.Serializable;

public class Wind implements Serializable{

    public static final long serialVersionUID = 1L;

    private double speed;

    private double deg;

    public double getSpeed() {
        return speed;
    }

    public double getDeg() {
        return deg;
    }
}
