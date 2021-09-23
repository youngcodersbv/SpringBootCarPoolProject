package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/other")
    public String other() {
        return "other";
    }

}
