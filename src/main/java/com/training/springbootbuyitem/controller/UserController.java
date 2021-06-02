package com.training.springbootbuyitem.controller;

import com.training.springbootbuyitem.entity.model.Item;
import com.training.springbootbuyitem.entity.model.User;
import com.training.springbootbuyitem.entity.request.CreateItemRequestDto;
import com.training.springbootbuyitem.entity.request.CreateUserRequestDto;
import com.training.springbootbuyitem.entity.request.DispatchItemRequestDto;
import com.training.springbootbuyitem.entity.request.RestockItemRequestDto;
import com.training.springbootbuyitem.entity.response.*;
import com.training.springbootbuyitem.service.ItemService;
import com.training.springbootbuyitem.service.UserService;
import com.training.springbootbuyitem.utils.annotation.ServiceOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RefreshScope
@RestController
@RequestMapping("/user")
public class UserController implements IUserController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home(){
        return "This is what i was looking for in User";
    }

    /**
     * @JavaDoc ModelMapper is a mapping tool easily configurable to accommodate most application defined entities check
     * some configuration example at: http://modelmapper.org/user-manual/
     */
    @Autowired
    private ModelMapper mapper;

    @Override
    @PostMapping("/create")
    @ServiceOperation("createUser")
    public ResponseEntity<CreateUserResponseDto> createUser(@RequestBody @Valid CreateUserRequestDto request) {
        return new ResponseEntity<>(mapper.map(userService.save(mapper.map(request, User.class)), CreateUserResponseDto.class), HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/{id}")
    @ServiceOperation("getUser")
    public ResponseEntity<GetUserResponseDto> getUser(@PathVariable("id") Long id) {
        return new ResponseEntity<>(mapper.map(userService.get(id), GetUserResponseDto.class), HttpStatus.OK);
    }


    @Override
    @PatchMapping("/{id}")
    @ServiceOperation("updateUser")
    public ResponseEntity<UpdateUserResponseDto> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        user.setUserUid(id);
        return new ResponseEntity<>(mapper.map(userService.update(user), UpdateUserResponseDto.class), HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    @ServiceOperation("deleteUser")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    @GetMapping("/all")
    @ServiceOperation("listUsers")
    public ResponseEntity<List<GetUserResponseDto>> listUsers() {
        return new ResponseEntity<>(userService.list().stream().map(i -> mapper.map(i, GetUserResponseDto.class)).collect(
                Collectors.toList()), HttpStatus.OK);
    }
}
