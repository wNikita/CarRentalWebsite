package com.narola.carrental.view;


public class AdminView {
    //AdminView,ViewByRoleAdmin
    //AdminMenu
    public static void displayAdminMenu() {
        System.out.println("-----------What you want to doo----------");
        System.out.println("1.Agency Profile");
        System.out.println("2.Add Car");
        System.out.println("3.View Car");
        System.out.println("4.My Account");
        System.out.println("0.Exit");
        System.out.println("Enter choice:");

    }
    public void displayCarViewMenu()
    {
        System.out.println("1.View All Car");
        System.out.println("2.Sort By Name");
        System.out.println("3.Sort By Rental Rate");
        System.out.println("4.Sort By fuel type");
    }

    public void displayForSorting()
    {
        System.out.println("1.Name in ascending order");
        System.out.println("2.Name in descending order");
    }

    public void displayForFuelType()
    {
        System.out.println("1.Sort by petrol");
        System.out.println("2.Sort by diesel");
    }
}

