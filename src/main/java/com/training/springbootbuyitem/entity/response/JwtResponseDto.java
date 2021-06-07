package com.training.springbootbuyitem.entity.response;

import java.io.Serializable;

public class JwtResponseDto implements Serializable {

    private static final long serialVersionUID = 2L;

    private final String jwtToken;

    public JwtResponseDto(String jwtToken){
        this.jwtToken = jwtToken;
    }

    public String getToken(){
        return this.jwtToken;
    }
}
