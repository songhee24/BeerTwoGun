package com.BeerTwoGun.controller;


import com.BeerTwoGun.entity.Person;
import com.BeerTwoGun.entity.Tree;
import com.BeerTwoGun.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tree")
public class TreeController {
    @Autowired
    private TreeService treeService;

    @PostMapping
    public Tree save(@RequestBody Tree tree){
        return treeService.save(tree);
    }

    @GetMapping
    public String getTreePage(Model model){
        model.addAttribute("person",new Person());
        return "/tree";
    }

}
