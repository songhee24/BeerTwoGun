package com.BeerTwoGun.service.implementation;

import com.BeerTwoGun.entity.Parent;
import com.BeerTwoGun.repository.ParentRepository;
import com.BeerTwoGun.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentServiceImpl implements ParentService {
    @Autowired
    private ParentRepository parentRepository;
    @Override
    public Parent save(Parent item) {
        return parentRepository.save(item);
    }

    @Override
    public List<Parent> findAll() {
        return parentRepository.findAll();
    }

    @Override
    public Parent findById(Long id) {
        return parentRepository.findById(id).orElse(new Parent());
    }

    @Override
    public boolean delete(Long id) {
        if(parentRepository.findById(id).isPresent()){
            parentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
