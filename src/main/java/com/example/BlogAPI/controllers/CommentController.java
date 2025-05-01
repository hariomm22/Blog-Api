package com.example.BlogAPI.controllers;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.BlogAPI.Utilies.ApiResponse;
import com.example.BlogAPI.enitities.Comment;
import com.example.BlogAPI.services.CommentService;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<ApiResponse<Comment>>  addComment(@PathVariable int postId, @PathVariable int userId, @RequestParam String content) {
        Comment comment = commentService.addCommentToPost(postId, userId, content);
        ApiResponse<Comment> response = new ApiResponse<>(true, "Comment added successfully", comment);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/post/{postId}")
    public Page<Comment> getCommentsForPost(
            @PathVariable int postId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return commentService.getCommentsForPost(postId, page, size);
    }

    @DeleteMapping("/{commentId}/user/{UserId}")
    public ResponseEntity<ApiResponse<Comment>> deleteComment(@PathVariable int commentId, @PathVariable  int userId) {
        Comment comment= commentService.deleteComment(commentId, userId);
        ApiResponse<Comment> response = new ApiResponse<>(true, "Comment deleted successfully", comment);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
