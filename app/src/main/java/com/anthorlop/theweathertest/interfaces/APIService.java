package com.anthorlop.theweathertest.interfaces;

import com.anthorlop.theweathertest.data.GeoNamesResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface APIService {

    @Headers("Content-Type:application/json")
    @GET("searchJSON?isNameRequired=true&style=FULL&username=ilgeonamessample")
    Call<GeoNamesResult> getGeoNames(@Query("q") String q, @Query("maxRows") Integer max, @Query("startRow") Integer start, @Query("lang") String lang);

}
