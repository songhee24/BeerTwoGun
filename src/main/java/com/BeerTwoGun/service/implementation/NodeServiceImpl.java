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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NodeServiceImpl implements NodeService {
    @Autowired
    private NodeRepository nodeRepository;

    @Autowired
    private PersonService personService;

    @Override
    public Node createTree(Node node, List<Optional<Long>> parent_Id, List<Optional<Long>> child_Id) {
            List<Person> parents = new ArrayList<>();
            List<Person> children = new ArrayList<>();
//        List<Long> pId = parentId.stream().filter(Optional::isPresent).map(Optional::get).collect(Collectors.toList());
        if (!(parent_Id == null)){
            for (int p = 0; p < parent_Id.size();p++){
                if (parent_Id.get(p).isPresent()){
                    List<Long> pId = parent_Id.stream().filter(Optional::isPresent).map(Optional::get).collect(Collectors.toList());
                    parents.add(personService.findById(pId.get(p)));
                } else{
                    node.setParentId(parents);
                    return save(node);
                }
            }
        }
        if (!(child_Id == null)){
            for (int c = 0; c < child_Id.size();c++){
                if (child_Id.get(c).isPresent()){
                    List<Long> cId = child_Id.stream().filter(Optional::isPresent).map(Optional::get).collect(Collectors.toList());
                    children.add(personService.findById(cId.get(c)));
                } else {
                    node.setChildId(children);
                    return save(node);
                }
            }
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
