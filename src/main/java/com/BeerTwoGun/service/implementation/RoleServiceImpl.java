package com.BeerTwoGun.service.implementation;

import com.BeerTwoGun.entity.Role;
import com.BeerTwoGun.repository.RoleRepository;
import com.BeerTwoGun.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role save(Role item) {
        return roleRepository.save(item);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElse(new Role());
    }

    @Override
    public boolean delete(Long id) {
        if (roleRepository.findById(id).isPresent()){
            roleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
