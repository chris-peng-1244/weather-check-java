package me.chrispeng.weathercheck.weather.datasource.openweathermap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
class OpenWeatherMapClient {
    @Value("${open.weather.map.url}")
    private String baseUrl;

    @Value("${open.weather.map.api-key}")
    private String apiKey;

    private String getUrlWithApiKey(String url) {
        return url + "&appid=" + apiKey;
    }

    String currentWeatherUrl(int cityId, String unit) {
        return getUrlWithApiKey(baseUrl + "/weather?id=" + cityId + "&units=" + unit);
    }
}
