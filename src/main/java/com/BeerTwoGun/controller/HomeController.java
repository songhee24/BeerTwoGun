package com.BeerTwoGun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @RequestMapping("/create/user")
    public String defectDetails() {
        return "login-page/register";
    }
}
