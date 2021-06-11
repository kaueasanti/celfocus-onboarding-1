package com.training.springbootbuyitem.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class JwtResponseDto implements Serializable {

    private static final long serialVersionUID = 2L;

    private final String jwtToken;

}
