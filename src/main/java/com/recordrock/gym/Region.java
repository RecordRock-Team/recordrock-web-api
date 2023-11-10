package com.recordrock.gym;

public class Region {

    private int locationCode;
    private String Region;
    private String AdminID;

    public Region(int locationCode, String region, String adminID) {
        this.locationCode = locationCode;
        Region = region;
        AdminID = adminID;
    }

    public int getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(int locationCode) {
        this.locationCode = locationCode;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getAdminID() {
        return AdminID;
    }

    public void setAdminID(String adminID) {
        AdminID = adminID;
    }
}
