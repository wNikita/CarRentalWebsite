package com.narola.carrental.view;

import com.narola.carrental.model.City;
import com.narola.carrental.model.State;

import java.util.List;

public class AddressView {

    public List<State> displayState(List<State> stateList) {
        for (State state : stateList) {
            System.out.println("---------------------------");
            System.out.println("StateID:" + state.getStateId());
            System.out.println("StateName:" + state.getStateName());
        }
        return stateList;
    }

    public List<City> displayCity(List<City> cityList) {
        for (City city : cityList) {
            System.out.println("---------------------------");
            System.out.println("CityID:" + city.getCityId());
            System.out.println("CityName:" + city.getCityName());
        }
        return cityList;
    }
}
