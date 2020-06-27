package com.BeerTwoGun.controller;


import com.BeerTwoGun.entity.Person;
import com.BeerTwoGun.entity.Node;
import com.BeerTwoGun.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tree")
public class NodeController {
    @Autowired
    private NodeService nodeService;

    @PostMapping
    public Node save(@RequestBody Node node){
        return nodeService.save(node);
    }

    @GetMapping
    public String getTreePage(Model model){
        model.addAttribute("person",new Person());
        return "/tree";
    }

}
