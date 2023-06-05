package com.narola.carrental.view;

import com.narola.carrental.common.MenuInput;
import com.narola.carrental.exception.DAOException;
import com.narola.carrental.manager.CarManager;
import com.narola.carrental.model.*;

import java.util.List;

public class CarView {
    public CarDetails addCarDetails() {

        CarDetails getCarDetails = new CarDetails();

        System.out.print(" Enter Car Name => ");
        getCarDetails.setName(MenuInput.takeStringInput());

        System.out.print(" Enter Car Number => ");
        getCarDetails.setRegistrationNumber(MenuInput.takeNumberInput());

        System.out.print(" Enter Car Color => ");
        getCarDetails.setColor(MenuInput.takeStringInput());

        System.out.print(" Enter Car Model => ");
        getCarDetails.setModel(MenuInput.takeNumberInput());

        System.out.print(" Enter Car_insurance_number => ");
        getCarDetails.setInsurancePolicyNumber(MenuInput.takeNumberInput());


        System.out.print(" Enter no_of_seat => ");
        getCarDetails.setNoOfSeats(MenuInput.takeNumberInput());


        System.out.print(" Enter km_travelled => ");
        getCarDetails.setKmTravelled(MenuInput.takeNumberInput());

        System.out.println("Enter fuel type[petrol,diesel,CNG]:");
        getCarDetails.setFuelType(MenuInput.takeStringInput());

        System.out.println("Enter transmission type[manual,automatic]:");
        getCarDetails.setTransmissionType(MenuInput.takeStringInput());

        System.out.print(" Enter rental_per_day => ");
        getCarDetails.setChargePerDay(MenuInput.takeNumberInput());

        return getCarDetails;
    }

    public void viewCarDetails(List<CarDetails> carDetails1) throws DAOException {
        System.out.println("List Of cars in selected city-");
        for (CarDetails carDetails : carDetails1) {

            System.out.println("CarId: " + carDetails.getCarId());
            System.out.println("Name:" + carDetails.getName());
            System.out.println("Rate Per Day:" + carDetails.getChargePerDay());
            System.out.println("------------------------------------------");
        }
        getDataOfViewCar();

    }

    public void getDataOfViewCar() throws DAOException {
        int carId;
        System.out.println("Would you like to view the data in detail? (Yes/No)");
        String response = MenuInput.takeStringInput();
        if (response.equalsIgnoreCase("Yes")) {
            System.out.println("Enter CarID:");
            carId = MenuInput.takeNumberInput();
            CarManager carManager = new CarManager();
            carManager.getAllCarDetailsById(carId);
        }
    }

    public void viewAllCarDetails(CarDetails carDetails) {
        System.out.println("Name: " + carDetails.getName());
        System.out.println("Car Number:" + carDetails.getRegistrationNumber());
        System.out.println("Rate Per Day:" + carDetails.getChargePerDay());
        System.out.println("Fuel Type:" + carDetails.getFuelType());
        System.out.println("Transmission Mode: " + carDetails.getTransmissionType());
        System.out.println("Color: " + carDetails.getColor());
        System.out.println("KM Travelled: " + carDetails.getKmTravelled());
        System.out.println("Model: " + carDetails.getModel());
        System.out.println("No Of Seats: " + carDetails.getNoOfSeats());
    }

}




