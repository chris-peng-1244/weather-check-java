package me.chrispeng.weathercheck.weather.entity;

import lombok.Getter;

@Getter
public class GeoCoords {
    /**
     * 纬度
     */
    private float latitude;
    /**
     * 经度
     */
    private float longitude;

    private GeoCoords(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static GeoCoords create(float latitude, float longitude) {
        return new GeoCoords(latitude, longitude);
    }
}
