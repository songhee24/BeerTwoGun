package com.BeerTwoGun.controller;

import com.BeerTwoGun.entity.User;
import com.BeerTwoGun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("register")
    public String getRegisterPage(Model model){
        model.addAttribute("user",new User());
        return "login-page/register";
    }

    @PostMapping("create")
    public String crateUser(@ModelAttribute User user) {
        userService.createUser(user);
        return "login-page/login";
    }

    @GetMapping("login")
    public String getLoginPage(Model model){
        model.addAttribute("user",new User());
        return "login-page/login";
    }

    @PostMapping("login")
    public String loginUser(@ModelAttribute User user){
//        userService.login(user);
        return "home-page/home";
    }

    @PostMapping
    public User save(@RequestBody User user){
        return userService.save(user);
    }


}
