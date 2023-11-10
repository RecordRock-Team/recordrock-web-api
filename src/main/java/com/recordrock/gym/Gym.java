package com.recordrock.gym;

public class Gym {
    private int gymNo;
    private String gymName;
    private String phone;
    private int locationCode;

    public Gym(int gymNo, String gymName, String phone, int locationCode) {
        this.gymNo = gymNo;
        this.gymName = gymName;
        this.phone = phone;
        this.locationCode = locationCode;
    }

    public int getGymNo() {
        return gymNo;
    }

    public void setGymNo(int gymNo) {
        this.gymNo = gymNo;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(int locationCode) {
        this.locationCode = locationCode;
    }
}
