package com.shilton.weather.weatherapp.utility;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitPlatform.class)
public class CityListReaderTest {


    @Test
    @DisplayName("what the fuck man!!!")
    public void getCityList() throws Exception {
        assertEquals(555, CityListReader.getCityList().size());
    }

}