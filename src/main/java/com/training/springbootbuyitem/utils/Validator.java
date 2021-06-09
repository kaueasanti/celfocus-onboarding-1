package com.training.springbootbuyitem.utils;

/*
import org.apache.commons.validator.EmailValidator;
*/

public class Validator {

    public static boolean validateEmail(String email) {

        /*EmailValidator emailValidator = EmailValidator.getInstance();
        return emailValidator.isValid(email) ? true : false;*/

        return (email.contains("@") || !email.contains(".")) ? true : false;

    }
}
