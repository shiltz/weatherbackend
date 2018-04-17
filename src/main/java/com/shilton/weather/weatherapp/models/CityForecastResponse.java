package com.shilton.weather.weatherapp.models;

import java.io.Serializable;

public class CityForecastResponse implements Serializable{

    public static final long serialVersionUID = 1L;

    private HourlyForecast hourly;

    private DailyForecast forecast;

    public HourlyForecast getHourly() {
        return hourly;
    }

    public DailyForecast getForecast() {
        return forecast;
    }

    public void setHourly(HourlyForecast hourly) {
        this.hourly = hourly;
    }

    public void setForecast(DailyForecast forecast) {
        this.forecast = forecast;
    }
}
