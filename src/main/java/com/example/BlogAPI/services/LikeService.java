package com.example.BlogAPI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlogAPI.enitities.Like;
import com.example.BlogAPI.enitities.Post;
import com.example.BlogAPI.enitities.User;
import com.example.BlogAPI.repositories.LikeRepository;
import com.example.BlogAPI.repositories.PostRepository;
import com.example.BlogAPI.repositories.UserRepository;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;
    
    @Autowired
    private PostRepository postRepository;
    
    @Autowired
    private UserRepository userRepository;

    /**
     * Creates a like for a given post and user.
     * @param postId the ID of the post to like.
     * @param userId the ID of the user who likes the post.
     * @return the created Like object.
     */
    public Like createLike(int postId, int userId) {
        // Fetch the post and user from their repositories
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found with id " + postId));
        
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id " + userId));
        
        // Check if this user has already liked the post to prevent duplicate likes
        if (likeRepository.existsByPostAndUser(post, user)) {
            throw new RuntimeException("User has already liked this post.");
        }
        
        // Create and save the like
        Like like = new Like();
        like.setPost(post);
        like.setUser(user);
        return likeRepository.save(like);
    }

    /**
     * Deletes a Like by its ID.
     * @param likeId the ID of the Like to delete.
     */
    public void deleteLike(int likeId,int userId) { 
        
        
        Like existingLink = likeRepository.findById(likeId)
                .orElseThrow(() -> new RuntimeException("Like not found with id " + likeId));
         if(existingLink.getUser().getId()!=userId) {
             throw new IllegalArgumentException("User is not permitted to perform this operation on Like ID: " + userId);
        }
         likeRepository.deleteById(likeId);
        
    }

    /**
     * Retrieves all likes.
     * @return list of all Like objects.
     */
    public List<Like> getAllLikes() {
        return likeRepository.findAll();
    }

    // add a method to delete a like by both postId and userId.
//    public void deleteLikeByPostAndUser(int postId, int userId) {
//        Post post = postRepository.findById(postId)
//                .orElseThrow(() -> new RuntimeException("Post not found with id " + postId));
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found with id " + userId));
//        
//        Like like = likeRepository.findByPostAndUser(post, user)
//                .orElseThrow(() -> new RuntimeException("Like not found for post id " + postId + " and user id " + userId));
//        likeRepository.delete(like);
//    }
    
    public long getTotalLikesForPost(int postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found with id " + postId));
        return likeRepository.countByPost(post);
    }
}
