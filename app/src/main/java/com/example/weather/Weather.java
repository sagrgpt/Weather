package com.example.weather;

import java.io.Serializable;
import java.util.Locale;

public class Weather implements Serializable {

    private Float lat;
    private Float lon;
    private String cityName;
    private String weatherCondition;
    private String conditionDescription;
    private String iconNo;
    private Double temp;
    private Float pressure;
    private Float tempMax;
    private Float tempMin;
    private Float humidity;
    private Float seaLevel;
    private Float groundLevel;
    private Float windSpeed;
    private String country;
    private Float sunrise;
    private Float sunset;

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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public String getConditionDescription() {
        return conditionDescription;
    }

    public void setConditionDescription(String conditionDescription) {
        this.conditionDescription = conditionDescription;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        double c = temp - 273.15;
        String tempr = String.format(Locale.ENGLISH,"%.2f",c);
        temp = Double.valueOf(tempr);
        this.temp = temp;
    }

    public Float getTempMax() {
        return tempMax;
    }

    public void setTempMax(Float tempMax) {
        this.tempMax = tempMax;
    }

    public Float getTempMin() {
        return tempMin;
    }

    public void setTempMin(Float tempMin) {
        this.tempMin = tempMin;
    }

    public Float getHumidity() {
        return humidity;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
    }

    public Float getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(Float seaLevel) {
        this.seaLevel = seaLevel;
    }

    public Float getGroundLevel() {
        return groundLevel;
    }

    public void setGroundLevel(Float groundLevel) {
        this.groundLevel = groundLevel;
    }

    public Float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Float getSunrise() {
        return sunrise;
    }

    public void setSunrise(Float sunrise) {
        this.sunrise = sunrise;
    }

    public Float getSunset() {
        return sunset;
    }

    public void setSunset(Float sunset) {
        this.sunset = sunset;
    }

    public Float getPressure() {
        return pressure;
    }

    public void setPressure(Float pressure) {
        this.pressure = pressure;
    }

    public String getIconNo() {
        return iconNo;
    }

    public void setIconNo(String iconNo) {
        this.iconNo = iconNo;
    }
}
