package com.shilton.weather.weatherapp.models;

import java.util.List;

public class DayForecast {

    private long dt;

    private Temp temp;

    private double pressure;

    private double humidity;

    private List<Weather> weather;

    private double speed;

    private double deg;

    private double clouds;

    public long getDt() {
        return dt;
    }

    public Temp getTemp() {
        return temp;
    }

    public double getPressure() {
        return pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDeg() {
        return deg;
    }

    public double getClouds() {
        return clouds;
    }

    @Override
    public String toString() {
        return "DayForecast{" +
                "dt=" + dt +
                ", temp=" + temp +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", weather=" + weather +
                ", speed=" + speed +
                ", deg=" + deg +
                ", clouds=" + clouds +
                '}';
    }
}
