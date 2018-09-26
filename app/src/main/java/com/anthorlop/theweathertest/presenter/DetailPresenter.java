package com.anthorlop.theweathertest.presenter;

import android.support.annotation.NonNull;

import com.anthorlop.theweathertest.data.ApiUtils;
import com.anthorlop.theweathertest.data.weather.WeatherObservation;
import com.anthorlop.theweathertest.data.weather.WeatherResult;
import com.anthorlop.theweathertest.dataview.CityView;
import com.anthorlop.theweathertest.interfaces.IDetailPresenter;
import com.anthorlop.theweathertest.interfaces.IDetailView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPresenter implements IDetailPresenter {

    private final IDetailView mView;

    public DetailPresenter(IDetailView mView) {
        this.mView = mView;
    }

    @Override
    public void loadWeather(CityView cityView) {

        Call<WeatherResult> call = ApiUtils.getGeoNameService().getWeather(
                cityView.getNorth(),
                cityView.getSouth(),
                cityView.getEast(),
                cityView.getWest());

        call.enqueue(new Callback<WeatherResult>() {
            @Override
            public void onResponse(@NonNull Call<WeatherResult> call, @NonNull Response<WeatherResult> response) {

                if (response.isSuccessful()) {
                    WeatherResult result = response.body();

                    if (result != null && result.getWeatherObservations() != null) {
                        double temperature = 0;
                        int num = 0;
                        for (WeatherObservation wo : result.getWeatherObservations()) {
                            String temp = wo.getTemperature();
                            temperature += Double.valueOf(temp);
                            num++;
                        }
                        temperature = temperature/num;

                        mView.loadTemperature(String.valueOf(temperature));
                    }
                }

            }

            @Override
            public void onFailure(@NonNull Call<WeatherResult> call, @NonNull Throwable t) {
                mView.loadTemperature("-");
            }
        });
    }
}
