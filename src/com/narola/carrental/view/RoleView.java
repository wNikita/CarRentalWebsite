package com.narola.carrental.view;

import com.narola.carrental.common.MenuInput;

public class RoleView {
    int choice = 0;

    public int displayRoleMenuAndTakeInput() {
        System.out.println("--You are SignUP as--");
        System.out.println("1.Car agency admin");
        System.out.println("2.Customer");
        System.out.println("Enter your choice");
        choice = MenuInput.takeNumberInput();
        return choice;
    }
}