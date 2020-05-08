package com.meipiao.ctrip_applepie.listener.entity.sqlserver;

import java.io.Serializable;

/**
 * @Author: Chenwx
 * @Date: 2020/4/1 15:22
 */

public class HotelExtend implements Serializable {
    private Long id;

    private Long hotelId;

    private String language;

    private String title;

    private String hotelTel;

    private int countryId;

    private String country;

    private int cityId;

    private String city;

    private String address;

    private String brief;

    private String description;

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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHotelTel() {
        return hotelTel;
    }

    public void setHotelTel(String hotelTel) {
        this.hotelTel = hotelTel;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
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

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "HotelExtend{" +
                "id=" + id +
                ", hotelId=" + hotelId +
                ", language='" + language + '\'' +
                ", title='" + title + '\'' +
                ", hotelTel='" + hotelTel + '\'' +
                ", countryId=" + countryId +
                ", country='" + country + '\'' +
                ", cityId=" + cityId +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", brief='" + brief + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
