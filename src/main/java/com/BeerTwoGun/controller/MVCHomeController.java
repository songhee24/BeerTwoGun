package com.BeerTwoGun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MVCHomeController {

    @RequestMapping("/home")
    public String defectDetails() {
        return "home-page/home";
    }
}