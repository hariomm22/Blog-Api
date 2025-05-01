package com.example.BlogAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.BlogAPI.enitities.User;
import com.example.BlogAPI.Utilies.ApiResponse;
import com.example.BlogAPI.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<ApiResponse<User>> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        ApiResponse<User> response = new ApiResponse<>(true, "User created successfully", createdUser);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> getUser(@PathVariable int id) {
        User user = userService.getUserById(id);
        ApiResponse<User> response = new ApiResponse<>(true, "User fetched successfully", user);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<User>>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        ApiResponse<List<User>> response = new ApiResponse<>(true, "All users fetched", users);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> updateUser(@PathVariable int id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        ApiResponse<User> response = new ApiResponse<>(true, "User updated successfully", updatedUser);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable int id) {
       userService.deleteUser(id);
        ApiResponse<Void> response = new ApiResponse<>(true, "User deleted successfully", null);
        return new ResponseEntity<>(response, HttpStatus.OK);  
    }
}
