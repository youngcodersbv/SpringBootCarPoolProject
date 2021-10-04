package com.example.springboot.service;

import com.example.springboot.model.Commute;

import java.util.Optional;

public interface CommuteService {
    Iterable findAll();

    Optional<Commute> findById(long id);
}
