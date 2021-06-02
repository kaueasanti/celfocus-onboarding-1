package com.training.springbootbuyitem.error;


import com.training.springbootbuyitem.constant.BuyItemConstant;

public class StockNotAvailableException extends RuntimeException {

    public StockNotAvailableException(String name) {
        super(String.format(BuyItemConstant.STOCK_NOT_AVAILABLE_MSG, name));
    }

}
