package com.shilton.weather.weatherapp.utility;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shilton.weather.weatherapp.models.City;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class CityListReader {

    private final static String filename = "/city.list.json";



    private CityListReader() {
    }


    public static final List<City> getCityList() throws IOException {
        String cityList = readFile(filename);
        List<City> cities = new ObjectMapper().readValue(cityList, new TypeReference<List<City>>(){});
        return cities;
    }

    private static String readFile(String fullFilename) {
        InputStream inputStream = CityListReader.class.getResourceAsStream(fullFilename);
        return new BufferedReader(new InputStreamReader(inputStream))
                .lines()
                .collect(Collectors.joining("\n"));
    }
}
