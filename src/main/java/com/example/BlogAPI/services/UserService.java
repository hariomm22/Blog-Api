package com.example.BlogAPI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlogAPI.enitities.Post;
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
    	 
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
        if (updatedUser.getName() != null) {
            existingUser.setName(updatedUser.getName());
        }

        if (updatedUser.getEmail() != null) {
            existingUser.setEmail(updatedUser.getEmail());
        }
        if (updatedUser.getPassword() != null) {
            existingUser.setPassword(updatedUser.getPassword());
        }
        return userRepository.save(existingUser);
     }

     public User deleteUser(int id) {
         User user = userRepository.findById(id)
                 .orElseThrow(() -> new RuntimeException("User not found with id " + id));
        userRepository.deleteById(id);
        return user;
    }
}
