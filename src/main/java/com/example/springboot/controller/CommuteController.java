package com.example.springboot.controller;

import com.example.springboot.dto.AddCommuteCommand;
import com.example.springboot.model.Commute;
import com.example.springboot.model.User;
import com.example.springboot.repository.CommuteRepository;
import com.example.springboot.repository.UserRepository;
import com.example.springboot.service.CommuteService;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

import static com.example.springboot.controller.Constants.COMMUTES;
import static com.example.springboot.controller.Constants.REDIRECT;

@Controller
@RequestMapping(COMMUTES)
public class CommuteController {

    @Autowired
    private CommuteService commuteService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String showTheCommutes(Model model) {
        Iterable iter = commuteService.findAll();
        model.addAttribute("commutesIterable", iter);
        return "commutes";
    }

    @PostMapping()
    public String addCommute(@ModelAttribute AddCommuteCommand commuteCommand) {

        Optional<User> optionalUser = userService.findById(commuteCommand.getUserId());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            Commute commute = new Commute();
            commute.setHome(commuteCommand.getHome());
            commute.setWork(commuteCommand.getWork());
            commute.setUser(user);
            user.getCommutes().add(commute);
            userService.save(user);
        }
        return REDIRECT + COMMUTES;
    }

}
