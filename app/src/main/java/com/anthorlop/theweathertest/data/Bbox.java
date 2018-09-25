package com.anthorlop.theweathertest.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bbox {

    @SerializedName("east")
    @Expose
    private Double east;
    @SerializedName("south")
    @Expose
    private Double south;
    @SerializedName("north")
    @Expose
    private Double north;
    @SerializedName("west")
    @Expose
    private Double west;
    @SerializedName("accuracyLevel")
    @Expose
    private Integer accuracyLevel;

    /**
     * @return Gets the value of east and returns east
     */
    public Double getEast() {
        return east;
    }

    /**
     * Set a value from east variable
     */
    public void setEast(Double east) {
        this.east = east;
    }

    /**
     * @return Gets the value of south and returns south
     */
    public Double getSouth() {
        return south;
    }

    /**
     * Set a value from south variable
     */
    public void setSouth(Double south) {
        this.south = south;
    }

    /**
     * @return Gets the value of north and returns north
     */
    public Double getNorth() {
        return north;
    }

    /**
     * Set a value from north variable
     */
    public void setNorth(Double north) {
        this.north = north;
    }

    /**
     * @return Gets the value of west and returns west
     */
    public Double getWest() {
        return west;
    }

    /**
     * Set a value from west variable
     */
    public void setWest(Double west) {
        this.west = west;
    }

    /**
     * @return Gets the value of accuracyLevel and returns accuracyLevel
     */
    public Integer getAccuracyLevel() {
        return accuracyLevel;
    }

    /**
     * Set a value from accuracyLevel variable
     */
    public void setAccuracyLevel(Integer accuracyLevel) {
        this.accuracyLevel = accuracyLevel;
    }
}
