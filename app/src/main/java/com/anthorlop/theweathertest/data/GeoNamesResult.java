package com.anthorlop.theweathertest.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GeoNamesResult {

    @SerializedName("totalResultsCount")
    @Expose
    private Integer totalResultsCount;
    @SerializedName("geonames")
    @Expose
    private List<Geoname> geonames = null;

    /**
     * @return Gets the value of totalResultsCount and returns totalResultsCount
     */
    public Integer getTotalResultsCount() {
        return totalResultsCount;
    }

    /**
     * Set a value from totalResultsCount variable
     */
    public void setTotalResultsCount(Integer totalResultsCount) {
        this.totalResultsCount = totalResultsCount;
    }

    /**
     * @return Gets the value of geonames and returns geonames
     */
    public List<Geoname> getGeonames() {
        return geonames;
    }

    /**
     * Set a value from geonames variable
     */
    public void setGeonames(List<Geoname> geonames) {
        this.geonames = geonames;
    }
}
