package com.BeerTwoGun.service.implementation;

import com.BeerTwoGun.entity.User;
import com.BeerTwoGun.repository.UserRepository;
import com.BeerTwoGun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
      @Autowired
      private UserRepository userRepository;

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
}

