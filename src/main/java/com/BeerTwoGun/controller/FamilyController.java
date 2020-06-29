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
public class FamilyController {
    @Autowired
    private IndividualService individualService;
    @Autowired
    private FamilyService familyService;

    @RequestMapping(value = "/family/create" ,method = RequestMethod.POST)
    public String create(Model model, Family family){
        model.addAttribute("family",new Family());
        familyService.save(family);
        return "/createFamily";

    }

//    @RequestMapping(value = "/family/create",method = RequestMethod.GET)
//    public String getForms(@ModelAttribute Individual individual, Model model){
//        model.addAttribute("family",individualService.findAll());
//        return "/createFamily";
//    }

    @RequestMapping(value = "/family",method = RequestMethod.GET)
    public String getPage(@ModelAttribute Individual individual,Model model){
        model.addAttribute("people",individualService.findAll());
        model.addAttribute("family",new Family());
        return "/createFamily";
    }

  @RequestMapping(value = "/family/{personId}",method = RequestMethod.POST)
    public String addPerson(Model model, @PathVariable(value = "personId",required = false)Long personId){
            model.addAttribute("familyHead",personId == null ? new Individual():individualService.findById(personId));
            return"/createFamily";
  }
}
