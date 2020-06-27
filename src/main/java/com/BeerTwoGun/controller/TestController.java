package com.BeerTwoGun.controller;

import com.BeerTwoGun.entity.Node;
import com.BeerTwoGun.entity.Tree;
import com.BeerTwoGun.service.NodeService;
import com.BeerTwoGun.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class TestController {
    @Autowired
    private NodeService nodeService;

    @Autowired
    private TreeService treeService;

    @RequestMapping(value = "/nodeTree/{parentId}&&/{childId}",method = RequestMethod.POST)
    public Node create(@RequestBody Node node,
                       @PathVariable(value = "parentId",required = false)List<Long> parentId,
                       @PathVariable(value = "childId", required = false)List <Long> childId){
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
