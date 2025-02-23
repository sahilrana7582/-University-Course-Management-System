package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.respository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRespository userRespository;

    public User createUser(User user){
        return userRespository.save(user);
    }

    public List<User> getAllUsers(){
        return userRespository.findAll();
    }


}
