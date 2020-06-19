package com.BeerTwoGun.service.implementation;

import com.BeerTwoGun.entity.Person;
import com.BeerTwoGun.entity.Tree;
import com.BeerTwoGun.repository.TreeRepository;
import com.BeerTwoGun.service.PersonService;
import com.BeerTwoGun.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreeServiceImpl implements TreeService {
    @Autowired
    private TreeRepository treeRepository;

    @Autowired
    private PersonService personService;

    @Override
    public Tree createTree(Tree tree) {
//        Person knotParentId = personService.findById(tree.getParentId().getId());
//        Person knotChildId = personService.findById(tree.getChildId().getId());



//            tree.setParentId(knotParentId);
//            tree.setChildId(knotChildId);
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
