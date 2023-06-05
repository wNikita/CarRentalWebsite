package com.narola.carrental.view;

import com.narola.carrental.common.MenuInput;
import com.narola.carrental.model.User;

public class LoginView {
    User user = new User();

    public User getLoginInfo() {

        System.out.println("-----Enter Login Credentials-----");

        System.out.print("Enter Email: ");
        user.setEmailId(MenuInput.takeStringInput());

        System.out.print("Enter password: ");
        user.setPassword((MenuInput.takeStringInput()));

        return user;
    }

    public void displayLoginSuccessMessage(String name) {
        System.out.println("Welcome " + name);
    }

    public void displayErrorMessage(String message) {
        System.out.println("Error:" + message);
    }

}