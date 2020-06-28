package com.BeerTwoGun.service.serviceTypes.typesImplementation;

import com.BeerTwoGun.entity.typesEntity.OccupationType;
import com.BeerTwoGun.repository.repoTypes.OccupationTypeRepository;
import com.BeerTwoGun.service.serviceTypes.OccupationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OccupationTypeServiceImpl implements OccupationTypeService {
    @Autowired
    private OccupationTypeRepository occupationTypeRepository;
    @Override
    public OccupationType save(OccupationType item) {
        return occupationTypeRepository.save(item);
    }

    @Override
    public List<OccupationType> findAll() {
        return occupationTypeRepository.findAll();
    }

    @Override
    public OccupationType findById(Long id) {
        return occupationTypeRepository.findById(id).orElse(new OccupationType());
    }

    @Override
    public boolean delete(Long id) {
        if (occupationTypeRepository.findById(id).isPresent()){
            occupationTypeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
