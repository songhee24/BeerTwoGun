package com.BeerTwoGun.controller;


import com.BeerTwoGun.entity.Person;
import com.BeerTwoGun.entity.Node;
import com.BeerTwoGun.service.NodeService;
import com.BeerTwoGun.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tree")
public class NodeController {
    @Autowired
    private NodeService nodeService;

    @Autowired
    private TreeService treeService;

    @PostMapping
    public Node save(@RequestBody Node node){
        return nodeService.save(node);
    }

//    @GetMapping
//    public String getTreePage(Model model){
//        model.addAttribute("person",new Person());
//        return "/tree";
//    }

    @GetMapping
    public String getTree(Model model){
        model.addAttribute("person",new Person());
        model.addAttribute("allTree",treeService.findAll());
        return "/tree";
    }

}
