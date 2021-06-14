package com.training.springbootbuyitem.entity.response;

import com.training.springbootbuyitem.entity.model.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserResponseDto extends CreateUserResponseDto {

    private String name;
    private String email;
    private String password;
    private Set<Item> items;

}
