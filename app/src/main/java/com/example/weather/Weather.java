package com.example.weather;

import java.io.Serializable;

public class Weather implements Serializable {
    private String cityName;
    private String weatherDescription;
    private Float lat;
    private Float lon;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

//    public String getTemprature() {
//        return temprature;
//    }
//
//    public void setTemprature(String temprature) {
//        this.temprature = temprature;
//    }
}
