package com.shilton.weather.weatherapp.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class TestingUtilities {

    public static String readFile(String fullFilename) {
        InputStream inputStream = TestingUtilities.class.getResourceAsStream(fullFilename);
        return new BufferedReader(new InputStreamReader(inputStream))
                .lines()
                .collect(Collectors.joining("\n"));
    }
}
