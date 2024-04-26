package com.micro.userservice.usermicroservice.service;

import java.util.List;
import java.util.Optional;

import com.micro.userservice.usermicroservice.entity.User;

public interface UserService {

    Optional<User> findByUserId(String userId);

    List<User> getUsers();

    User saveUser(User user);
}
