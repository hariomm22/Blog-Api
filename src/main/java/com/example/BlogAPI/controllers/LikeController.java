package com.example.BlogAPI.controllers;

import com.example.BlogAPI.Utilies.ApiResponse;
import com.example.BlogAPI.enitities.Like;
import com.example.BlogAPI.enitities.Post;
import com.example.BlogAPI.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;

    /**
     * Create a like for a post by a user.
     */
    @PostMapping("user/{userId}/post/{postId}")
    public ResponseEntity<ApiResponse<Like>>  createLike(@PathVariable int postId, @PathVariable int userId) {
        Like like= likeService.createLike(postId, userId);
        ApiResponse<Like> response = new ApiResponse<>(true, "Liked post successfully", like);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Delete a like by its ID.
     */
    @DeleteMapping("/{likeId}/user/{userId}")
    public ResponseEntity<ApiResponse<Void>> deleteLike(@PathVariable int likeId,@PathVariable int userId) {
        likeService.deleteLike(likeId,userId);
        ApiResponse<Void> response = new ApiResponse<>(true, "unliked post successfully", null);
        return new ResponseEntity<>(response, HttpStatus.OK);  
    }

    /**
     * Get all likes.
     */
    @GetMapping
    public  ResponseEntity<ApiResponse<List<Like>>> getAllLikes() {
    	List<Like> likeList= likeService.getAllLikes();
        ApiResponse<List<Like>> response = new ApiResponse<>(true, "All Liskes fetched", likeList);
        return new ResponseEntity<>(response, HttpStatus.OK); 
    }

    /**
//     * Delete a like by post ID and user ID.
//     */
//    @DeleteMapping()
//    public void deleteLikeByPostAndUser(@RequestParam int postId, @RequestParam int userId) {
//        likeService.deleteLikeByPostAndUser(postId, userId);
//    }

    /**
     * Get total like count for a post.
     */
    @GetMapping("/count/post/{postId}")
    public ResponseEntity<ApiResponse<Long>>  getTotalLikesForPost(@PathVariable int postId) {
        Long count= likeService.getTotalLikesForPost(postId);
        ApiResponse<Long> response = new ApiResponse<>(true, "User deleted successfully", count);
        return new ResponseEntity<>(response, HttpStatus.OK); 
    }
}
