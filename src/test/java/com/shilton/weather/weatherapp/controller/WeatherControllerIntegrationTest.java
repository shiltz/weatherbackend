package com.shilton.weather.weatherapp.controller;

import com.shilton.weather.weatherapp.config.StandaloneConfig;
import com.shilton.weather.weatherapp.utility.TestUtility;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@AutoConfigureWireMock(port = 9999)
@ActiveProfiles("dev")
public class WeatherControllerIntegrationTest {

    public static final String COM_SHILTON_WEATHER_WEATHERAPP_RESTCLIENT = "/com/shilton/weather/weatherapp/restclient";
    public static final String INTEGRATION_WEATHER_SUMMARY_CONTROLLER_JSON = "/integration/WeatherSummaryController.json";

    private final TestUtility testUtility = new TestUtility();

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetSummary() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/summary")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();


        String file = testUtility.getString(COM_SHILTON_WEATHER_WEATHERAPP_RESTCLIENT,
                INTEGRATION_WEATHER_SUMMARY_CONTROLLER_JSON,
                WeatherControllerIntegrationTest.class);

        assertEquals(file, (mvcResult.getResponse().getContentAsString()));
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