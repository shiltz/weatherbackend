package com.shilton.weather.weatherapp.models;

import java.io.Serializable;
import java.util.List;

public class WeatherForecastSummary implements Serializable{

    public static final long serialVersionUID = 1L;

    private double cnt;

    private List<WeatherForecastCity> list;

    public double getCnt() {
        return cnt;
    }

    public List<WeatherForecastCity> getList() {
        return list;
    }
}
