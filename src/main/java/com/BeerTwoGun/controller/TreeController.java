package com.BeerTwoGun.controller;


import com.BeerTwoGun.entity.Tree;
import com.BeerTwoGun.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tree")
public class TreeController {
    @Autowired
    private TreeService treeService;

    @PostMapping
    public Tree save(@RequestBody Tree tree){
        return treeService.save(tree);
    }

    @PostMapping("/create")
    public Tree createTree(@RequestBody Tree tree){
        return treeService.createTree(tree);
    }
}
