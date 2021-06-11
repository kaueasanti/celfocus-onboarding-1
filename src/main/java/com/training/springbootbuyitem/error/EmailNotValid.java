package com.training.springbootbuyitem.error;


import com.training.springbootbuyitem.constant.CreateUserConstant;

public class EmailNotValid extends RuntimeException{
    public EmailNotValid(String email) {
        super(String.format(CreateUserConstant.EMAIL_NOT_VALID_MSG, email));
    }
}
