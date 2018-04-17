package com.shilton.weather.weatherapp.models;

import java.io.Serializable;

public class Temp implements Serializable{

    public static final long serialVersionUID = 1L;

    private double day;

    private double min;

    private double max;

    private double night;

    private double eve;

    private double morn;

    public double getDay() {
        return day;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public double getNight() {
        return night;
    }

    public double getEve() {
        return eve;
    }

    public double getMorn() {
        return morn;
    }

    @Override
    public String toString() {
        return "Temp{" +
                "day=" + day +
                ", min=" + min +
                ", max=" + max +
                ", night=" + night +
                ", eve=" + eve +
                ", morn=" + morn +
                '}';
    }
}
