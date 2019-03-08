package me.chrispeng.weathercheck.weather.entity;

import lombok.Getter;

public final class Temperature {

    private float value;
    private TemperatureUnit unit;

    private Temperature(float value, TemperatureUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public static Temperature inCelsius(float value) {
        return new Temperature(value, TemperatureUnit.CELSIUS);
    }

    public static Temperature inFahrenheit(float value) {
        return new Temperature(value, TemperatureUnit.FAHRENHEIT);
    }

    public static Temperature ofUnit(float value, TemperatureUnit unit) {
        return new Temperature(value, unit);
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
