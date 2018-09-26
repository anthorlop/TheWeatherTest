package com.anthorlop.theweathertest.data.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherObservation {

    // TODO remove unnecessary data, for now we keep all in case we want to show more data in detail

    @SerializedName("datetime")
    @Expose
    private String datetime;
    @SerializedName("lng")
    @Expose
    private Double lng;
    @SerializedName("observation")
    @Expose
    private String observation;
    @SerializedName("temperature")
    @Expose
    private String temperature;
    @SerializedName("humidity")
    @Expose
    private Integer humidity;
    @SerializedName("ICAO")
    @Expose
    private String iCAO;
    @SerializedName("stationName")
    @Expose
    private String stationName;
    @SerializedName("weatherCondition")
    @Expose
    private String weatherCondition;
    @SerializedName("clouds")
    @Expose
    private String clouds;
    @SerializedName("dewPoint")
    @Expose
    private String dewPoint;
    @SerializedName("windSpeed")
    @Expose
    private String windSpeed;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("cloudsCode")
    @Expose
    private String cloudsCode;
    @SerializedName("windDirection")
    @Expose
    private Integer windDirection;

    public String getDatetime() {
        return datetime;
    }

    public Double getLng() {
        return lng;
    }

    public String getObservation() {
        return observation;
    }

    public String getTemperature() {
        return temperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public String getiCAO() {
        return iCAO;
    }

    public String getStationName() {
        return stationName;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public String getClouds() {
        return clouds;
    }

    public String getDewPoint() {
        return dewPoint;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public Double getLat() {
        return lat;
    }

    public String getCloudsCode() {
        return cloudsCode;
    }

    public Integer getWindDirection() {
        return windDirection;
    }
}
