package com.anthorlop.theweathertest.interfaces;

import com.anthorlop.theweathertest.dataview.CityView;

import java.util.List;

/**
 * TheWeatherTest
 *
 * @author antonio.hormigo
 */
public interface IMainView {

    void showLoading(boolean show);

    void loadData(List<CityView> cities);

    void removeSearchData();

}
