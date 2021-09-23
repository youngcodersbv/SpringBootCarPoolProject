package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

@SpringBootTest
public class HelloWorldControllerTests {

    @Autowired
    private HelloWorldController controller;

    @Test
    public void initializtionTest() {
        assertThat(controller).isNotNull();
    }


}
