package com.shilton.weather.weatherapp.models;

import java.io.Serializable;
import java.util.List;

public class WeatherForecastCity implements Serializable{

    public static final long serialVersionUID = 1L;

    private String name;

    private double id;

    private double dt;

    private Coord coord;

    private Sys sys;

    private List<Weather> weather;

    private Main main;

    private Wind wind;

    public String getName() {
        return name;
    }

    public double getId() {
        return id;
    }

    public double getDt() {
        return dt;
    }

    public Coord getCoord() {
        return coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public Main getMain() {
        return main;
    }

    public Wind getWind() {
        return wind;
    }

    public Sys getSys() {
        return sys;
    }
}
