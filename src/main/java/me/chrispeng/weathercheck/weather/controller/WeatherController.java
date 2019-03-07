package me.chrispeng.weathercheck.weather.controller;

import me.chrispeng.weathercheck.weather.datasource.WeatherService;
import me.chrispeng.weathercheck.weather.entity.CurrentWeather;
import me.chrispeng.weathercheck.weather.view.CurrentWeatherView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/weather")
@Validated
public class WeatherController {

    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @RequestMapping("current/{cityName}")
    public CurrentWeatherView getCurrentWeather(@NotBlank @PathVariable String cityName) {
        CurrentWeather currentWeather = weatherService.getCurrentWeatherByCityName(cityName);
        return CurrentWeatherView.fromEntity(currentWeather);
    }
}
