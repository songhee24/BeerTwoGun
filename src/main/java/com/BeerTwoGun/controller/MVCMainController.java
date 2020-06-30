package com.BeerTwoGun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
public class MVCMainController {
    @RequestMapping("/")
    public String root(Locale locale) {
        return "redirect:/index.html";
    }

    @RequestMapping("/index.html")
    public String index() {
        return "index";
    }
}
