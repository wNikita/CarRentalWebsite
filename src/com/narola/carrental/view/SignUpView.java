package com.narola.carrental.view;

import com.narola.carrental.common.MenuInput;
import com.narola.carrental.dao.UserDAO;
import com.narola.carrental.exception.DAOException;
import com.narola.carrental.model.User;
import com.narola.carrental.validation.Validation;

public class SignUpView {

    public User getSignUpInfo() throws DAOException {
        User user = new User();
        UserDAO userDAO = new UserDAO();
        RoleView roleView = new RoleView();

        boolean isValidInput;

        user.setRoleId((roleView.displayRoleMenuAndTakeInput()));

        System.out.print(" Enter firstName => ");
        user.setFirstName(MenuInput.takeStringInput());


        System.out.print(" Enter lastName => ");
        user.setLastName(MenuInput.takeStringInput(true));

        do {
            System.out.print(" Enter emailId => ");
            user.setEmailId(MenuInput.takeStringInput());
            isValidInput = Validation.isEmpty(user.getEmailId()) || !Validation.isValidEmail(user.getEmailId());
            if (Validation.isEmpty(user.getEmailId())) {
                System.out.println("Enter value");
            } else if (!Validation.isValidEmail(user.getEmailId())) {
                System.out.println("Email is not in valid format");
            } else if (userDAO.checkEmailExists(user.getEmailId())) {
                System.out.println("Email is already exists! Enter another emailID");
            }
        } while (isValidInput || userDAO.checkEmailExists(user.getEmailId()));


        System.out.print(" Enter password => ");
        user.setPassword(MenuInput.takeStringInput());

        System.out.print(" Enter Address => ");
        user.setAddress(MenuInput.takeStringInput());

        do {
            System.out.print(" Enter MobileNO => ");
            user.setMobileNO(MenuInput.takeStringInput(true));
            if (!Validation.isEmpty(user.getMobileNO())) {
                if (!Validation.isValidMobile(user.getMobileNO())) {
                    System.out.println("Enter valid number!");
                }
                if (userDAO.checkMobileNumberExists(user.getMobileNO())) {
                    System.out.println("Mobile number already exists! Enter another Mobile Number");
                }
            }
        } while (!Validation.isValidMobile(user.getMobileNO()) || user.getMobileNO().isEmpty() || userDAO.checkMobileNumberExists(user.getMobileNO()));
        return user;
    }

    public void displaySignUpSuccessMessage() {
        System.out.println("Account created successfully");
    }

    public void displaySignUpErrorMessage(String message) {
        System.out.println("Error:" + message);
    }
}
