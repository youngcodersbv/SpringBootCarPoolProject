package com.example.springboot.service;

import com.example.springboot.model.Commute;
import com.example.springboot.repository.CommuteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommuteServiceImpl implements  CommuteService {

    @Autowired
    private CommuteRepository commuteRepository;


    @Override
    public Iterable findAll() {
        return commuteRepository.findAll();
    }

    @Override
    public Optional<Commute> findById(long id) {
        return commuteRepository.findById(id);
    }
}
