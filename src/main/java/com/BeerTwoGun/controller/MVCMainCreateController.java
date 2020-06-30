package com.BeerTwoGun.controller;

import com.BeerTwoGun.entity.Family;
import com.BeerTwoGun.entity.Individual;
import com.BeerTwoGun.service.FamilyService;
import com.BeerTwoGun.service.IndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MVCMainCreateController {
/*    @Autowired
    private IndividualService individualService;
    @Autowired
    private FamilyService familyService;


    @RequestMapping(value = "/family/create" ,method = RequestMethod.POST)
    public String createFamily(@ModelAttribute  Family family,Model model){
        model.addAttribute("family",family);
        familyService.save(family);
        return "/createPage";
    }

    @RequestMapping(value = "/individual",method = RequestMethod.GET)
    public String getForms(@ModelAttribute Family family,@ModelAttribute Individual individual,Model model){
        model.addAttribute("individual",individual);
        model.addAttribute("family",family);
        model.addAttribute("individuals",individualService.findAll());
        return "/createPage";
    }

    @RequestMapping(value = "/individual/create",method = RequestMethod.POST)
    public String createPerson(@ModelAttribute Individual individual, Model model){
        model.addAttribute("individual",individual);
        individualService.createIndividual(individual);
        return "/createPage";
    }
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getIndividuals(Model model){
        return "/createPage";
    }

    @RequestMapping(value = "/individual",method = RequestMethod.GET)
    public String getFormForPerson(@ModelAttribute Individual individual, Model model){
        model.addAttribute("individual",individual);
        return "/createPage";
    }


    @RequestMapping(value = "/family/{personId}",method = RequestMethod.GET)
    public String addPersonToFamily(Model model, @PathVariable(value = "personId",required = false)Long personId){
        model.addAttribute("individual",personId == null ? new Individual():individualService.findById(personId));
        return"/createPage";
    }*/
}

