package com.BeerTwoGun.controllerRest;

import com.BeerTwoGun.entity.Relationship;
import com.BeerTwoGun.service.RelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RelationService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/relationship")
public class RelationshipController {
    @Autowired
    private RelationshipService relationshipService;

    @PostMapping(path = {"/{head1id}&&/{familyId}"})
    public ResponseEntity<Relationship> create(@RequestBody Relationship relationship,
                                               @PathVariable(value = "head1id",required = false) List<Optional<Long>> head1id,
                                               @PathVariable(value = "familyId",required = false) List<Optional<Long>> familyId){
        Relationship relationshipFromCreated = relationshipService.create(relationship, head1id,familyId);
        if (relationshipFromCreated == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        relationshipService.create(relationship,head1id,familyId);
        return new  ResponseEntity<>(relationship, HttpStatus.OK);
    }

    @GetMapping
    public List<Relationship> getAll(){
        return relationshipService.findAll();
    }

}
