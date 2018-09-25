package com.anthorlop.theweathertest.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Timezone {

    @SerializedName("gmtOffset")
    @Expose
    private Integer gmtOffset;
    @SerializedName("timeZoneId")
    @Expose
    private String timeZoneId;
    @SerializedName("dstOffset")
    @Expose
    private Integer dstOffset;

    /**
     * @return Gets the value of gmtOffset and returns gmtOffset
     */
    public Integer getGmtOffset() {
        return gmtOffset;
    }

    /**
     * Set a value from gmtOffset variable
     */
    public void setGmtOffset(Integer gmtOffset) {
        this.gmtOffset = gmtOffset;
    }

    /**
     * @return Gets the value of timeZoneId and returns timeZoneId
     */
    public String getTimeZoneId() {
        return timeZoneId;
    }

    /**
     * Set a value from timeZoneId variable
     */
    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    /**
     * @return Gets the value of dstOffset and returns dstOffset
     */
    public Integer getDstOffset() {
        return dstOffset;
    }

    /**
     * Set a value from dstOffset variable
     */
    public void setDstOffset(Integer dstOffset) {
        this.dstOffset = dstOffset;
    }
}
