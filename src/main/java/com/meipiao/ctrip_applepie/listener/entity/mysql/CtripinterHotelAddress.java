package com.meipiao.ctrip_applepie.listener.entity.mysql;

import java.util.Date;
import java.io.Serializable;

/**
 * (CtripinterHotelAddress)实体类
 *
 * @author makejava
 * @since 2020-03-24 15:58:49
 */
public class CtripinterHotelAddress implements Serializable {
    private static final long serialVersionUID = 245324756542291260L;

    private Long id;

    private Long ctripinterHotelId;

    private String language;

    private String country;

    private String city;

    private String addressLine;

    private String postalCode;

    private String code;

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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCtripinterHotelId() {
        return ctripinterHotelId;
    }

    public void setCtripinterHotelId(Long ctripinterHotelId) {
        this.ctripinterHotelId = ctripinterHotelId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

}