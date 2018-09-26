package com.anthorlop.theweathertest.presenter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;

import com.anthorlop.theweathertest.activities.DetailActivity;
import com.anthorlop.theweathertest.data.ApiUtils;
import com.anthorlop.theweathertest.data.Bbox;
import com.anthorlop.theweathertest.data.GeoNamesResult;
import com.anthorlop.theweathertest.data.Geoname;
import com.anthorlop.theweathertest.data.PersistentData;
import com.anthorlop.theweathertest.dataview.CityView;
import com.anthorlop.theweathertest.interfaces.IMainView;
import com.anthorlop.theweathertest.interfaces.IMainPresenter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.anthorlop.theweathertest.activities.DetailActivity.CITY_ITEM;

public class MainPresenter implements IMainPresenter {

    private static final int MAX_PAGES = 20;
    private static final String DEFAULT_LANG = "en";

    private final IMainView mView;

    public MainPresenter(IMainView view) {
        mView = view;
    }

    @Override
    public void searchCities(String text) {
        Call<GeoNamesResult> call = ApiUtils.getGeoNameService().getGeoNames(
                text, MAX_PAGES, 0, DEFAULT_LANG);

        mView.showLoading(true);

        Log.d("GeoNameService", "url: " + call.request().url());
        call.enqueue(new Callback<GeoNamesResult>() {
            @Override
            public void onResponse(@NonNull Call<GeoNamesResult> call, @NonNull Response<GeoNamesResult> response) {

                mView.showLoading(false);

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
                mView.showLoading(false);
            }
        });
    }

    @Override
    public void onCityClicked(Context context, CityView cityView) {
        List<CityView> citiesHistory = PersistentData.getHistoryCities(context);

        if (citiesHistory == null) {
            citiesHistory = new ArrayList<>();
        }

        citiesHistory.remove(cityView);
        citiesHistory.add(0, cityView);
        PersistentData.saveHistoryList(context, citiesHistory);

        mView.loadData(citiesHistory);
        mView.removeSearchData();

        Intent i = new Intent(context, DetailActivity.class);
        i.putExtra(CITY_ITEM, cityView);
        context.startActivity(i);
    }

    private CityView convertGeoNameToCity(Geoname geoname) {

        CityView cityView = new CityView();

        cityView.setName(geoname.getName());
        cityView.setCountryName(geoname.getCountryName());
        cityView.setLat(geoname.getLat());
        cityView.setLng(geoname.getLng());

        Bbox bbox = geoname.getBbox();
        if (bbox != null) {
            cityView.setGeoPositions(bbox.getEast(), bbox.getSouth(),
                    bbox.getNorth(), bbox.getWest());
        }

        return cityView;

    }
}
