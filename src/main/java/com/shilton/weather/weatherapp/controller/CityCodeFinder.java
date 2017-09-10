package com.shilton.weather.weatherapp.controller;

import com.shilton.weather.weatherapp.exception.CityNotFoundException;
import com.shilton.weather.weatherapp.models.City;
import com.shilton.weather.weatherapp.utility.CityListReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityCodeFinder {

    private static Map<String, String> cityCodeMap = new HashMap<String, String>();

    static {
        List<City> cityList;
        try {
            cityList = CityListReader.getCityList();
        } catch (IOException e) {
            throw new RuntimeException("Can not read city list file");
        }
        cityList.forEach(city -> {
            CityCodeFinder.cityCodeMap.put(city.getName().toLowerCase(), String.valueOf(city.getId()));
        });
    }

    private CityCodeFinder() {

    }

    public static String getCityCode(String cityname) {
        String cityCode = cityCodeMap.getOrDefault(cityname, "");
        if (cityCode.equalsIgnoreCase("")) {
            throw new CityNotFoundException();
        }
        return cityCode;
    }

    public static Map<String, String> getCityCodeMap() {
        return cityCodeMap;
    }
}