package com.narola.carrental.operation;

import com.narola.carrental.common.Constant;
import com.narola.carrental.common.MenuInput;
import com.narola.carrental.exception.DAOException;
import com.narola.carrental.manager.*;
import com.narola.carrental.model.CarDetails;
import com.narola.carrental.view.AdminView;
import com.narola.carrental.view.CarView;
import com.narola.carrental.view.CustomerView;
import comparator.SortingByOrder;

import java.util.List;

public class AdminOperation {
    private AdminView adminView = new AdminView();
    private  AgencyManager agencyManager = new AgencyManager();
    private  CustomerView customerView = new CustomerView();
    private SortingByOrder sortingByOrder = new SortingByOrder();
    private CarManager carManager = new CarManager();
    private CarView carView = new CarView();


    public void adminMenu() throws DAOException {
        int choice;
        do {
            adminView.displayAdminMenu();
            choice = MenuInput.takeNumberInput();
            switch (choice) {
                case Constant.AGENCY_PROFILE:
                    agencyManager.getAgencyProfileDetails();
                    break;
                case Constant.ADD_CAR:
                    carManager.addCar();
                    break;
                case Constant.VIEW_CAR_DETAILS:
                    carManager.viewCarDetails();
                    break;
                case Constant.VIEW_PROFILE:
                    customerView.displayProfileDetails();
                    break;
                case Constant.EXIT:
                    System.exit(0);
            }
        } while (choice != 5);
    }

    public void setCarView(List<CarDetails> carDetails) throws DAOException {

        int choice;
        {
            adminView.displayCarViewMenu();
            choice = MenuInput.takeNumberInput();
            switch (choice) {
                case Constant.VIEW_CAR:
                    carView.viewCarDetails(carDetails);
                    break;
                case Constant.VIEW_BY_NAME:
                    viewByFormat(carDetails);
                    break;
                case Constant.VIEW_BY_RENT_PER_DAY:
                    viewByRentalPerDay(carDetails);
                    break;
                case Constant.VIEW_BY_fUEL_TYPE:
                    viewByFuelType(carDetails);
                    break;

            }
        }
    }

    public void viewByFormat(List<CarDetails> carDetails) {
        int choice;
        {
            adminView.displayForSorting();
            choice = MenuInput.takeNumberInput();
            switch (choice) {
                case Constant.VIEW_BY_ASCENDING:
                    sortingByOrder.ascendingName(carDetails);
                    break;
                case Constant.VIEW_BY_DESCENDING:
                    sortingByOrder.descName(carDetails);
                    break;

            }
        }
    }

    public void viewByFuelType(List<CarDetails> carDetails) {
        int choice;
        {

            adminView.displayForFuelType();
            choice = MenuInput.takeNumberInput();
            switch (choice) {
                case Constant.VIEW_BY_FUEL_TYPE_PETROL:
                    sortingByOrder.fuelTypePetrol(carDetails);
                    break;
                case Constant.VIEW_BY_FUEL_TYPE_DIESEL:
                    sortingByOrder.fuelTypeDiesel(carDetails);
                    break;
            }
        }
    }

    public void viewByRentalPerDay(List<CarDetails> carDetails) {
        int choice;
        {
            adminView.displayForSorting();
            choice = MenuInput.takeNumberInput();
            switch (choice) {
                case Constant.VIEW_BY_ASCENDING:
                    sortingByOrder.highestPrize(carDetails);
                    break;
                case Constant.VIEW_BY_DESCENDING:
                    sortingByOrder.lowestPrize(carDetails);
                    break;

            }
        }
    }
}




