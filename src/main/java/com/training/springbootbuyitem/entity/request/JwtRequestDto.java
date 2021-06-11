package com.training.springbootbuyitem.entity.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtRequestDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
}
