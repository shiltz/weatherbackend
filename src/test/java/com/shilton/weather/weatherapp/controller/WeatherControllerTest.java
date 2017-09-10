package com.shilton.weather.weatherapp.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@ExtendWith({
//        SpringExtension.class,
//        WiremockResolver.class,
//        WiremockUriResolver.class
//})
public class WeatherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetSummary() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/summary")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetforecast() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/forecast/Durban")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetCurrentWeatherForecast() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/current/Durban")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetCurrentWeatherForecastForCityNotExisting() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/current/HeHa")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }


}