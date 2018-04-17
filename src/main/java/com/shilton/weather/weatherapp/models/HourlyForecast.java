package com.shilton.weather.weatherapp.models;

import java.io.Serializable;
import java.util.List;

public class HourlyForecast implements Serializable{

    public static final long serialVersionUID = 1L;

    private double cod;

    private String message;

    private double cnt;

    private List<CurrentForecast> list;

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

    public List<CurrentForecast> getList() {
        return list;
    }

    public City getCity() {
        return city;
    }
}
