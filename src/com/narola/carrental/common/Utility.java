package com.narola.carrental.common;

import java.util.Random;

public class Utility {

    private Utility() {
    }

    public static String generateVerificationCode() {

        Random rand = new Random();
        int code = rand.nextInt(900000) + 100000;
        //System.out.println("code is" + code);
        return Integer.toString(code);
    }

}




