package me.chrispeng.weathercheck.weather.view;

import lombok.Getter;
import me.chrispeng.weathercheck.weather.entity.CurrentWeather;

@Getter
public class CurrentWeatherView {
    private int temperature;
    private String tempretureUnit;
    private String description;
    private float windSpeed;
    private String windDegree;
    private int humidity;

    public static CurrentWeatherView fromEntity(CurrentWeather currentWeather) {
        CurrentWeatherView weatherView = new CurrentWeatherView();
        weatherView.description = currentWeather.getDescription();
        weatherView.humidity = currentWeather.getHumidity();
        weatherView.temperature = Math.round(currentWeather.getTemperature().getValue());
        weatherView.tempretureUnit = currentWeather.getTemperature().getTemperatureSymbol();
        weatherView.windDegree = currentWeather.getWind().getDescription();
        weatherView.windSpeed = currentWeather.getWind().getSpeed();
        return weatherView;
    }
}
