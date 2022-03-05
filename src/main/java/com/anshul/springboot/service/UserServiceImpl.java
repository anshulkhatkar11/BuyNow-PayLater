package com.anshul.springboot.service;

import com.anshul.springboot.entity.User;
import com.anshul.springboot.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    public UserRepo userRepo;

    @Override
    public User saveNewUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public User payBack(String userName, Double payBack) {
        User user=userRepo.findByUserNameIgnoreCase(userName);
        user.setDues(user.getDues()-payBack);
        userRepo.save(user);
        return user;
    }

    @Override
    public List<User> userCreditLimit() {
        List<User> userlist=new ArrayList<>();
        List<User> users=userRepo.findAll();
        for(User u:users){
            if(u.getDues()>=u.getCreditLimit())
                userlist.add(u);
        }
        return userlist;
    }

    @Override
    public HashMap<String, Double> getDues(String userName) {
        HashMap<String,Double> hm=new HashMap<>();
        User user=userRepo.findByUserNameIgnoreCase(userName);
        hm.put(userName,user.getDues());
        return hm;
    }


}
