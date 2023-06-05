package com.narola.carrental.validation;

public class Validation {

    private static EmailValidator emailValidator = new EmailValidator();
    private static MobileNumberValidator mobileNumberValidator = new MobileNumberValidator();

    public static boolean isEmpty(String val) {
        if (val == null || val.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isValidEmail(String email) {
        return emailValidator.validate(email);
    }

    public static boolean isValidMobile(String mobileNo) {
        return mobileNumberValidator.validate(mobileNo);
    }

}
