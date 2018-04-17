package com.shilton.weather.weatherapp.models;

import java.io.Serializable;

public class Weather implements Serializable{

    public static final long serialVersionUID = 1L;

    private int id;

    private String main;

    private String description;

    private String icon;

    public int getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", main='" + main + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
