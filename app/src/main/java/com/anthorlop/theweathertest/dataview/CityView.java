package com.anthorlop.theweathertest.dataview;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class CityView implements Parcelable {

    private String name;
    private String countryName;

    private Double east;
    private Double south;
    private Double north;
    private Double west;

    public CityView() {
    }

    /**
     * @return Gets the value of name and returns name
     */
    public String getName() {
        return name;
    }

    /**
     * Set a value from name variable
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setGeoPositions(Double east, Double south, Double north, Double west) {
        this.east = east;
        this.south = south;
        this.north = north;
        this.west = west;
    }

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
     * @return Gets the value of countryName and returns countryName
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Set a value from countryName variable
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getNameWithCountry() {
        String result = name;

        if (!TextUtils.isEmpty(countryName)) {
            result = result.concat(" (").concat(countryName.concat(")"));
        }

        return result;
    }

    /**
     * Set a value from west variable
     */
    public void setWest(Double west) {
        this.west = west;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.countryName);
        dest.writeValue(this.east);
        dest.writeValue(this.south);
        dest.writeValue(this.north);
        dest.writeValue(this.west);
    }

    protected CityView(Parcel in) {
        this.name = in.readString();
        this.countryName = in.readString();
        this.east = (Double) in.readValue(Double.class.getClassLoader());
        this.south = (Double) in.readValue(Double.class.getClassLoader());
        this.north = (Double) in.readValue(Double.class.getClassLoader());
        this.west = (Double) in.readValue(Double.class.getClassLoader());
    }

    public static final Creator<CityView> CREATOR = new Creator<CityView>() {
        @Override
        public CityView createFromParcel(Parcel source) {
            return new CityView(source);
        }

        @Override
        public CityView[] newArray(int size) {
            return new CityView[size];
        }
    };
}
