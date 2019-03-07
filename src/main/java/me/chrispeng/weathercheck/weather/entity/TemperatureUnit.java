package me.chrispeng.weathercheck.weather.entity;

public enum TemperatureUnit {
    CELSIUS("metric", "°C"),
    FAHRENHEIT("imperial", "°F");

    private String name;
    private String symbol;

    TemperatureUnit(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }
}
