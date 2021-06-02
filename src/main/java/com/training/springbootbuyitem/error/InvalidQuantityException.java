package com.training.springbootbuyitem.error;


import com.training.springbootbuyitem.constant.BuyItemConstant;

public class InvalidQuantityException extends RuntimeException {

    public InvalidQuantityException() {
        super(String.format(BuyItemConstant.INVALID_QUANTITY_MSG));
    }

}
