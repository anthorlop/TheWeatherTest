package com.anthorlop.theweathertest.presenter;

import android.support.annotation.NonNull;

import com.anthorlop.theweathertest.data.ApiUtils;
import com.anthorlop.theweathertest.data.GeoNamesResult;
import com.anthorlop.theweathertest.data.Geoname;
import com.anthorlop.theweathertest.dataview.CityView;
import com.anthorlop.theweathertest.interfaces.IMainView;
import com.anthorlop.theweathertest.interfaces.IMainPresenter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements IMainPresenter {

    private static final int MAX_PAGES = 20;
    private static final String DEFAULT_LANG = "en";

    private IMainView mView;

    public MainPresenter(IMainView view) {
        mView = view;
    }

    @Override
    public void searchCities(String text) {
        Call<GeoNamesResult> call = ApiUtils.getGeoNameService().getGeoNames(
                text, MAX_PAGES, 0, DEFAULT_LANG);

        call.enqueue(new Callback<GeoNamesResult>() {
            @Override
            public void onResponse(@NonNull Call<GeoNamesResult> call, @NonNull Response<GeoNamesResult> response) {

                if (response.isSuccessful()) {
                    GeoNamesResult result = response.body();

                    if (result == null || result.getGeonames() == null) {
                        return;
                    }

                    CityView cityView;
                    List<CityView> cities = new ArrayList<>();
                    List<String> cityNames = new ArrayList<>();
                    for (Geoname geoname : result.getGeonames()) {
                        cityView = convertGeoNameToCity(geoname);
                        if (!cityNames.contains(cityView.getName())) {
                            cities.add(cityView);
                            cityNames.add(cityView.getName());
                        }
                    }

                    mView.loadData(cities);
                }

            }

            @Override
            public void onFailure(@NonNull Call<GeoNamesResult> call, @NonNull Throwable t) {

            }
        });
    }

    private CityView convertGeoNameToCity(Geoname geoname) {

        CityView cityView = new CityView();

        cityView.setName(geoname.getName());

        return cityView;

    }
}