package com.narola.carrental.view;

import com.narola.carrental.common.MenuInput;
import com.narola.carrental.exception.DAOException;
import com.narola.carrental.manager.AddressManager;
import com.narola.carrental.model.AddressDetails;
import com.narola.carrental.model.AgencyDetails;
import com.narola.carrental.model.City;
import com.narola.carrental.model.State;


public class AgencyView {

    AddressDetails addressDetails=new AddressDetails();
    AddressManager addressManager=new AddressManager();
    State state=new State();

    public AgencyDetails getAgencyInformation() throws DAOException {
        AgencyDetails agencyDetails = new AgencyDetails();
        System.out.println("Enter Agency Name");
        agencyDetails.setAgencyName(MenuInput.takeStringInput());
        System.out.println("Enter GST Number");
        agencyDetails.setGSTNumber(MenuInput.takeStringInput());

        System.out.println("Enter Address line 1:");
        addressDetails.setAddressLine(MenuInput.takeStringInput());

        addressManager.getAllState();

        System.out.println("Enter State");
        state.setStateId(MenuInput.takeNumberInput());
        addressManager.getAllCity(state.getStateId());

        System.out.println("Enter City");
        City city=new City();
        city.setCityId(MenuInput.takeNumberInput());


        System.out.println("Enter PinCode");
        addressDetails.setPinCode(MenuInput.takeNumberInput());

        addressManager.addAddress(city,addressDetails);

        return agencyDetails;
    }

    public void viewAgencyProfile(AgencyDetails agencyDetails,AddressDetails addressDetails) {

        System.out.println("---------------Agency Profile---------------");
        System.out.println("ID:"+agencyDetails.getUserId());
        System.out.println("Agency Name:" + agencyDetails.getAgencyName());
        System.out.println("GST Number:" + agencyDetails.getGSTNumber());
        System.out.println("AddressLine:"+addressDetails.getAddressLine());
        System.out.println("State:"+addressDetails.getState().getStateName());
        System.out.println("City:"+addressDetails.getCity().getCityName());
        System.out.println("PinCode:"+addressDetails.getPinCode());
    }
}
