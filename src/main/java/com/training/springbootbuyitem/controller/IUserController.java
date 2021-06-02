package com.training.springbootbuyitem.controller;

import com.training.springbootbuyitem.entity.model.Item;
import com.training.springbootbuyitem.entity.model.User;
import com.training.springbootbuyitem.entity.request.CreateItemRequestDto;
import com.training.springbootbuyitem.entity.request.CreateUserRequestDto;
import com.training.springbootbuyitem.entity.request.DispatchItemRequestDto;
import com.training.springbootbuyitem.entity.request.RestockItemRequestDto;
import com.training.springbootbuyitem.entity.response.*;
import com.training.springbootbuyitem.utils.annotation.ServiceOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface IUserController {

    @PostMapping
    @ServiceOperation("createUser")
    ResponseEntity<CreateUserResponseDto> createUser(@RequestBody @Valid CreateUserRequestDto request);

    @GetMapping("/user/{id}")
    @ServiceOperation("getUser")
    ResponseEntity<GetUserResponseDto> getUser(@PathVariable("id") Long id);

    @PatchMapping("/user/{id}")
    @ServiceOperation("updateUser")
    ResponseEntity<UpdateUserResponseDto> updateUser(@PathVariable("id") Long id, @RequestBody User user);

    @DeleteMapping("/user/{id}")
    @ServiceOperation("deleteUser")
    ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id);

    @GetMapping
    @ServiceOperation("listUsers")
    ResponseEntity<List<GetUserResponseDto>> listUsers();
}
