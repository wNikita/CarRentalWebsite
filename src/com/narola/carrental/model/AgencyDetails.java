package com.narola.carrental.model;

public class AgencyDetails {

    private String agencyName;
    private String GSTNumber;
    private int agencyDetailsId;
    private int userId;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAgencyDetailsId() {
        return agencyDetailsId;
    }

    public void setAgencyDetailsId(int agencyDetailsId) {
        this.agencyDetailsId = agencyDetailsId;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getGSTNumber() {
        return GSTNumber;
    }

    public void setGSTNumber(String GSTNumber) {
        this.GSTNumber = GSTNumber;
    }
}
