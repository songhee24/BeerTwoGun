package com.BeerTwoGun.controller;

import com.BeerTwoGun.entity.Node;
import com.BeerTwoGun.entity.Tree;
import com.BeerTwoGun.service.NodeService;
import com.BeerTwoGun.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController

public class TestController {
    @Autowired
    private NodeService nodeService;

    @Autowired
    private TreeService treeService;

    @PostMapping
    public Node save(Node node){
        return node;
    }

//    @RequestMapping(value = "/nodeTree/{parentId}&&/{childId}",method = RequestMethod.POST)
    @RequestMapping(path = {"" +
            "/nodeTree/",
            "/nodeTree/p/{parentId}",
            "/nodeTree/c/{childId}",
            "/nodeTree/{parentId}&&/{childId}"},method = RequestMethod.POST)
    public Node create(@RequestBody Node node,
                       @PathVariable(value = "parentId",required = false) List<Optional<Long>> parentId,
                       @PathVariable(value = "childId", required = false) List<Optional<Long>> childId){
        return nodeService.createTree(node,parentId,childId);
    }

    @CrossOrigin
    @RequestMapping(value = "/getTree",method = RequestMethod.GET)
    public List<Tree> getAll(){
        return treeService.findAll();
    }


    @RequestMapping(value = "/tree/{nodeId}",method = RequestMethod.POST)
    public Tree create(@RequestBody Tree tree,
                       @PathVariable(value = "nodeId",required = false)List<Long> nodeId){
        return treeService.createTree(tree, nodeId);
    }


}
