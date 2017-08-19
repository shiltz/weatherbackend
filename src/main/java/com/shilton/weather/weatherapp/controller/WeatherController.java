package com.shilton.weather.weatherapp.controller;


import com.shilton.weather.weatherapp.models.*;
import com.shilton.weather.weatherapp.restclient.WeatherClient;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class WeatherController {

    private static final String HTTP_API_OPENWEATHERMAP_ORG = "http://api.openweathermap.org/";

    private static Map<String, String> cityCodeMap = new HashMap<>();

    static {
        cityCodeMap.put("Johannesburg", "993800");
        cityCodeMap.put("Cape Town", "3369157");
        cityCodeMap.put("Durban", "1007311");
    }


    @RequestMapping("/current/{city}")
    public CurrentForecast getCurrentWeatherForecast(@PathVariable("city") String city) {
        WeatherClient weatherClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(WeatherClient.class, HTTP_API_OPENWEATHERMAP_ORG);
        CurrentForecast weatherForecast = weatherClient.getCurrentWeatherForecast(cityCodeMap.get(city));
        return weatherForecast;
    }

    @RequestMapping("/summary")
    public WeatherForecastSummary getWeatherSummary() {
        String cityCodes = cityCodeMap.values()
                .stream()
                .reduce("", (arg1, arg2) -> arg1 + arg2 + ",");

        WeatherClient weatherClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(WeatherClient.class, "http://api.openweathermap.org/");
        WeatherForecastSummary weatherForecast = weatherClient.getWeatherForecastSummary(cityCodes.substring(0,cityCodes.length()-1));
        return weatherForecast;
    }

    @RequestMapping("/forecast/{city}")
    public CityForecastResponse getWeatherForecastCity(@PathVariable("city") String city) {

        WeatherClient weatherClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(WeatherClient.class, "http://api.openweathermap.org/");
        HourlyForecast weatherForecast = weatherClient.getHourlyWeatherForecastCity(cityCodeMap.get(city));
        LocalDateTime nextDay = LocalDate.now().plusDays(1).atStartOfDay();
        weatherForecast.getList().removeIf(e ->
                new Date((long)(e.getDt()*1000)).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
                 .isAfter(nextDay));

        DailyForecast dailyForecast = weatherClient.getDailyWeatherForecastCity(cityCodeMap.get(city));

        CityForecastResponse cityForecastResponse = new CityForecastResponse();

        cityForecastResponse.setForecast(dailyForecast);
        cityForecastResponse.setHourly(weatherForecast);

        return cityForecastResponse;
    }
}
