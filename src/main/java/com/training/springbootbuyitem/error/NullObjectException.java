package com.training.springbootbuyitem.error;

import com.training.springbootbuyitem.constant.BuyItemConstant;

public class NullObjectException extends RuntimeException {

    public NullObjectException() {
        super(String.format(BuyItemConstant.NULL_ITEM_MESSAGE_MSG));
    }

}
