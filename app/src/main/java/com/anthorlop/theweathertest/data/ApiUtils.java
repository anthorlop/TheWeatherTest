package com.anthorlop.theweathertest.data;

import com.anthorlop.theweathertest.interfaces.APIService;

public class ApiUtils {

    private ApiUtils() {}

    private static final String ROOT_URL = "http://api.geonames.org/";

    public static APIService getGeoNameService() {
        return RetrofitClient.getGsonClient(ROOT_URL).create(APIService.class);
    }

}
