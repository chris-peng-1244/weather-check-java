package me.chrispeng.weathercheck.weather.entity;

import lombok.Getter;

@Getter
public class Wind {
    /**
     * Wind speed
     */
    private float speed;

    /**
     * The angle of the wind
     */
    private int degree;

    public String getDescription() {
        if (degree <= 5 || degree > 355) {
            return "North";
        } else if (degree <= 85) {
            return "Northeast";
        } else if (degree <= 95) {
            return "East";
        } else if (degree <= 175) {
            return "South east";
        } else if (degree <= 185) {
            return "South";
        } else if (degree <= 265) {
            return "Southwest";
        } else if (degree <= 275) {
            return "West";
        } else {
            return "Northwest";
        }
    }

    private Wind(float speed, int degree) {
        this.speed = speed;
        this.degree = degree;
    }

    public static Wind create(float speed, int degree) {
        return new Wind(speed, degree);
    }
}
