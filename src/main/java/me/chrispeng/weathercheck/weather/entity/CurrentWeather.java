package me.chrispeng.weathercheck.weather.entity;

import lombok.Getter;

import java.time.Instant;
import java.time.LocalTime;

@Getter
public class CurrentWeather {

    /**
     * 天气简述
     */
    private String description;
    /**
     * 温度
     */
    private Temperature temperature;
    /**
     * 风向和风速
     */
    private Wind wind;
    /**
     * 气压
     */
    private float pressure;
    /**
     * 空气湿度
     */
    private int humidity;
    /**
     * 日出时间
     */
    private Instant sunrise;
    /**
     * 日落时间
     */
    private Instant sunset;
    /**
     * 经纬度
     */
    private GeoCoords geoCoords;

    public static CurrentWeather create(String description, Temperature temperature, Wind wind, float pressure,
                                    int humidity, Instant sunrise, Instant sunset, GeoCoords geoCoords) {
        CurrentWeather currentWeather = new CurrentWeather();
        currentWeather.description = description;
        currentWeather.temperature = temperature;
        currentWeather.wind = wind;
        currentWeather.pressure = pressure;
        currentWeather.humidity = humidity;
        currentWeather.sunrise = sunrise;
        currentWeather.sunset = sunset;
        currentWeather.geoCoords = geoCoords;
        return currentWeather;
    }
}
