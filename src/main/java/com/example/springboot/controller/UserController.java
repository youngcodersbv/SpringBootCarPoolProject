package com.example.springboot.controller;

import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepository;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.example.springboot.controller.Constants.REDIRECT;
import static com.example.springboot.controller.Constants.USERS;

@Controller
@RequestMapping(USERS)
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public String index(Model model) {
        Iterable iter = userService.findAll();
        model.addAttribute("users", iter);
        return "users";
    }

    @PostMapping()
    public String postIndex(@ModelAttribute User user) {
        userService.save(user);
        return REDIRECT + USERS;
    }




}
