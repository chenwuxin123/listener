package com.meipiao.ctrip_applepie.listener.entity.sqlserver;

import java.io.Serializable;

/**
 * @Author: Chenwx
 * @Date: 2020/4/1 15:19
 */
public class HotelDistributorRelation implements Serializable {
    private Long id;

    private Long hotelId;

    private Long distributorId;

    private String language;

    private String hotelTitle;

    private String hotelTel;
    private String country;

    private String city;

    private String address;

    private String mappingCode;

    private int isOnline;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(Long distributorId) {
        this.distributorId = distributorId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getHotelTitle() {
        return hotelTitle;
    }

    public void setHotelTitle(String hotelTitle) {
        this.hotelTitle = hotelTitle;
    }

    public String getHotelTel() {
        return hotelTel;
    }

    public void setHotelTel(String hotelTel) {
        this.hotelTel = hotelTel;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMappingCode() {
        return mappingCode;
    }

    public void setMappingCode(String mappingCode) {
        this.mappingCode = mappingCode;
    }

    public int getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(int isOnline) {
        this.isOnline = isOnline;
    }

    @Override
    public String toString() {
        return "HotelDistributorRelation{" +
                "id=" + id +
                ", hotelId=" + hotelId +
                ", distributorId=" + distributorId +
                ", language='" + language + '\'' +
                ", hotelTitle='" + hotelTitle + '\'' +
                ", hotelTel='" + hotelTel + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", mappingCode='" + mappingCode + '\'' +
                ", isOnline=" + isOnline +
                '}';
    }
}
