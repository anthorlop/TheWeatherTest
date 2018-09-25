package com.anthorlop.theweathertest.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AlternateName {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("isShortName")
    @Expose
    private Boolean isShortName;
    @SerializedName("isPreferredName")
    @Expose
    private Boolean isPreferredName;

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

    /**
     * @return Gets the value of lang and returns lang
     */
    public String getLang() {
        return lang;
    }

    /**
     * Set a value from lang variable
     */
    public void setLang(String lang) {
        this.lang = lang;
    }

    /**
     * @return Gets the value of isShortName and returns isShortName
     */
    public Boolean getShortName() {
        return isShortName;
    }

    /**
     * Set a value from isShortName variable
     */
    public void setShortName(Boolean shortName) {
        isShortName = shortName;
    }

    /**
     * @return Gets the value of isPreferredName and returns isPreferredName
     */
    public Boolean getPreferredName() {
        return isPreferredName;
    }

    /**
     * Set a value from isPreferredName variable
     */
    public void setPreferredName(Boolean preferredName) {
        isPreferredName = preferredName;
    }

}
