package com.BeerTwoGun.service.implementation;

import com.BeerTwoGun.entity.Occupation;
import com.BeerTwoGun.repository.OccupationRepository;
import com.BeerTwoGun.service.OccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OccupationServiceImpl implements OccupationService {
    @Autowired
    private OccupationRepository occupationRepository;
    @Override
    public Occupation save(Occupation item) {
        return occupationRepository.save(item);
    }

    @Override
    public List<Occupation> findAll() {
        return occupationRepository.findAll();
    }

    @Override
    public Occupation findById(Long id) {
        return occupationRepository.findById(id).orElse(new Occupation());
    }

    @Override
    public boolean delete(Long id) {
        if (occupationRepository.findById(id).isPresent()){
            occupationRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
