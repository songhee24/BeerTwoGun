package com.BeerTwoGun.controller;

import com.BeerTwoGun.entity.User;
import com.BeerTwoGun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

//    @PostMapping
//    public User save(@RequestBody User user){
//        return userService.save(user);
//    }

    @PostMapping
    public User crateUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
