package com.shilton.weather.weatherapp.models;

import java.io.Serializable;

public class Cloud implements Serializable{

    public static final long serialVersionUID = 1L;

    private double all;

    public double getAll() {
        return all;
    }

    public void setAll(double all) {
        this.all = all;
    }
}
