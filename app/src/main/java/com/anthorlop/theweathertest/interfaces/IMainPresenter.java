package com.anthorlop.theweathertest.interfaces;

import android.content.Context;

import com.anthorlop.theweathertest.dataview.CityView;

public interface IMainPresenter {

    void searchCities(String text);

    void onCityClicked(Context context, CityView cityView);

}
