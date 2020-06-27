package com.BeerTwoGun.service.implementation;

import com.BeerTwoGun.entity.Node;
import com.BeerTwoGun.entity.Person;
import com.BeerTwoGun.repository.NodeRepository;
import com.BeerTwoGun.service.PersonService;
import com.BeerTwoGun.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NodeServiceImpl implements NodeService {
    @Autowired
    private NodeRepository nodeRepository;

    @Autowired
    private PersonService personService;

    @Override
    public Node createTree(Node node, List<Long> parent_Id, List<Long> child_Id) {
//            List<Person> people = personService.findAll();
            List<Person> parents = new ArrayList<>();
            List<Person> children = new ArrayList<>();
            for (int i = 0; i< parent_Id.size();i++){
                parents.add(personService.findById(parent_Id.get(i)));
            }
            for (int i = 0; i< child_Id.size();i++){
                children.add(personService.findById(child_Id.get(i)));
            }



            node.setParentId(parents);
            node.setChildId(children);
            return save(node);
    }

    @Override
    public Node save(Node item) {
        return nodeRepository.save(item);
    }

    @Override
    public List<Node> findAll() {
        return nodeRepository.findAll();
    }

    @Override
    public Node findById(Long id) {
        return nodeRepository.findById(id).orElse(new Node());
    }

    @Override
    public boolean delete(Long id) {
        if(nodeRepository.findById(id).isPresent()){
            nodeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
