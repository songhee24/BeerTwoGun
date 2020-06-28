package com.BeerTwoGun.service.serviceTypes.typesImplementation;

import com.BeerTwoGun.entity.typesEntity.RelationshipType;
import com.BeerTwoGun.repository.repoTypes.RelationshipTypeRepository;
import com.BeerTwoGun.service.serviceTypes.RelationshipTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationshipTypeServiceImpl implements RelationshipTypeService {
    @Autowired
    private RelationshipTypeRepository relationshipTypeRepository;

    @Override
    public RelationshipType save(RelationshipType item) {
        return relationshipTypeRepository.save(item);
    }

    @Override
    public List<RelationshipType> findAll() {
        return relationshipTypeRepository.findAll();
    }

    @Override
    public RelationshipType findById(Long id) {
        return relationshipTypeRepository.findById(id).orElse(new RelationshipType());
    }

    @Override
    public boolean delete(Long id) {
        if (relationshipTypeRepository.findById(id).isPresent()){
            relationshipTypeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
