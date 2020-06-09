package com.BeerTwoGun.controller;

import com.BeerTwoGun.entity.FamilyMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.BeerTwoGun.service.FamilyMemberIService;

@RestController
@RequestMapping("/member")
public class FamilyMemberController {
    @Autowired
    private FamilyMemberIService familyMemberIService;

    @PostMapping
    public FamilyMember save(@RequestBody  FamilyMember familyMember){
        return familyMemberIService.save(familyMember);
    }
}
