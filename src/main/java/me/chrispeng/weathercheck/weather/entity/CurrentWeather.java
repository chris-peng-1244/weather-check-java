package me.chrispeng.weathercheck.weather.entity;

import lombok.Getter;

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
    private LocalTime sunrise;
    /**
     * 日落时间
     */
    private LocalTime sunset;
    /**
     * 经纬度
     */
    private GeoCoords geoCoords;
}
