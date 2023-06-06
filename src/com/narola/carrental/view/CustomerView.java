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

    private  State state=new State();
    private AddressManager addressManager=new AddressManager();
    private City city=new City();
    private CarManager carManager=new CarManager();
    //CustomerMenu
    public static void displayCustomerMenu() {
        System.out.println("-----------What you want to doo----------");
        System.out.println("1.Search Car");
        System.out.println("2.My Account");
        System.out.println("3.Back");
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
