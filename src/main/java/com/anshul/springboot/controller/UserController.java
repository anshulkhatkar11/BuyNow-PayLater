package com.anshul.springboot.controller;

import com.anshul.springboot.entity.User;
import com.anshul.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping("/newUser")
    public User saveNewUser(@RequestBody User user){
        return userService.saveNewUser(user);
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/user/{user}/{payBack}")
    public User payBackAmount(@PathVariable("user") String user,@PathVariable("payBack") Double payBack){
        return userService.payBack(user,payBack);
    }

    @GetMapping("/usersAtCreditLimit")
    public List<User> userCreditLimit(){
        return userService.userCreditLimit();
    }

    @GetMapping("/user/{user}")
    public HashMap<String,Double> getDues(@PathVariable("user") String userName){
        return userService.getDues(userName);
    }
}
