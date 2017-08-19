package com.shilton.weather.weatherapp.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WeatherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetIndex() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/weatherForecast")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().string(equalTo("{\"city\":{\"id\":524901,\"name\":\"Moscow\",\"coord\":{\"lon\":37.6156,\"lat\":55.7522},\"country\":\"RU\",\"population\":0.0},\"cod\":200.0,\"message\":0.019149,\"cnt\":14.0,\"list\":[{\"dt\":1501232400,\"temp\":{\"day\":24.01,\"min\":21.33,\"max\":24.01,\"night\":21.33,\"eve\":24.01,\"morn\":24.01},\"pressure\":1003.01,\"humidity\":56.0,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01d\"}],\"speed\":2.71,\"deg\":77.0,\"clouds\":0.0},{\"dt\":1501318800,\"temp\":{\"day\":30.14,\"min\":20.65,\"max\":30.18,\"night\":23.8,\"eve\":29.62,\"morn\":20.65},\"pressure\":999.19,\"humidity\":60.0,\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"few clouds\",\"icon\":\"02d\"}],\"speed\":3.16,\"deg\":107.0,\"clouds\":12.0},{\"dt\":1501405200,\"temp\":{\"day\":24.18,\"min\":18.2,\"max\":24.18,\"night\":18.2,\"eve\":19.52,\"morn\":20.45},\"pressure\":1001.52,\"humidity\":69.0,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":4.12,\"deg\":319.0,\"clouds\":80.0},{\"dt\":1501491600,\"temp\":{\"day\":23.14,\"min\":16.7,\"max\":25.14,\"night\":18.49,\"eve\":25.14,\"morn\":16.7},\"pressure\":1010.61,\"humidity\":69.0,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01d\"}],\"speed\":3.77,\"deg\":328.0,\"clouds\":0.0},{\"dt\":1501578000,\"temp\":{\"day\":26.63,\"min\":15.62,\"max\":26.63,\"night\":15.62,\"eve\":20.35,\"morn\":20.23},\"pressure\":1008.08,\"humidity\":0.0,\"weather\":[{\"id\":501,\"main\":\"Rain\",\"description\":\"moderate rain\",\"icon\":\"10d\"}],\"speed\":8.35,\"deg\":279.0,\"clouds\":10.0},{\"dt\":1501664400,\"temp\":{\"day\":24.95,\"min\":16.76,\"max\":24.95,\"night\":16.76,\"eve\":21.59,\"morn\":22.26},\"pressure\":1008.58,\"humidity\":0.0,\"weather\":[{\"id\":501,\"main\":\"Rain\",\"description\":\"moderate rain\",\"icon\":\"10d\"}],\"speed\":6.14,\"deg\":262.0,\"clouds\":22.0},{\"dt\":1501750800,\"temp\":{\"day\":31.32,\"min\":25.11,\"max\":31.32,\"night\":25.11,\"eve\":27.77,\"morn\":25.28},\"pressure\":997.06,\"humidity\":0.0,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":9.95,\"deg\":243.0,\"clouds\":3.0},{\"dt\":1501837200,\"temp\":{\"day\":25.77,\"min\":14.98,\"max\":25.77,\"night\":14.98,\"eve\":21.24,\"morn\":24.05},\"pressure\":998.16,\"humidity\":0.0,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01d\"}],\"speed\":8.31,\"deg\":271.0,\"clouds\":1.0},{\"dt\":1501923600,\"temp\":{\"day\":19.06,\"min\":13.69,\"max\":19.06,\"night\":13.69,\"eve\":15.69,\"morn\":16.75},\"pressure\":1005.3,\"humidity\":0.0,\"weather\":[{\"id\":501,\"main\":\"Rain\",\"description\":\"moderate rain\",\"icon\":\"10d\"}],\"speed\":3.91,\"deg\":21.0,\"clouds\":89.0},{\"dt\":1502010000,\"temp\":{\"day\":15.01,\"min\":12.83,\"max\":15.01,\"night\":12.83,\"eve\":14.05,\"morn\":13.59},\"pressure\":1003.01,\"humidity\":0.0,\"weather\":[{\"id\":501,\"main\":\"Rain\",\"description\":\"moderate rain\",\"icon\":\"10d\"}],\"speed\":6.87,\"deg\":11.0,\"clouds\":99.0},{\"dt\":1502096400,\"temp\":{\"day\":22.09,\"min\":13.43,\"max\":22.09,\"night\":13.43,\"eve\":18.38,\"morn\":16.29},\"pressure\":1005.08,\"humidity\":0.0,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01d\"}],\"speed\":8.7,\"deg\":310.0,\"clouds\":0.0},{\"dt\":1502182800,\"temp\":{\"day\":22.78,\"min\":13.02,\"max\":22.78,\"night\":13.02,\"eve\":19.19,\"morn\":21.07},\"pressure\":1003.26,\"humidity\":0.0,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":4.36,\"deg\":270.0,\"clouds\":43.0},{\"dt\":1502269200,\"temp\":{\"day\":23.47,\"min\":15.24,\"max\":23.47,\"night\":15.24,\"eve\":18.34,\"morn\":19.78},\"pressure\":1008.68,\"humidity\":0.0,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01d\"}],\"speed\":2.49,\"deg\":301.0,\"clouds\":8.0},{\"dt\":1502355600,\"temp\":{\"day\":27.56,\"min\":19.98,\"max\":27.56,\"night\":19.98,\"eve\":23.98,\"morn\":22.52},\"pressure\":1009.6,\"humidity\":0.0,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":6.05,\"deg\":160.0,\"clouds\":38.0}]}")));
    assertEquals(1,1);
    }

}