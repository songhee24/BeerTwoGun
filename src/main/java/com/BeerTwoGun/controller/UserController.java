package com.BeerTwoGun.controller;

import com.BeerTwoGun.entity.User;
import com.BeerTwoGun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;


//    @GetMapping("login")
//    public String getLoginPage(Model model){
//        model.addAttribute("user",new User());
//        return "/login";
//    }


    @GetMapping("register")
    public String getRegisterPage(Model model){
        model.addAttribute("user",new User());
        return "login-page/register";
    }

//    @PostMapping("check")
//    public String checkPersonInfo(@Valid User user,BindingResult bindingResult){
//        if (bindingResult.hasErrors()){
//            return "";
//        }
//        return "redirect:/user/login-page/register";
//    }

    @PostMapping("create")
    public String crateUser(@Valid User user ,BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            System.out.println("BINDING RESULT ERROR");
            List<FieldError> errors = bindingResult.getFieldErrors();

            for (FieldError e: errors){
                System.out.println("\"Error on object ---> "+e.getObjectName()+" on field ---> "+e.getField()+". Message ---> "+e.getDefaultMessage());
            }

            return "login-page/register";
        }

        userService.createUser(user);
        return "/login";
    }



//    @PostMapping("login")
//    public String loginUser(@ModelAttribute User user, HttpSession session, String error, String logout, Model model){
//        userService.login(user);
//        return "home-page/home";
//    }

    @PostMapping
    public User save(@RequestBody User user){
        return userService.save(user);
    }


}
