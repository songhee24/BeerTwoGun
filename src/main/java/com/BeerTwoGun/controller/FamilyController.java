package com.BeerTwoGun.controller;

import com.BeerTwoGun.entity.Family;
import com.BeerTwoGun.entity.Individual;
import com.BeerTwoGun.service.FamilyService;
import com.BeerTwoGun.service.IndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FamilyController {
    @Autowired
    private IndividualService individualService;
    @Autowired
    private FamilyService familyService;

    @RequestMapping(value = "/family/create" ,method = RequestMethod.POST)
    public String create(Model model, Family family, Long head1id, Long head2id){
        model.addAttribute("family",family);

        System.err.println("head1:"+head1id);
        System.err.println("head2:"+head2id);
        familyService.create(family,head1id,head2id);
        return "/createFamily";
    }

    @RequestMapping(value = {"family/addId/{id}","family/addId2/{id2}"},method = RequestMethod.GET)
    public String add(Model model,@PathVariable(value = "id",required = false)Long id,
                      @PathVariable(value = "id2",required = false)Long id2){
        model.addAttribute("people",individualService.findAll());
        model.addAttribute("family",new Family());
        System.err.println("id:"+id);
        System.err.println("id:"+id2);
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

  @RequestMapping(value = "/family/{head1id}&&/{head2id}",method = RequestMethod.GET)
    public String addPerson(Model model,
                            @PathVariable(value = "head1id",required = false)Long head1id,
                            @PathVariable(value = "head2id",required = false)Long head2id){
            model.addAttribute("individual1",head1id == null ? new Individual():individualService.findById(head1id));
            model.addAttribute("family",new Family());
            return"/createFamily";
  }
}
