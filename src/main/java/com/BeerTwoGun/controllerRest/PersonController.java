package com.BeerTwoGun.controllerRest;

import com.BeerTwoGun.entity.Individual;
import com.BeerTwoGun.service.IndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private IndividualService individualService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody @Valid Individual individual){

        return new ResponseEntity<>( individualService.createIndividual(individual), HttpStatus.OK);
    }
}
