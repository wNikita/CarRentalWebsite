package com.narola.carrental.manager;

import com.narola.carrental.dao.AddressDAO;
import com.narola.carrental.exception.DAOException;
import com.narola.carrental.model.AddressDetails;
import com.narola.carrental.model.City;
import com.narola.carrental.model.State;
import com.narola.carrental.view.AddressView;

import java.util.List;


public class AddressManager {

    private AddressDAO addressDAO = new AddressDAO();
    private AddressView addressView = new AddressView();


    public List<State> getAllState() throws DAOException {
        return addressView.displayState(addressDAO.getState());
    }

    public List<City> getAllCity(int stateId) throws DAOException {
        return addressView.displayCity(addressDAO.getCityByState(stateId));
    }


    public AddressDetails addAddress(City city, AddressDetails addressDetails) throws DAOException {
        AddressDetails addressDetails1 = addressDAO.addAddress(addressDetails, city.getCityId());
        return addressDetails1;
    }

    public int getAddress() throws DAOException {
        AddressDetails addressDetails = addressDAO.getAddress();
        return addressDetails.getAddressID();
    }

    public AddressDetails getAddress1() throws DAOException
    {

        AddressDetails addressDetails=addressDAO.getAddress(getAddress());
        return addressDetails;
    }
}
