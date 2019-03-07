package me.chrispeng.weathercheck.weather.datasource.openweathermap;

import me.chrispeng.weathercheck.weather.datasource.WeatherService;
import me.chrispeng.weathercheck.weather.entity.CurrentWeather;
import me.chrispeng.weathercheck.weather.exception.CityNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
class OpenWeatherMapImpl implements WeatherService {

    private CityService cityService;

    public OpenWeatherMapImpl(CityService cityService) {
        this.cityService = cityService;
    }

    @Override
    public CurrentWeather getCurrentWeatherByCityName(String cityName) {
        int cityId = cityService.getCityId(cityName);
        if (cityId == 0) {
            throw new CityNotFoundException();
        }


        return null;
    }
}
