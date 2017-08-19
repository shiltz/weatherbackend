package com.shilton.weather.weatherapp.models;

public class Sys {

    private double type;

    private double id;

    private String message;

    private String country;

    private double sunrise;

    private double sunset;

    public double getType() {
        return type;
    }

    public double getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getCountry() {
        return country;
    }

    public double getSunrise() {
        return sunrise;
    }

    public double getSunset() {
        return sunset;
    }
}
