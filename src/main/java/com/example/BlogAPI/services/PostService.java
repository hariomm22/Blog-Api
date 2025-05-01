package com.example.BlogAPI.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlogAPI.enitities.Post;
import com.example.BlogAPI.enitities.User;
import com.example.BlogAPI.repositories.PostRepository;
import com.example.BlogAPI.repositories.UserRepository;


@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    
    @Autowired
    private UserRepository userRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(int id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found with id " + id));
    }

    public Post createPost(Post post) {
        if (post.getUser() != null && post.getUser().getId() > 0) {
            User user = userRepository.findById(post.getUser().getId())
                    .orElseThrow(() -> new RuntimeException("User not found with id " + post.getUser().getId()));
            post.setUser(user); // set managed user entity
        } else {
            throw new RuntimeException("User ID is required to create a post.");
        }

        return postRepository.save(post);
    }

    public Post updatePost(int id,int userId, Post updatedPost) {
        Post existingPost = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found with id " + id));
         if(existingPost.getUser().getId()!=userId) {
             throw new IllegalArgumentException("User is not permitted to perform this operation on post ID: " + id);
        }
        if (updatedPost.getTitle() != null) {
            existingPost.setTitle(updatedPost.getTitle());
        }

        if (updatedPost.getContent() != null) {
            existingPost.setContent(updatedPost.getContent());
        }
        return postRepository.save(existingPost);
    }

    public Post deletePost(int id,int userId) {
        Post existingPost = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found with id " + id));
         if(existingPost.getUser().getId()!=userId) {
             throw new IllegalArgumentException("User is not permitted to perform this operation on post ID: " + id);
        }
        postRepository.deleteById(id);
        
        return existingPost;
    }
}
