package com.narola.carrental.common;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuInput {

    // Integer when it mandatory
    public static int takeNumberInput() {
        int value = 0;
        try {

            Scanner scanner = new Scanner(System.in);
            value = scanner.nextInt();
        } catch (InputMismatchException e) {
            takeNumberInput();

        }
        return value;
    }

    /***
     * Use this method when input in mandatory
     * @return
     */
    public static String takeStringInput() {
        return takeStringInput(false);
    }

    /***
     * Use this method when input is optional or mandaotory
     * @param isOptional Pass false in case of mandatory \n Pass true  in case of optinal.
     * @return Input value
     */
    public static String takeStringInput(boolean isOptional) {

        String value = null;
        Scanner scanner = new Scanner(System.in);
        value = scanner.nextLine();
        if (!isOptional) {
            if (value == null || value.trim().isEmpty()) {
                value = takeStringInput(false);
            }
        }
        return value;
    }
}
