package com.training.springbootbuyitem.service;

import com.training.springbootbuyitem.entity.model.User;
import com.training.springbootbuyitem.enums.EnumEntity;
import com.training.springbootbuyitem.error.EntityNotFoundException;

import com.training.springbootbuyitem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * @JavaDoc RestTemplate is a synchronous Http Client which is supported by Pivotal development team take into
     * consideration this client is deprecated and shall not be supported for LTS use instead the newly Http Client
     * WebClient which is capable of synchronous & asynchronous invocations check some code samples at:
     * https://spring.io/guides/gs/consuming-rest/
     */
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public User get(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(EnumEntity.USER.name(), id));
    }

    @Override
    public List<User> get(List<Long> id) {
        return new ArrayList<>();
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(get(id));
    }


    @Override
    public User update(User user) {
        User persistedUser = get(user.getUserUid());
        if (!StringUtils.isEmpty(user.getName())) {
            persistedUser.setName(user.getName());
        }
        if (!StringUtils.isEmpty(user.getEmail())) {
            persistedUser.setEmail(user.getEmail());
        }
        return userRepository.save(persistedUser);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
