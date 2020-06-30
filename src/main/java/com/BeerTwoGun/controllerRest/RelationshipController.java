package com.BeerTwoGun.controllerRest;

import com.BeerTwoGun.entity.Relationship;
import com.BeerTwoGun.service.RelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RelationService;

@RestController
@RequestMapping("/relationship")
public class RelationshipController {
    @Autowired
    private RelationshipService relationshipService;

    @PostMapping(path = {"/{head1id}"})
    public ResponseEntity<Relationship> create(@RequestBody Relationship relationship, @PathVariable(value = "head1id",required = false)Long head1id){
        relationshipService.create(relationship);
        return new  ResponseEntity<>(relationship, HttpStatus.OK);
    }

}
