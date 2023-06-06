package com.narola.carrental.operation;

import com.narola.carrental.common.Constant;
import com.narola.carrental.common.MenuInput;
import com.narola.carrental.exception.DAOException;
import com.narola.carrental.view.CustomerView;

public class CustomerOperation {


    public void customerMenu() throws DAOException {
        int choice;
        do {
            CustomerView customerView = new CustomerView();

            customerView.displayCustomerMenu();

            choice = MenuInput.takeNumberInput();
            switch (choice) {
                case Constant.SEARCH_FOR_CAR:
                case Constant.BACK:
                    customerView.inputLocationDetails();
                    break;
                case Constant.BOOK_CAR:

                    break;
                case Constant.MY_ACCOUNT:
                     customerView.displayProfileDetails();
                     break;

            }
        } while (choice != 3);

    }
}
