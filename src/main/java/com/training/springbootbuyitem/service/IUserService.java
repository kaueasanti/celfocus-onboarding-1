package com.training.springbootbuyitem.service;

import com.training.springbootbuyitem.entity.model.User;

public interface IUserService extends ICrudService<User> {

    void updateUserItems(User user, String cart);

}
