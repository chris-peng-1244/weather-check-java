package me.chrispeng.weathercheck.weather.datasource.openweathermap;

import com.mashape.unirest.http.exceptions.UnirestException;
import me.chrispeng.weathercheck.weather.datasource.WeatherService;
import me.chrispeng.weathercheck.weather.entity.*;
import me.chrispeng.weathercheck.weather.exception.CityNotFoundException;
import me.chrispeng.weathercheck.weather.exception.CurrentWeatherNotAvailableException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
class OpenWeatherMapImpl implements WeatherService {

    private Logger logger = LoggerFactory.getLogger(OpenWeatherMapImpl.class);

    private CityService cityService;
    private CurrentWeatherApi currentWeatherApi;

    public OpenWeatherMapImpl(CityService cityService, CurrentWeatherApi currentWeatherApi) {
        this.cityService = cityService;
        this.currentWeatherApi = currentWeatherApi;
    }

    @Override
    public CurrentWeather getCurrentWeatherByCityName(String cityName, TemperatureUnit temperatureUnit) {
        int cityId = cityService.findByCityName(cityName);
        if (cityId == 0) {
            throw new CityNotFoundException();
        }

        try {
            JSONObject jsonObject = currentWeatherApi.getCurrentWeatherByCityId(cityId, temperatureUnit);
            JSONObject mainData = jsonObject.getJSONObject("main");
            JSONObject wind = jsonObject.getJSONObject("wind");
            JSONObject sys = jsonObject.getJSONObject("sys");
            JSONObject coord = jsonObject.getJSONObject("coord");
            JSONObject weather = (JSONObject) jsonObject.getJSONArray("weather").get(0);
            return CurrentWeather.create(
                weather.getString("description"),
                Temperature.ofUnit((float) mainData.getDouble("temp"), temperatureUnit),
                Wind.create((float) wind.getDouble("speed"), wind.getInt("deg")),
                (float) mainData.getDouble("pressure"),
                mainData.getInt("humidity"),
                Instant.ofEpochSecond(sys.getInt("sunrise")),
                Instant.ofEpochSecond(sys.getInt("sunset")),
                GeoCoords.create((float) coord.getDouble("lon"), (float) coord.getDouble("lat"))
            );
        } catch (UnirestException e) {
            logger.warn("Exception when fetching weather data: {}", e.getMessage());
            e.printStackTrace();
            throw new CurrentWeatherNotAvailableException();
        }
    }
}
