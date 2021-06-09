package com.training.springbootbuyitem.utils;

import org.apache.commons.validator.EmailValidator;

public class Validator {

    public void validateEmail(String email) {

        EmailValidator emailValidator = EmailValidator.getInstance();
        if (emailValidator.isValid(email)) {
            // is valid, do something
        } else {
            // is invalid, do something
        }


    }
}
