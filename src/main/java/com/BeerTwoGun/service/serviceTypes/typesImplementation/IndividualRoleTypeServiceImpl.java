package com.BeerTwoGun.service.serviceTypes.typesImplementation;

import com.BeerTwoGun.entity.typesEntity.IndividualRoleType;
import com.BeerTwoGun.repository.repoTypes.IndividualRoleTypeRepository;
import com.BeerTwoGun.service.serviceTypes.IndividualRoleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndividualRoleTypeServiceImpl implements IndividualRoleTypeService {
    @Autowired
    private IndividualRoleTypeRepository individualRoleTypeRepository;
    @Override
    public IndividualRoleType save(IndividualRoleType item) {
        return individualRoleTypeRepository.save(item);
    }

    @Override
    public List<IndividualRoleType> findAll() {
        return individualRoleTypeRepository.findAll();
    }

    @Override
    public IndividualRoleType findById(Long id) {
        return individualRoleTypeRepository.findById(id).orElse(new IndividualRoleType());
    }

    @Override
    public boolean delete(Long id) {
        if (individualRoleTypeRepository.findById(id).isPresent()){
            individualRoleTypeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
