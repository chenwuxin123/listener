package com.meipiao.ctrip_applepie.listener.entity.sqlserver;

import java.io.Serializable;

/**
 * @Author: Chenwx
 * @Date: 2020/4/1 15:29
 */
public class Hotels implements Serializable {
    private Long id;

    private int hotelStar;

    private int starLicence;

    private String hotelTel;

    private String lat;

    private String lon;

    private String googleLat;

    private String googleLon;

    private String baiduLat;

    private String baiduLon;

    private String gdLat;

    private String gdLon;

    private int status;

    private String postalCode;

    private String whenBuilt;

    private String renovationCompletionDate;

    private String hotelPhone;

    private String hotelEmail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getHotelStar() {
        return hotelStar;
    }

    public void setHotelStar(int hotelStar) {
        this.hotelStar = hotelStar;
    }

    public int getStarLicence() {
        return starLicence;
    }

    public void setStarLicence(int starLicence) {
        this.starLicence = starLicence;
    }

    public String getHotelTel() {
        return hotelTel;
    }

    public void setHotelTel(String hotelTel) {
        this.hotelTel = hotelTel;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getGoogleLat() {
        return googleLat;
    }

    public void setGoogleLat(String googleLat) {
        this.googleLat = googleLat;
    }

    public String getGoogleLon() {
        return googleLon;
    }

    public void setGoogleLon(String googleLon) {
        this.googleLon = googleLon;
    }

    public String getBaiduLat() {
        return baiduLat;
    }

    public void setBaiduLat(String baiduLat) {
        this.baiduLat = baiduLat;
    }

    public String getBaiduLon() {
        return baiduLon;
    }

    public void setBaiduLon(String baiduLon) {
        this.baiduLon = baiduLon;
    }

    public String getGdLat() {
        return gdLat;
    }

    public void setGdLat(String gdLat) {
        this.gdLat = gdLat;
    }

    public String getGdLon() {
        return gdLon;
    }

    public void setGdLon(String gdLon) {
        this.gdLon = gdLon;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getWhenBuilt() {
        return whenBuilt;
    }

    public void setWhenBuilt(String whenBuilt) {
        this.whenBuilt = whenBuilt;
    }

    public String getRenovationCompletionDate() {
        return renovationCompletionDate;
    }

    public void setRenovationCompletionDate(String renovationCompletionDate) {
        this.renovationCompletionDate = renovationCompletionDate;
    }

    public String getHotelPhone() {
        return hotelPhone;
    }

    public void setHotelPhone(String hotelPhone) {
        this.hotelPhone = hotelPhone;
    }

    public String getHotelEmail() {
        return hotelEmail;
    }

    public void setHotelEmail(String hotelEmail) {
        this.hotelEmail = hotelEmail;
    }

    @Override
    public String toString() {
        return "Hotels{" +
                "id=" + id +
                ", hotelStar=" + hotelStar +
                ", starLicence=" + starLicence +
                ", hotelTel='" + hotelTel + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                ", googleLat='" + googleLat + '\'' +
                ", googleLon='" + googleLon + '\'' +
                ", baiduLat='" + baiduLat + '\'' +
                ", baiduLon='" + baiduLon + '\'' +
                ", gdLat='" + gdLat + '\'' +
                ", gdLon='" + gdLon + '\'' +
                ", status=" + status +
                ", postalCode='" + postalCode + '\'' +
                ", whenBuilt='" + whenBuilt + '\'' +
                ", renovationCompletionDate='" + renovationCompletionDate + '\'' +
                ", hotelPhone='" + hotelPhone + '\'' +
                ", hotelEmail='" + hotelEmail + '\'' +
                '}';
    }
}
