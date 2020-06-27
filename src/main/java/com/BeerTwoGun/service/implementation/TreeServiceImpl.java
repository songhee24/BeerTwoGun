package com.BeerTwoGun.service.implementation;

import com.BeerTwoGun.entity.Node;
import com.BeerTwoGun.entity.Tree;
import com.BeerTwoGun.repository.TreeRepository;
import com.BeerTwoGun.service.NodeService;
import com.BeerTwoGun.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TreeServiceImpl implements TreeService {
    @Autowired
    private TreeRepository treeRepository;

    @Autowired
    private NodeService nodeService;

    @Override
    public Tree save(Tree item) {
        return treeRepository.save(item);
    }

    @Override
    public List<Tree> findAll() {
        return treeRepository.findAll();
    }

    @Override
    public Tree findById(Long id) {
        return treeRepository.findById(id).orElse(new Tree());
    }

    @Override
    public boolean delete(Long id) {
        if (treeRepository.findById(id).isPresent()){
            treeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Tree createTree(Tree tree, List<Long> nodeId) {
        List<Node> nodes = new ArrayList<>();
        for (int i =0;i<nodeId.size();i++){
             nodes.add(nodeService.findById(nodeId.get(i)));
        }
        tree.setNodeList(nodes);
        return save(tree);
    }
}
