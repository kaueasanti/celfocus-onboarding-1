package com.training.springbootbuyitem.error;


import com.training.springbootbuyitem.constant.BuyItemConstant;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(int id) {
        super(String.format(BuyItemConstant.USER_NOT_FOUND_MESSAGE_MSG, id));
    }
}
