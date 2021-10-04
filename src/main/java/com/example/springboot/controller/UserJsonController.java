package com.example.springboot.controller;

import com.example.springboot.model.User;
import com.example.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static com.example.springboot.model.User.createFilter;

@RestController()
@RequestMapping(path = "/json/users")
public class UserJsonController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public User[] getAllUserInJson(@RequestParam(value = "filter",required = false) String someStringValue) {
        Iterable<User> users = userRepository.findAll();

        List<User> result = new ArrayList();
        StreamSupport.stream(users.spliterator(),false)
                // The fully written out lambda
                .filter((User user) -> {
                    if(someStringValue == null) {
                        return true;
                    }
                    if(user.getName().toLowerCase(Locale.ROOT)
                            .contains(someStringValue.toLowerCase(Locale.ROOT))) {
                        return true;
                    } else {
                        return false;
                    }
                })
                // The shorter lambda using the filter in User
                .filter((User user) -> {
                    return User.filter(someStringValue, user);
                })
                // The shortest lambda using filter in Commute
                .filter(user -> User.filter(someStringValue, user))
                // Using a function to return a curryed function with 1 less parameter
                .filter(createFilter(someStringValue))
                // All "Predicate" functions accept 1 User parameter and return a boolean value
                .forEach(result::add);

        return result.toArray(new User[result.size()]);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") long id) {
        Optional<User> optionsUser = userRepository.findById(id);

        return optionsUser.get();
    }

}