package com.BeerTwoGun.service.implementation;

import com.BeerTwoGun.entity.Person;
import com.BeerTwoGun.entity.Tree;
import com.BeerTwoGun.repository.TreeRepository;
import com.BeerTwoGun.service.PersonService;
import com.BeerTwoGun.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TreeServiceImpl implements TreeService {
    @Autowired
    private TreeRepository treeRepository;

    @Autowired
    private PersonService personService;

    @Override
    public Tree createTree(Tree tree,List<Long> parent_Id, List<Long> child_Id) {
//            List<Person> people = personService.findAll();
            List<Person> parents = new ArrayList<>();
            List<Person> children = new ArrayList<>();
            for (int i = 0; i< parent_Id.size();i++){
                parents.add(personService.findById(parent_Id.get(i)));
            }
            for (int i = 0; i< child_Id.size();i++){
                children.add(personService.findById(child_Id.get(i)));
            }



            tree.setParentId(parents);
            tree.setChildId(children);
            return save(tree);
    }

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
        if(treeRepository.findById(id).isPresent()){
            treeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
