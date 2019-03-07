package me.chrispeng.weathercheck.weather.datasource;

import me.chrispeng.weathercheck.weather.entity.CurrentWeather;

public interface WeatherService {
    CurrentWeather getCurrentWeatherByCityName(String cityName);
}
