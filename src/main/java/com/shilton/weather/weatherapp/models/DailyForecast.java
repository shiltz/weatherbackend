package com.shilton.weather.weatherapp.models;

import java.util.List;

public class DailyForecast {

    private double cod;

    private String message;

    private double cnt;

    private List<DayForecast> list;

    private City city;

    public double getCod() {
        return cod;
    }

    public String getMessage() {
        return message;
    }

    public double getCnt() {
        return cnt;
    }

    public List<DayForecast> getList() {
        return list;
    }

    public City getCity() {
        return city;
    }
}
