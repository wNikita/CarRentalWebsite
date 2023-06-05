package com.narola.carrental.manager;

import com.narola.carrental.common.Session;
import com.narola.carrental.dao.UserDAO;
import com.narola.carrental.exception.DAOException;
import com.narola.carrental.model.User;
import com.narola.carrental.validation.Validation;
import com.narola.carrental.view.LoginView;

import java.util.Scanner;

public class LoginManager {

    private LoginView loginView = new LoginView();
    private UserDAO userDAO = new UserDAO();

    public void doLogin() throws DAOException {
        User user = loginView.getLoginInfo();
        User user1 = userDAO.getUserByCredentials(user.getEmailId(), user.getPassword());
        try {
            if (user1 == null) {
                loginView.displayErrorMessage("Enter valid credentials");
            }
            if (!user1.isVerified()) {
                String verificationCode;
                do {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Enter OTP");
                    verificationCode = scanner.nextLine();
                    if (Validation.isEmpty(verificationCode)) {
                        System.out.println("Enter value");
                    }
                    if (verificationCode.equals(user1.getVerificationCode())) {
                        userDAO.updateUserIsVerified(true, user1.getEmailId());
                    } else {
                        loginView.displayErrorMessage("Verification code is wrong...");
                    }
                } while (verificationCode.isEmpty() || !verificationCode.equals(user1.getVerificationCode()));
                loginView.displayLoginSuccessMessage(user1.getFirstName() + " " + user1.getLastName() + " " +
                        "\nYour Role is: " + user1.getRoleName());
                Session.setCurrentUser(user1);
                RoleManager roleManager = new RoleManager();
                roleManager.manageRole();
            } else {
                loginView.displayLoginSuccessMessage(user1.getFirstName() + " " + user1.getLastName() + " " +
                        "\nYour Role is: " + user1.getRoleName());
                Session.setCurrentUser(user1);
                RoleManager roleManager = new RoleManager();
                roleManager.manageRole();
            }
        } catch (DAOException ex) {
            ex.printStackTrace();
            loginView.displayErrorMessage("Ops, Something went wrong");
        } catch (NullPointerException ex) {
            loginView.displayErrorMessage("Ops,Something went wrong");
        }
    }
}



