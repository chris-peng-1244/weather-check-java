package me.chrispeng.weathercheck.weather.datasource.openweathermap;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import me.chrispeng.weathercheck.weather.entity.TemperatureUnit;
import me.chrispeng.weathercheck.weather.exception.CurrentWeatherNotAvailableException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class CurrentWeatherApi {

    private OpenWeatherMapClient client;

    @Autowired
    public CurrentWeatherApi(OpenWeatherMapClient client) {
        this.client = client;
    }

    JSONObject getCurrentWeatherByCityId(int cityId, TemperatureUnit temperatureUnit) throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get(client.currentWeatherUrl(cityId, temperatureUnit.getName()))
            .asJson();
        if (response.getStatus() == 200) {
            return response.getBody().getObject();
        }
        throw new CurrentWeatherNotAvailableException();
    }
}
