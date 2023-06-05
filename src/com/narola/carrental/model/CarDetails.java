package com.narola.carrental.model;

public class CarDetails implements  Comparable<CarDetails>{

    private Integer carId;
    private String name;
    private Integer registrationNumber;
    private String color;
    private Integer model;
    private String fuelType;
    private String transmissionType;
    private Integer insurancePolicyNumber;
    private Integer noOfSeats;
    private Integer kmTravelled;
    private Integer chargePerDay;
    private Integer agencyId;
    private City city;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(Integer registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

    public Integer getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    public void setInsurancePolicyNumber(Integer insurancePolicyNumber) {
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    public Integer getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(Integer noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public Integer getKmTravelled() {
        return kmTravelled;
    }

    public void setKmTravelled(Integer kmTravelled) {
        this.kmTravelled = kmTravelled;
    }

    public Integer getChargePerDay() {
        return chargePerDay;
    }

    public void setChargePerDay(Integer chargePerDay) {
        this.chargePerDay = chargePerDay;
    }

    @Override
    public int compareTo(CarDetails o) {
        return getName().compareTo(o.getName());
    }
}

