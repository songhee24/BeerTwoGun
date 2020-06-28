package com.BeerTwoGun.controller;

import com.BeerTwoGun.entity.Person;
import com.BeerTwoGun.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/person/")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping
    public Person save(@RequestBody Person person){
        return personService.save(person);
    }



    @PostMapping("create")
    public String personCreate(@ModelAttribute Person person) {
        personService.createPerson(person);
        return "redirect:/tree";
    }
}
