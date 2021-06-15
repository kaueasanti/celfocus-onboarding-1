package com.training.springbootbuyitem.entity.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserResponseDto extends CreateUserResponseDto {

    private String name;
    private String email;
    private String password;

}
