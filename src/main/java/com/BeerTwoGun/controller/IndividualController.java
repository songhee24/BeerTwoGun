package com.BeerTwoGun.controller;

import com.BeerTwoGun.entity.Individual;
import com.BeerTwoGun.service.IndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/individual/")
public class IndividualController {
    @Autowired
    private IndividualService individualService;

    @PostMapping
    public Individual save(@RequestBody Individual individual){
        return individualService.save(individual);
    }



    @PostMapping("create")
    public String individualCreate(@ModelAttribute Individual individual) {
        individualService.individualPerson(individual);
        return "redirect:/tree";
    }
}
