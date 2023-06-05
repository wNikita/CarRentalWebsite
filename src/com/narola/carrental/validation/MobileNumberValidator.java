package com.narola.carrental.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobileNumberValidator {

    public static boolean validate(String str) {
        Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");
        Matcher match = ptrn.matcher(str);
        return (match.find() && match.group().equals(str));
    }
}
