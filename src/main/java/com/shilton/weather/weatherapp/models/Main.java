package com.shilton.weather.weatherapp.models;

import java.io.Serializable;

public class Main implements Serializable{

    public static final long serialVersionUID = 1L;

    private double temp;

    private double pressure;

    private double humdity;

    private double temp_min;

    private double temp_max;

    public double getTemp() {
        return temp;
    }

    public double getPressure() {
        return pressure;
    }

    public double getHumdity() {
        return humdity;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }
}
