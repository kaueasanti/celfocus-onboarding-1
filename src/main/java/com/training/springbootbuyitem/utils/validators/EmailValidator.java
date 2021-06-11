package com.training.springbootbuyitem.utils.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailConstraint, String> {

    @Override
        public void initialize(EmailConstraint password) {
    }

    @Override
    public boolean isValid(String email,
                           ConstraintValidatorContext cxt) {
        return email != null && email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
    }
}
