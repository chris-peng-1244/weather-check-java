package me.chrispeng.weathercheck.weather.entity;

import lombok.Getter;

public final class Temperature {

    private float value;
    private TemperatureUnit unit;

    public Temperature(float value, TemperatureUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public float getValue() {
        return value;
    }

    public String getTemperatureUnit() {
        return unit.getName();
    }

    public String getTemperatureSymbol() {
        return unit.getSymbol();
    }
}
