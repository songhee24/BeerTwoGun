package com.BeerTwoGun.controller;

import com.BeerTwoGun.entity.Tree;
import com.BeerTwoGun.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/testTree")
public class TestController {
    @Autowired
    private TreeService treeService;
    @PostMapping("/{parentId}&&/{childId}")
    public Tree create(@RequestBody Tree tree,
                       @PathVariable(value = "parentId",required = false)List<Long> parentId,
                       @PathVariable(value = "childId", required = false)List <Long> childId){
        return treeService.createTree(tree,parentId,childId);
    }

    @GetMapping
    public List<Tree> getAll(){
        return treeService.findAll();
    }
}
