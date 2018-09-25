package com.anthorlop.theweathertest.interfaces;

import com.anthorlop.theweathertest.dataview.CityView;

import java.util.List;

public interface IMainView {

    void showLoading(boolean show);

    void loadData(List<CityView> cities);

}
