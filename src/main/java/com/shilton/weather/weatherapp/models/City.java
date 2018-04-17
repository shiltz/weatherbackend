package com.shilton.weather.weatherapp.models;

import java.io.Serializable;

public class City implements Serializable{

    public static final long serialVersionUID = 1L;

    private int id;

    private String name;

    private Coord coord;

    private String country;

    private double population;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coord getCoord() {
        return coord;
    }

    public String getCountry() {
        return country;
    }

    public double getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coord=" + coord +
                ", country='" + country + '\'' +
                ", population=" + population +
                '}';
    }
}
