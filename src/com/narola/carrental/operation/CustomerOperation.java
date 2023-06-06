package com.narola.carrental.operation;

import com.narola.carrental.common.Constant;
import com.narola.carrental.common.MenuInput;
import com.narola.carrental.exception.DAOException;
import com.narola.carrental.view.CustomerView;

public class CustomerOperation {

    private CustomerView customerView = new CustomerView();

    public void customerMenu() throws DAOException {
        int choice;
        do {
            customerView.displayCustomerMenu();

            choice = MenuInput.takeNumberInput();
            switch (choice) {
                case Constant.SEARCH_FOR_CAR:
                    customerView.inputLocationDetails();
                    break;
                case Constant.MY_ACCOUNT:
                     customerView.displayProfileDetails();
                case Constant.BACK:
                    customerView.inputLocationDetails();
            }
        } while (choice != 3);

    }
}
