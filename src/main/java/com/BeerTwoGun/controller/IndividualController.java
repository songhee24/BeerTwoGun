package com.BeerTwoGun.controller;

import com.BeerTwoGun.entity.Family;
import com.BeerTwoGun.entity.Individual;
import com.BeerTwoGun.service.IndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/individual")
public class IndividualController {
    @Autowired
    private IndividualService individualService;

    @PostMapping
    public Individual save(@RequestBody Individual individual){
        return individualService.save(individual);
    }

    @GetMapping
    public String getCreatePage( Model model){
        model.addAttribute("individual",new Individual());
        return "/createPerson";
    }

    @PostMapping("/create")
    public String individualCreate(@ModelAttribute Individual individual,Model model) {
        model.addAttribute("individual",individual);
        individualService.createIndividual(individual);
        return "/createPerson";
    }

//    @GetMapping("/getIndividuals")
//    public String getIndividuals(Model model){
//        model.addAttribute("individuals",individualService.findAll());
//        return "/createPerson";
//    }


    @GetMapping("/family/create")
    public String getFamily(Model model){
        model.addAttribute("family",new Family());
        return "/createFamily";
    }
}
