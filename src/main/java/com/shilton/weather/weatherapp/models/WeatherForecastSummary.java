package com.shilton.weather.weatherapp.models;

import java.util.List;

public class WeatherForecastSummary {

    private double cnt;

    private List<WeatherForecastCity> list;

    public double getCnt() {
        return cnt;
    }

    public List<WeatherForecastCity> getList() {
        return list;
    }
}
