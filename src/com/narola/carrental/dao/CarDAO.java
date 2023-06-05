package com.narola.carrental.dao;

import com.narola.carrental.exception.DAOException;
import com.narola.carrental.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {
    public void add(CarDetails carDetails) throws DAOException {
        try {
            String insertQuery = "insert into car(name,number,color,model,insurance_no,no_of_seats," +
                    "km_travelled,fuel_type,car_agency_id,transmission_type,rental_rate_per_day )" +
                    "values (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = DBConnection.getInstance().getConnection().prepareStatement(insertQuery);
            stmt.setString(1, carDetails.getName());
            stmt.setInt(2, carDetails.getRegistrationNumber());
            stmt.setString(3, carDetails.getColor());
            stmt.setInt(4, carDetails.getModel());
            stmt.setInt(5, carDetails.getInsurancePolicyNumber());
            stmt.setInt(6, carDetails.getNoOfSeats());
            stmt.setInt(7, carDetails.getKmTravelled());
            stmt.setString(8, carDetails.getFuelType());
            stmt.setInt(9, carDetails.getAgencyId());
            stmt.setString(10, carDetails.getTransmissionType());
            stmt.setInt(11, carDetails.getChargePerDay());
            stmt.executeUpdate();
            System.out.println("-----Car register successfully-----");
        } catch (SQLException e) {
            throw new DAOException("Error while connecting");
        }
    }

    public List<CarDetails> viewAllCar(int car_agency_id) throws DAOException {
        List<CarDetails> carDetails1 = new ArrayList<>();
        try {
            String query = "select * from car where car_agency_id=?";
            PreparedStatement stmt = DBConnection.getInstance().getConnection().prepareStatement(query);
            stmt.setInt(1, car_agency_id);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                CarDetails carDetails = new CarDetails();
                carDetails.setName(resultSet.getString(2));
                carDetails.setRegistrationNumber(resultSet.getInt(3));
                carDetails.setColor(resultSet.getString(4));
                carDetails.setModel(resultSet.getInt(5));
                carDetails.setInsurancePolicyNumber(resultSet.getInt(6));
                carDetails.setNoOfSeats(resultSet.getInt(7));
                carDetails.setKmTravelled(resultSet.getInt(8));
                carDetails.setFuelType(resultSet.getString(9));
                carDetails.setTransmissionType(resultSet.getString(11));
                carDetails.setChargePerDay(resultSet.getInt(12));
                carDetails1.add(carDetails);
            }
        } catch (Exception e) {
            throw new DAOException("Error while connecting");
        }
        return carDetails1;
    }

    public List<CarDetails> getCarByCityId(int cityId) throws DAOException {
        List<CarDetails> carDetails1 = new ArrayList<>();
        try {
            String query = "SELECT *,city1.city_name FROM car AS c JOIN agency AS a ON c.car_agency_id =" +
                    "a.agency_details_id JOIN address AS ad ON a.address_id = ad.address_id JOIN city AS " +
                    "city1 ON ad.city_id=city1.city_id WHERE ad.city_id = ?";
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(query);
            statement.setInt(1, cityId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CarDetails carDetails = new CarDetails();
                carDetails.setCarId(resultSet.getInt(1));
                carDetails.setName(resultSet.getString(2));
                carDetails.setRegistrationNumber(resultSet.getInt(3));
                carDetails.setColor(resultSet.getString(4));
                carDetails.setModel(resultSet.getInt(5));
                carDetails.setInsurancePolicyNumber(resultSet.getInt(6));
                carDetails.setNoOfSeats(resultSet.getInt(7));
                carDetails.setKmTravelled(resultSet.getInt(8));
                carDetails.setFuelType(resultSet.getString(9));
                carDetails.setTransmissionType(resultSet.getString(11));
                carDetails.setChargePerDay(resultSet.getInt(12));
                City city = new City(resultSet.getInt(28), resultSet.getString(30));
                carDetails.setCity(city);
                carDetails1.add(carDetails);
            }
        } catch (SQLException e) {
            throw new DAOException("Something went wrong");
        }
        return carDetails1;
    }

    public CarDetails getAllCarDetails(int carID) throws DAOException {
        CarDetails carDetails = new CarDetails();
        try {
            String selectQuery = "select * from car where car_id=?";
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(selectQuery);
            statement.setInt(1, carID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                carDetails.setCarId(resultSet.getInt(1));
                carDetails.setName(resultSet.getString(2));
                carDetails.setRegistrationNumber(resultSet.getInt(3));
                carDetails.setColor(resultSet.getString(4));
                carDetails.setModel(resultSet.getInt(5));
                carDetails.setInsurancePolicyNumber(resultSet.getInt(6));
                carDetails.setNoOfSeats(resultSet.getInt(7));
                carDetails.setKmTravelled(resultSet.getInt(8));
                carDetails.setFuelType(resultSet.getString(9));
                carDetails.setTransmissionType(resultSet.getString(11));
                carDetails.setChargePerDay(resultSet.getInt(12));
            }
        }catch (SQLException e)
        {
            throw new DAOException("Something went wrong");
        }return carDetails;
    }
}


