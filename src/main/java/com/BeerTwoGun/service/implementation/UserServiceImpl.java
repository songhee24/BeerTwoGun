package com.BeerTwoGun.service.implementation;

import com.BeerTwoGun.entity.Role;
import com.BeerTwoGun.entity.User;
import com.BeerTwoGun.repository.RoleRepository;
import com.BeerTwoGun.repository.UserRepository;
import com.BeerTwoGun.service.RoleService;
import com.BeerTwoGun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService,UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
        User userFromBd = findByUserName(user.getUsername());

        if (userFromBd != null) {
            System.out.println("username already have");
            return null;
        }

        Role role = roleService.save(Role.builder().id(1L).roleName("ROLE_USER").build());
        user.setRoles(Collections.singleton(role));

//        Set<Role> roles = new HashSet<>();
//        roles.add(roleService.findById(1L));
//        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection < ? extends GrantedAuthority> mapRolesToAuthorities(Collection< Role > roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .collect(Collectors.toList());
    }


        @Override
    public User login(User user) {
        User userFromBd =findByUserName(user.getUsername());
        System.out.println("LOG_user from bd: " + userFromBd);
        if (userFromBd == null) {
            return null;
        }
        if (
                user.getPassword().equals(userFromBd.getConfirmPassword())
        ) {
            return userFromBd;
        }
        return null;
    }
}
