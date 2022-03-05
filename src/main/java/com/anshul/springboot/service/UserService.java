package com.anshul.springboot.service;

import com.anshul.springboot.entity.User;

import java.util.HashMap;
import java.util.List;

public interface UserService {
    public User saveNewUser(User user);

    public List<User> getUsers();

    public User payBack(String user, Double payBack);

    public List<User> userCreditLimit();

    public HashMap<String, Double> getDues(String userName);
}
