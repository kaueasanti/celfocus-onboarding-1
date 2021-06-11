package com.training.springbootbuyitem.utils.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordConstraint, String> {
    @Override
    public void initialize(PasswordConstraint password) {
    }

    @Override
    public boolean isValid(String password,
                           ConstraintValidatorContext cxt) {
        return password != null && password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
                && (password.length() > 8) && (password.length() < 14);
    }

}