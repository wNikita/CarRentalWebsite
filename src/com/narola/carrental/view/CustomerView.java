package com.narola.carrental.view;

import com.narola.carrental.common.MenuInput;
import com.narola.carrental.common.Session;
import com.narola.carrental.exception.DAOException;
import com.narola.carrental.manager.AddressManager;
import com.narola.carrental.manager.CarManager;
import com.narola.carrental.model.City;
import com.narola.carrental.model.State;

//CustomerView,ViewByRoleCustomer
public class CustomerView {


    //CustomerMenu
    public void displayCustomerMenu() {
        System.out.println("-----------What you want to doo----------");
        System.out.println("1.Search Car");
        System.out.println("2.Book Car");
        System.out.println("3.My Account");
        System.out.println("4.Back");
        System.out.println("Enter choice:");

    }

    public void displayProfileDetails() {
        System.out.println("-----Profile Details-----");
        System.out.println("First Name: " + Session.getCurrentUser().getFirstName());
        System.out.println("Last Name : " + Session.getCurrentUser().getLastName());
        System.out.println("Address   : " + Session.getCurrentUser().getAddress());
        System.out.println("EmailID   :" + Session.getCurrentUser().getEmailId());
        System.out.println("MobileNo  :" + Session.getCurrentUser().getMobileNO());
        System.out.println("-------------------------");
    }

    public void inputLocationDetails() throws DAOException {
        State state = new State();
         AddressManager addressManager = new AddressManager();
         City city = new City();
         CarManager carManager = new CarManager();
        System.out.println("----Enter details for search the car----");
        addressManager.getAllState();
        System.out.println("Enter StateId:");
        state.setStateId(MenuInput.takeNumberInput());
        addressManager.getAllCity(state.getStateId());
        System.out.println("Enter CityId:");
        city.setCityId(MenuInput.takeNumberInput());
        carManager.getCarByCityId(city);
    }
}
