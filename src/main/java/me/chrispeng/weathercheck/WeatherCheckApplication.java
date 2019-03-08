package me.chrispeng.weathercheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WeatherCheckApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherCheckApplication.class, args);
    }

}
