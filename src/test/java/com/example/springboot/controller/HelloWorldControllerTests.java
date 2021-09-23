package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class HelloWorldControllerTests {

    @Autowired
    private HelloWorldController controller;

    @Test
    public void initializtionTest() {
        // It is not null
        assertThat(controller).isNotNull();
    }

    @Test
    public void testReturnCorrectIndexTemplate() {
        String template = controller.index();
        assertThat(template).isEqualTo("index");
    }

    @Test
    public void testReturnCorrectOtherTemplate() {
        String template = controller.other();
        assertThat(template).isEqualTo("other");
    }

}
