package com.anthorlop.theweathertest.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Geoname {

    // TODO remove unnecessary data, for now we keep all in case we want to show more data in detail

    @SerializedName("timezone")
    @Expose
    private Timezone timezone;
    @SerializedName("bbox")
    @Expose
    private Bbox bbox;
    @SerializedName("asciiName")
    @Expose
    private String asciiName;
    @SerializedName("astergdem")
    @Expose
    private Integer astergdem;
    @SerializedName("countryId")
    @Expose
    private String countryId;
    @SerializedName("fcl")
    @Expose
    private String fcl;
    @SerializedName("srtm3")
    @Expose
    private Integer srtm3;
    @SerializedName("score")
    @Expose
    private Double score;
    @SerializedName("adminId2")
    @Expose
    private String adminId2;
    @SerializedName("adminId3")
    @Expose
    private String adminId3;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("adminId1")
    @Expose
    private String adminId1;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("fcode")
    @Expose
    private String fcode;
    @SerializedName("continentCode")
    @Expose
    private String continentCode;
    @SerializedName("adminCode2")
    @Expose
    private String adminCode2;
    @SerializedName("adminCode3")
    @Expose
    private String adminCode3;
    @SerializedName("adminCode1")
    @Expose
    private String adminCode1;
    @SerializedName("lng")
    @Expose
    private String lng;
    @SerializedName("geonameId")
    @Expose
    private Integer geonameId;
    @SerializedName("toponymName")
    @Expose
    private String toponymName;
    @SerializedName("population")
    @Expose
    private Integer population;
    @SerializedName("adminName5")
    @Expose
    private String adminName5;
    @SerializedName("adminName4")
    @Expose
    private String adminName4;
    @SerializedName("adminName3")
    @Expose
    private String adminName3;
    @SerializedName("alternateNames")
    @Expose
    private List<AlternateName> alternateNames = null;
    @SerializedName("adminName2")
    @Expose
    private String adminName2;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("fclName")
    @Expose
    private String fclName;
    @SerializedName("countryName")
    @Expose
    private String countryName;
    @SerializedName("fcodeName")
    @Expose
    private String fcodeName;
    @SerializedName("adminName1")
    @Expose
    private String adminName1;

    /**
     * @return Gets the value of timezone and returns timezone
     */
    public Timezone getTimezone() {
        return timezone;
    }

    /**
     * Set a value from timezone variable
     */
    public void setTimezone(Timezone timezone) {
        this.timezone = timezone;
    }

    /**
     * @return Gets the value of bbox and returns bbox
     */
    public Bbox getBbox() {
        return bbox;
    }

    /**
     * Set a value from bbox variable
     */
    public void setBbox(Bbox bbox) {
        this.bbox = bbox;
    }

    /**
     * @return Gets the value of asciiName and returns asciiName
     */
    public String getAsciiName() {
        return asciiName;
    }

    /**
     * Set a value from asciiName variable
     */
    public void setAsciiName(String asciiName) {
        this.asciiName = asciiName;
    }

    /**
     * @return Gets the value of astergdem and returns astergdem
     */
    public Integer getAstergdem() {
        return astergdem;
    }

    /**
     * Set a value from astergdem variable
     */
    public void setAstergdem(Integer astergdem) {
        this.astergdem = astergdem;
    }

    /**
     * @return Gets the value of countryId and returns countryId
     */
    public String getCountryId() {
        return countryId;
    }

    /**
     * Set a value from countryId variable
     */
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    /**
     * @return Gets the value of fcl and returns fcl
     */
    public String getFcl() {
        return fcl;
    }

    /**
     * Set a value from fcl variable
     */
    public void setFcl(String fcl) {
        this.fcl = fcl;
    }

    /**
     * @return Gets the value of srtm3 and returns srtm3
     */
    public Integer getSrtm3() {
        return srtm3;
    }

    /**
     * Set a value from srtm3 variable
     */
    public void setSrtm3(Integer srtm3) {
        this.srtm3 = srtm3;
    }

    /**
     * @return Gets the value of score and returns score
     */
    public Double getScore() {
        return score;
    }

    /**
     * Set a value from score variable
     */
    public void setScore(Double score) {
        this.score = score;
    }

    /**
     * @return Gets the value of adminId2 and returns adminId2
     */
    public String getAdminId2() {
        return adminId2;
    }

    /**
     * Set a value from adminId2 variable
     */
    public void setAdminId2(String adminId2) {
        this.adminId2 = adminId2;
    }

    /**
     * @return Gets the value of adminId3 and returns adminId3
     */
    public String getAdminId3() {
        return adminId3;
    }

    /**
     * Set a value from adminId3 variable
     */
    public void setAdminId3(String adminId3) {
        this.adminId3 = adminId3;
    }

    /**
     * @return Gets the value of countryCode and returns countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Set a value from countryCode variable
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * @return Gets the value of adminId1 and returns adminId1
     */
    public String getAdminId1() {
        return adminId1;
    }

    /**
     * Set a value from adminId1 variable
     */
    public void setAdminId1(String adminId1) {
        this.adminId1 = adminId1;
    }

    /**
     * @return Gets the value of lat and returns lat
     */
    public String getLat() {
        return lat;
    }

    /**
     * Set a value from lat variable
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * @return Gets the value of fcode and returns fcode
     */
    public String getFcode() {
        return fcode;
    }

    /**
     * Set a value from fcode variable
     */
    public void setFcode(String fcode) {
        this.fcode = fcode;
    }

    /**
     * @return Gets the value of continentCode and returns continentCode
     */
    public String getContinentCode() {
        return continentCode;
    }

    /**
     * Set a value from continentCode variable
     */
    public void setContinentCode(String continentCode) {
        this.continentCode = continentCode;
    }

    /**
     * @return Gets the value of adminCode2 and returns adminCode2
     */
    public String getAdminCode2() {
        return adminCode2;
    }

    /**
     * Set a value from adminCode2 variable
     */
    public void setAdminCode2(String adminCode2) {
        this.adminCode2 = adminCode2;
    }

    /**
     * @return Gets the value of adminCode3 and returns adminCode3
     */
    public String getAdminCode3() {
        return adminCode3;
    }

    /**
     * Set a value from adminCode3 variable
     */
    public void setAdminCode3(String adminCode3) {
        this.adminCode3 = adminCode3;
    }

    /**
     * @return Gets the value of adminCode1 and returns adminCode1
     */
    public String getAdminCode1() {
        return adminCode1;
    }

    /**
     * Set a value from adminCode1 variable
     */
    public void setAdminCode1(String adminCode1) {
        this.adminCode1 = adminCode1;
    }

    /**
     * @return Gets the value of lng and returns lng
     */
    public String getLng() {
        return lng;
    }

    /**
     * Set a value from lng variable
     */
    public void setLng(String lng) {
        this.lng = lng;
    }

    /**
     * @return Gets the value of geonameId and returns geonameId
     */
    public Integer getGeonameId() {
        return geonameId;
    }

    /**
     * Set a value from geonameId variable
     */
    public void setGeonameId(Integer geonameId) {
        this.geonameId = geonameId;
    }

    /**
     * @return Gets the value of toponymName and returns toponymName
     */
    public String getToponymName() {
        return toponymName;
    }

    /**
     * Set a value from toponymName variable
     */
    public void setToponymName(String toponymName) {
        this.toponymName = toponymName;
    }

    /**
     * @return Gets the value of population and returns population
     */
    public Integer getPopulation() {
        return population;
    }

    /**
     * Set a value from population variable
     */
    public void setPopulation(Integer population) {
        this.population = population;
    }

    /**
     * @return Gets the value of adminName5 and returns adminName5
     */
    public String getAdminName5() {
        return adminName5;
    }

    /**
     * Set a value from adminName5 variable
     */
    public void setAdminName5(String adminName5) {
        this.adminName5 = adminName5;
    }

    /**
     * @return Gets the value of adminName4 and returns adminName4
     */
    public String getAdminName4() {
        return adminName4;
    }

    /**
     * Set a value from adminName4 variable
     */
    public void setAdminName4(String adminName4) {
        this.adminName4 = adminName4;
    }

    /**
     * @return Gets the value of adminName3 and returns adminName3
     */
    public String getAdminName3() {
        return adminName3;
    }

    /**
     * Set a value from adminName3 variable
     */
    public void setAdminName3(String adminName3) {
        this.adminName3 = adminName3;
    }

    /**
     * @return Gets the value of alternateNames and returns alternateNames
     */
    public List<AlternateName> getAlternateNames() {
        return alternateNames;
    }

    /**
     * Set a value from alternateNames variable
     */
    public void setAlternateNames(List<AlternateName> alternateNames) {
        this.alternateNames = alternateNames;
    }

    /**
     * @return Gets the value of adminName2 and returns adminName2
     */
    public String getAdminName2() {
        return adminName2;
    }

    /**
     * Set a value from adminName2 variable
     */
    public void setAdminName2(String adminName2) {
        this.adminName2 = adminName2;
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

    /**
     * @return Gets the value of fclName and returns fclName
     */
    public String getFclName() {
        return fclName;
    }

    /**
     * Set a value from fclName variable
     */
    public void setFclName(String fclName) {
        this.fclName = fclName;
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

    /**
     * @return Gets the value of fcodeName and returns fcodeName
     */
    public String getFcodeName() {
        return fcodeName;
    }

    /**
     * Set a value from fcodeName variable
     */
    public void setFcodeName(String fcodeName) {
        this.fcodeName = fcodeName;
    }

    /**
     * @return Gets the value of adminName1 and returns adminName1
     */
    public String getAdminName1() {
        return adminName1;
    }

    /**
     * Set a value from adminName1 variable
     */
    public void setAdminName1(String adminName1) {
        this.adminName1 = adminName1;
    }
}
