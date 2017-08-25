package com.shilton.weather.weatherapp.restclient;

import com.shilton.weather.weatherapp.models.DailyForecast;
import com.shilton.weather.weatherapp.models.CurrentForecast;
import com.shilton.weather.weatherapp.models.HourlyForecast;
import com.shilton.weather.weatherapp.models.WeatherForecastSummary;
import feign.Param;
import feign.RequestLine;

public interface WeatherClient {

    String API_KEY = "a3e5e74230a0646be010c776d2c3b119";

    @RequestLine("GET /data/2.5/weather?id={city}&units=metric&appid=" + API_KEY)
    CurrentForecast getCurrentWeatherForecast(@Param("city") String city);

    @RequestLine("GET /data/2.5/group?id={cities}&units=metric&appid=" + API_KEY)
    WeatherForecastSummary getWeatherForecastSummary(@Param("cities") String cities);

    @RequestLine("GET /data/2.5/forecast?id={city}&units=metric&appid=" + API_KEY)
    HourlyForecast getHourlyWeatherForecastCity(@Param("city") String city);

    @RequestLine("GET /data/2.5/forecast/daily?id={city}&units=metric&appid=" + API_KEY)
    DailyForecast getDailyWeatherForecastCity(@Param("city") String city);

}
