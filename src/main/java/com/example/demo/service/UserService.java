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
    public User updateUser(Long id, User newUser){
        User existingUser = userRespository.findById(id)
                .orElseThrow(()->new RuntimeException("User Not Found"));

        existingUser.setName(newUser.getName());
        existingUser.setEmail(newUser.getEmail());
        existingUser.setPassword(newUser.getPassword());

        return userRespository.save(existingUser);
    }
    public String deleteUser(Long id) {
        Optional<User> user = userRespository.findById(id);
        if (user.isPresent()) {
            userRespository.deleteById(id);
            return "User deleted successfully";
        } else {
            return "User not found";
        }
    }

}
