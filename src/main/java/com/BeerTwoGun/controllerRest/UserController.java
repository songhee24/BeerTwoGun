package com.BeerTwoGun.controllerRest;

import com.BeerTwoGun.entity.User;
import com.BeerTwoGun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody User user){
        User userCreate =  userService.createUser(user);
        if (userCreate == null){
            try {
                return new ResponseEntity<>("username:" + user.getUsername() + " already have",HttpStatus.CONFLICT);
            } catch (Exception e) {
                return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>("user created", HttpStatus.OK);
    }

    @GetMapping
    public List<User> getAll(){
        return userService.findAll();
    }



}
