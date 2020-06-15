package com.BeerTwoGun.service.implementation;

import com.BeerTwoGun.entity.Role;
import com.BeerTwoGun.entity.User;
import com.BeerTwoGun.repository.UserRepository;
import com.BeerTwoGun.service.RoleService;
import com.BeerTwoGun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Override
    public User save(User item) {
        return userRepository.save(item);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(new User());
    }

    @Override
    public boolean delete(Long id) {
        if (userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User createUser(User user) {
        User userFromBd = findByUserName(user.getUserName());

        if (userFromBd != null) {
            System.out.println("username already have");
            return null;
        }

        Role role = roleService.save(Role.builder().id(1L).roleName("ROLE_USER").build());
        user.setRoles(Collections.singleton(role));

        return save(user);
    }
}
