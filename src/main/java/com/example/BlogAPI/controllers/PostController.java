package com.example.BlogAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.BlogAPI.enitities.Post;
import com.example.BlogAPI.services.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable int id) {
        return postService.getPostById(id);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @PutMapping("/{id}/user/{userId}")
    public Post updatePost(@PathVariable int id, @PathVariable int userId, @RequestBody Post post) {
        return postService.updatePost(id,userId,post);
    }

    @DeleteMapping("/{id}/user/{userId}")
    public void deletePost(@PathVariable int id, @PathVariable int userId) {
        postService.deletePost(id,userId);
    }
}
