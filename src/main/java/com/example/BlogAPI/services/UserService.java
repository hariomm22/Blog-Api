package com.example.BlogAPI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlogAPI.enitities.User;
import com.example.BlogAPI.repositories.UserRepository;
 
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    
     public User createUser(User user) {
        return userRepository.save(user);
    }

     public User getUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

     
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

     public User updateUser(int id, User updatedUser) {
        User user = getUserById(id);
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());
        return userRepository.save(user);
    }

     public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
