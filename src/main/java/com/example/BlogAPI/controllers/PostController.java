package com.example.BlogAPI.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.BlogAPI.Utilies.ApiResponse;
import com.example.BlogAPI.enitities.Post;
import com.example.BlogAPI.services.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Post>>>  getAllPosts() {
        List<Post> postList = postService.getAllPosts();
        ApiResponse<List<Post>> response = new ApiResponse<>(true, "All Posts fetched", postList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Post>>  getPostById(@PathVariable int id) {
        Post post= postService.getPostById(id);
        ApiResponse<Post> response = new ApiResponse<>(true, "Post fetched successfully", post);
        return new ResponseEntity<>(response, HttpStatus.OK);
        
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Post>>  createPost(@RequestBody Post post) {
        Post createdPost = postService.createPost(post);
        ApiResponse<Post> response = new ApiResponse<>(true, "New Post upload successfully", createdPost);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/user/{userId}")
    public ResponseEntity<ApiResponse<Post>> updatePost(@PathVariable int id, @PathVariable int userId, @RequestBody Post post) {
        Post updatedPost= postService.updatePost(id,userId,post);
        ApiResponse<Post> response = new ApiResponse<>(true, "User updated successfully", updatedPost);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}/user/{userId}")
    public ResponseEntity<ApiResponse<Post>> deletePost(@PathVariable int id, @PathVariable int userId) {
        Post deletedPost = postService.deletePost(id,userId);
        ApiResponse<Post> response = new ApiResponse<>(true, "Post deleted successfully",deletedPost);
        return new ResponseEntity<>(response, HttpStatus.OK); 
    }
}
