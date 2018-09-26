package com.anthorlop.theweathertest.data.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherResult {

    @SerializedName("weatherObservations")
    @Expose
    private List<WeatherObservation> weatherObservations = null;

    public List<WeatherObservation> getWeatherObservations() {
        return weatherObservations;
    }

    public void setWeatherObservations(List<WeatherObservation> weatherObservations) {
        this.weatherObservations = weatherObservations;
    }

}
