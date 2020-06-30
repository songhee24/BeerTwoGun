package com.BeerTwoGun.controllerRest;

import com.BeerTwoGun.entity.Family;
import com.BeerTwoGun.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/family")
public class FamilyController {
    @Autowired
    private FamilyService familyService;

    //    @RequestMapping(value = "/createFamily/{parentId}&&/{childId}",method = RequestMethod.POST)
//    @RequestMapping(path = {"" +
//            "/nodeTree/",
//            "/nodeTree/p/{parentId}",
//            "/nodeTree/c/{childId}",
//            "/nodeTree/{parentId}&&/{childId}"},method = RequestMethod.POST)

    @PostMapping(path = {"/{head1Id}&&/{head2Id}", "/h1/{head1Id}","/h2/{head2Id}"})
//    @RequestMapping(value = "family/{head1Id}/bar/{head2Id}",method = RequestMethod.POST)
    public ResponseEntity<String> create(@Valid @RequestBody Family family,
                                         @PathVariable(value = "head1Id",required = false) Long head1Id,
                                         @PathVariable(value = "head2Id", required = false) Long head2Id){
        System.err.println("head1 " + head1Id);
        System.err.println("head2 " + head2Id);
        if (head1Id == null && head2Id == null){
            return new ResponseEntity<>("any family head didn't found",HttpStatus.BAD_REQUEST);
        }
        familyService.create(family,head1Id,head2Id);
        return new  ResponseEntity<>("family: " + family.getFamilyName() + " created", HttpStatus.OK);
    }
}
