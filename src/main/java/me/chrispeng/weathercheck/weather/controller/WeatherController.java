package me.chrispeng.weathercheck.weather.controller;

import me.chrispeng.weathercheck.weather.datasource.WeatherService;
import me.chrispeng.weathercheck.weather.entity.CurrentWeather;
import me.chrispeng.weathercheck.weather.entity.TemperatureUnit;
import me.chrispeng.weathercheck.weather.view.CurrentWeatherView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public CurrentWeatherView getCurrentWeather(@NotBlank @PathVariable String cityName,
                                                @RequestParam String unitString) {
        TemperatureUnit unit = TemperatureUnit.from(unitString);
        CurrentWeather currentWeather = weatherService.getCurrentWeatherByCityName(cityName, unit);
        return CurrentWeatherView.fromEntity(currentWeather);
    }
}
