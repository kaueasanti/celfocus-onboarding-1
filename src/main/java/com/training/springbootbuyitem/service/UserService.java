package com.training.springbootbuyitem.service;

import com.training.springbootbuyitem.entity.model.Item;
import com.training.springbootbuyitem.entity.model.User;
import com.training.springbootbuyitem.enums.EnumEntity;
import com.training.springbootbuyitem.error.EntityNotFoundException;

import com.training.springbootbuyitem.error.NullObjectException;
import com.training.springbootbuyitem.error.UserNotFoundException;
import com.training.springbootbuyitem.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserService implements IUserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public User get(Long id) {
        log.info("Getting user");
        return userRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(EnumEntity.USER.name(), id));

    }

    @Override
    public List<User> get(List<Long> id) {
        return new ArrayList<>();
    }

    @Override
    public void delete(Long id) {
        try {
            userRepository.delete(get(id));
        } catch (UserNotFoundException e) {
        }
    }

    @Override
    public User update(User user) {
        if (user != null) {
            User persistedUser = get(user.getUserUid());
            if (!StringUtils.isEmpty(user.getName())) {
                persistedUser.setName(user.getName());
            }
            if (!StringUtils.isEmpty(user.getEmail())) {
                persistedUser.setEmail(user.getEmail());
            }
            userRepository.save(persistedUser);
        }
        throw new NullObjectException();
    }

    @Override
    public void updateUserItems(User user, List<Item> items) {
        items.stream().forEach(item -> update(user));
    }

    @Override
    public User save(User user) {
        if (user != null) {
            userRepository.save(user);
        }
        throw new NullObjectException();
    }
}
