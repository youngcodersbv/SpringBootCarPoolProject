package com.example.springboot.service;

import com.example.springboot.model.User;

import java.util.Optional;

public interface UserService {
    Iterable findAll();

    void save(User user);

    Optional<User> findById(long id);
}
