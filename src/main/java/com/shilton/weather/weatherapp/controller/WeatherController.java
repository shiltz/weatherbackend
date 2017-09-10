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
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin
public class WeatherController {

    private static final String HTTP_API_OPENWEATHERMAP_ORG = "http://api.openweathermap.org/";


    @RequestMapping("/current/{city}")
    public CurrentForecast getCurrentWeatherForecast(@PathVariable("city") String city) {
        city = city.toLowerCase();

        WeatherClient weatherClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(WeatherClient.class, HTTP_API_OPENWEATHERMAP_ORG);
        CurrentForecast weatherForecast = weatherClient.getCurrentWeatherForecast(CityCodeFinder.getCityCode(city));
        return weatherForecast;
    }

    @RequestMapping("/summary")
    public WeatherForecastSummary getWeatherSummary() {
        String cityCodes = CityCodeFinder.getCityCode("durban") + "," +
                CityCodeFinder.getCityCode("johannesburg") + "," +
                CityCodeFinder.getCityCode("cape town");

        WeatherClient weatherClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(WeatherClient.class, "http://api.openweathermap.org/");
        WeatherForecastSummary weatherForecast = weatherClient.getWeatherForecastSummary(cityCodes.substring(0, cityCodes.length()));
        return weatherForecast;
    }

    @RequestMapping("/forecast/{city}")
    public CityForecastResponse getWeatherForecastCity(@PathVariable("city") String city) {
        city = city.toLowerCase();

        WeatherClient weatherClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(WeatherClient.class, "http://api.openweathermap.org/");
        HourlyForecast weatherForecast = weatherClient.getHourlyWeatherForecastCity(CityCodeFinder.getCityCode(city));
        LocalDateTime nextDay = LocalDate.now().plusDays(1).atStartOfDay();
        weatherForecast.getList().removeIf(e ->
                new Date((long) (e.getDt() * 1000)).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
                        .isAfter(nextDay));

        DailyForecast dailyForecast = weatherClient.getDailyWeatherForecastCity(CityCodeFinder.getCityCode(city));

        CityForecastResponse cityForecastResponse = new CityForecastResponse();

        cityForecastResponse.setForecast(dailyForecast);
        cityForecastResponse.setHourly(weatherForecast);

        return cityForecastResponse;
    }

    @RequestMapping("/meta/map/{cityname}")
    public String getCityId(@PathVariable("cityname") String city) {
        Objects.requireNonNull(city);
        city = city.toLowerCase();
        return CityCodeFinder.getCityCode(city).toString();
    }

    @RequestMapping("/meta/map")
    public Map<String, String> getMap() {
        return CityCodeFinder.getCityCodeMap();
    }


    @RequestMapping("/ping")
    public String getPing() {
        return "Hello";
    }

}
