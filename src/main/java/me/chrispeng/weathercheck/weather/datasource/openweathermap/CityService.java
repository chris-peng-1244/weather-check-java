package me.chrispeng.weathercheck.weather.datasource.openweathermap;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("weather-city-service")
interface CityService {

    @GetMapping("/{cityName}")
    int findByCityName(@PathVariable("cityName") String cityName);
}
