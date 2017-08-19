package com.shilton.weather.weatherapp.models;

import java.util.List;

public class CurrentForecast {

    private Coord coord;

    private String base;

    private double dt;

    private double id;

    private String name;

    private double visibility;

    private Main main;

    private List<Weather> weather;

    private Cloud clouds;

    private Wind wind;

    public Coord getCoord() {
        return coord;
    }

    public String getBase() {
        return base;
    }

    public double getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getVisibility() {
        return visibility;
    }

    public double getDt() {
        return dt;
    }

    public Main getMain() {
        return main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public Cloud getClouds() {
        return clouds;
    }

    public Wind getWind() {
        return wind;
    }
}
