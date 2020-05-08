package com.meipiao.ctrip_applepie.listener.entity.sqlserver;

import java.io.Serializable;

/**
 * @Author: Chenwx
 * @Date: 2020/4/1 15:10
 */

public class HotelCheckInPolicys implements Serializable {
    private Long id;

    private Long hotelId;

    private int kidsFree;

    private int freeCutoffAge;

    private Long freeChildPerAdult;

    private int MinGuestAge;

    private String acceptedGuestType;

    private String petsAllowedCode;

    private int petsCharge;

    private String checkInTime;

    private String checkOutTime;

    private String petsCurrencyCode;

    private String lastCheckInTime;

    private String earlyCheckOutTime;

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

    public int getKidsFree() {
        return kidsFree;
    }

    public void setKidsFree(int kidsFree) {
        this.kidsFree = kidsFree;
    }

    public int getFreeCutoffAge() {
        return freeCutoffAge;
    }

    public void setFreeCutoffAge(int freeCutoffAge) {
        this.freeCutoffAge = freeCutoffAge;
    }

    public Long getFreeChildPerAdult() {
        return freeChildPerAdult;
    }

    public void setFreeChildPerAdult(Long freeChildPerAdult) {
        this.freeChildPerAdult = freeChildPerAdult;
    }

    public int getMinGuestAge() {
        return MinGuestAge;
    }

    public void setMinGuestAge(int minGuestAge) {
        MinGuestAge = minGuestAge;
    }

    public String getAcceptedGuestType() {
        return acceptedGuestType;
    }

    public void setAcceptedGuestType(String acceptedGuestType) {
        this.acceptedGuestType = acceptedGuestType;
    }

    public String getPetsAllowedCode() {
        return petsAllowedCode;
    }

    public void setPetsAllowedCode(String petsAllowedCode) {
        this.petsAllowedCode = petsAllowedCode;
    }

    public int getPetsCharge() {
        return petsCharge;
    }

    public void setPetsCharge(int petsCharge) {
        this.petsCharge = petsCharge;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public String getPetsCurrencyCode() {
        return petsCurrencyCode;
    }

    public void setPetsCurrencyCode(String petsCurrencyCode) {
        this.petsCurrencyCode = petsCurrencyCode;
    }

    public String getLastCheckInTime() {
        return lastCheckInTime;
    }

    public void setLastCheckInTime(String lastCheckInTime) {
        this.lastCheckInTime = lastCheckInTime;
    }

    public String getEarlyCheckOutTime() {
        return earlyCheckOutTime;
    }

    public void setEarlyCheckOutTime(String earlyCheckOutTime) {
        this.earlyCheckOutTime = earlyCheckOutTime;
    }

    @Override
    public String toString() {
        return "HotelCheckInPolicys{" +
                "id=" + id +
                ", hotelId=" + hotelId +
                ", kidsFree=" + kidsFree +
                ", freeCutoffAge=" + freeCutoffAge +
                ", freeChildPerAdult=" + freeChildPerAdult +
                ", MinGuestAge=" + MinGuestAge +
                ", acceptedGuestType='" + acceptedGuestType + '\'' +
                ", petsAllowedCode='" + petsAllowedCode + '\'' +
                ", petsCharge=" + petsCharge +
                ", checkInTime='" + checkInTime + '\'' +
                ", checkOutTime='" + checkOutTime + '\'' +
                ", petsCurrencyCode='" + petsCurrencyCode + '\'' +
                ", lastCheckInTime='" + lastCheckInTime + '\'' +
                ", earlyCheckOutTime='" + earlyCheckOutTime + '\'' +
                '}';
    }
}
