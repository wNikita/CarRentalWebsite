package com.narola.carrental.manager;

import com.narola.carrental.common.Session;
import com.narola.carrental.dao.CarDAO;
import com.narola.carrental.exception.DAOException;
import com.narola.carrental.model.CarDetails;
import com.narola.carrental.model.City;
import com.narola.carrental.operation.AdminOperation;
import com.narola.carrental.view.CarView;

import java.util.List;

public class CarManager {

    private CarDAO carDAO = new CarDAO();
    private CarView carView = new CarView();


    public void addCar() throws DAOException {
        if (Session.isAgencyAdmin()) {
            CarDetails carDetails = carView.addCarDetails();
            carDetails.setAgencyId(Session.getAgencyId());
            carDAO.add(carDetails);
        }
    }

    public void viewCarDetails() throws DAOException {
        List<CarDetails> carDetails = carDAO.viewAllCar(Session.getAgencyId());
        AdminOperation adminOperation = new AdminOperation();
        adminOperation.setCarView(carDetails);
        carView.viewCarDetails(carDetails);
    }

    public void getCarByCityId(City city) throws DAOException {
        List<CarDetails> carDetails=carDAO.getCarByCityId(city.getCityId());
        carView.viewCarDetails(carDetails);
    }

    public void getAllCarDetailsById(int carId) throws DAOException
    {
        CarDetails carDetails=carDAO.getAllCarDetails(carId);
        carView.viewAllCarDetails(carDetails);
    }
}
