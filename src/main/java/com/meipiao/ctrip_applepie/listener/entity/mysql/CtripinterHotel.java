package com.meipiao.ctrip_applepie.listener.entity.mysql;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * (CtripinterHotel)实体类
 *
 * @author makejava
 * @since 2020-03-24 15:58:46
 */
public class CtripinterHotel implements Serializable {
    private static final long serialVersionUID = -71231547785957468L;

    private Long id;

    private String hotelCode;

    private String hotelCategory;

    private String latitude;

    private String longitude;

    private String hotelStatus;

    private String ctripHotelCode;

    private String masterHotelNum;

    private String accountId;

    private Integer isPush;

    private Integer pushStatus;

    private String errors;

    private String idx;

    private String regId;

    private String regIp;

    private String regClientId;

    private Date regTime;

    private Long uptId;

    private String uptIp;

    private String uptClientId;

    private Date uptTime;

    private Integer dataStatus;

    private Integer isShow;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotelCode() {
        return hotelCode;
    }

    public void setHotelCode(String hotelCode) {
        this.hotelCode = hotelCode;
    }

    public String getHotelCategory() {
        return hotelCategory;
    }

    public void setHotelCategory(String hotelCategory) {
        this.hotelCategory = hotelCategory;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getHotelStatus() {
        return hotelStatus;
    }

    public void setHotelStatus(String hotelStatus) {
        this.hotelStatus = hotelStatus;
    }

    public String getCtripHotelCode() {
        return ctripHotelCode;
    }

    public void setCtripHotelCode(String ctripHotelCode) {
        this.ctripHotelCode = ctripHotelCode;
    }

    public String getMasterHotelNum() {
        return masterHotelNum;
    }

    public void setMasterHotelNum(String masterHotelNum) {
        this.masterHotelNum = masterHotelNum;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Integer getIsPush() {
        return isPush;
    }

    public void setIsPush(Integer isPush) {
        this.isPush = isPush;
    }

    public Integer getPushStatus() {
        return pushStatus;
    }

    public void setPushStatus(Integer pushStatus) {
        this.pushStatus = pushStatus;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public String getIdx() {
        return idx;
    }

    public void setIdx(String idx) {
        this.idx = idx;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getRegIp() {
        return regIp;
    }

    public void setRegIp(String regIp) {
        this.regIp = regIp;
    }

    public String getRegClientId() {
        return regClientId;
    }

    public void setRegClientId(String regClientId) {
        this.regClientId = regClientId;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Long getUptId() {
        return uptId;
    }

    public void setUptId(Long uptId) {
        this.uptId = uptId;
    }

    public String getUptIp() {
        return uptIp;
    }

    public void setUptIp(String uptIp) {
        this.uptIp = uptIp;
    }

    public String getUptClientId() {
        return uptClientId;
    }

    public void setUptClientId(String uptClientId) {
        this.uptClientId = uptClientId;
    }

    public Date getUptTime() {
        return uptTime;
    }

    public void setUptTime(Date uptTime) {
        this.uptTime = uptTime;
    }

    public Integer getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    @Override
    public String toString() {
        return "CtripinterHotel{" +
                "id=" + id +
                ", hotelCode='" + hotelCode + '\'' +
                ", hotelCategory='" + hotelCategory + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", hotelStatus='" + hotelStatus + '\'' +
                ", ctripHotelCode='" + ctripHotelCode + '\'' +
                ", masterHotelNum='" + masterHotelNum + '\'' +
                ", accountId='" + accountId + '\'' +
                ", isPush=" + isPush +
                ", pushStatus=" + pushStatus +
                ", errors='" + errors + '\'' +
                ", idx='" + idx + '\'' +
                ", regId='" + regId + '\'' +
                ", regIp='" + regIp + '\'' +
                ", regClientId='" + regClientId + '\'' +
                ", regTime=" + regTime +
                ", uptId=" + uptId +
                ", uptIp='" + uptIp + '\'' +
                ", uptClientId='" + uptClientId + '\'' +
                ", uptTime=" + uptTime +
                ", dataStatus=" + dataStatus +
                ", isShow=" + isShow +
                '}';
    }
}