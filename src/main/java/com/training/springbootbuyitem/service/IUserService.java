package com.training.springbootbuyitem.service;

import com.training.springbootbuyitem.entity.model.Item;
import com.training.springbootbuyitem.entity.model.User;

import java.util.List;

public interface IUserService extends ICrudService<User> {

    void updateUserItems(User user, List<Item> items);

}
