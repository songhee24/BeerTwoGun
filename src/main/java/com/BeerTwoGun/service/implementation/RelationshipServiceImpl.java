package com.BeerTwoGun.service.implementation;

import com.BeerTwoGun.entity.Relationship;
import com.BeerTwoGun.repository.RelationshipsRepository;
import com.BeerTwoGun.service.RelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationshipServiceImpl implements RelationshipService {
    @Autowired
    private RelationshipsRepository relationshipsRepository;

    @Override
    public Relationship save(Relationship item) {
        return relationshipsRepository.save(item);
    }

    @Override
    public List<Relationship> findAll() {
        return relationshipsRepository.findAll();
    }

    @Override
    public Relationship findById(Long id) {
        return relationshipsRepository.findById(id).orElse(new Relationship());
    }

    @Override
    public boolean delete(Long id) {
        if (relationshipsRepository.findById(id).isPresent()){
            relationshipsRepository.deleteById(id);
            return true;
        }
        return false;
    }


    @Override
    public Relationship create(Relationship relationship) {
        return null;
    }
}
