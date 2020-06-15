package com.BeerTwoGun.controller;

import com.BeerTwoGun.DateConvert;
import com.BeerTwoGun.entity.Person;
import com.BeerTwoGun.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping
    public Person save(@RequestBody Person person){
        return personService.save(person);
    }

    @PostMapping("/create")
    public Person createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }
}
