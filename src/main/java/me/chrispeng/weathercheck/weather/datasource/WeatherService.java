package me.chrispeng.weathercheck.weather.datasource;

import me.chrispeng.weathercheck.weather.entity.CurrentWeather;
import me.chrispeng.weathercheck.weather.entity.TemperatureUnit;

public interface WeatherService {
    CurrentWeather getCurrentWeatherByCityName(String cityName, TemperatureUnit unit);
}
