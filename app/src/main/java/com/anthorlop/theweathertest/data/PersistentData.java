package com.anthorlop.theweathertest.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.anthorlop.theweathertest.dataview.CityView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class PersistentData {

    private static final String HISTORY_CITIES = "HistoryCities";

    public static void saveHistoryList(Context c, List<CityView> list) {
        SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(c);
        SharedPreferences.Editor prefsEditor = appSharedPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        prefsEditor.putString(HISTORY_CITIES, json);
        prefsEditor.apply();
    }

    public static List<CityView> getHistoryCities(Context c) {

        SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(c);
        Gson gson = new Gson();
        Type type = new TypeToken<List<CityView>>(){}.getType();
        String json = appSharedPrefs.getString(HISTORY_CITIES, "");

        return gson.fromJson(json, type);
    }

}
