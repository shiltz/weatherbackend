package com.shilton.weather.weatherapp.utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class TestUtility {
    public TestUtility() {
    }

    public String getString(final String path, String filename, Class<?> clazz) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                clazz.getResourceAsStream(path + filename)));
        return bufferedReader.lines().collect(Collectors.joining());
    }
}