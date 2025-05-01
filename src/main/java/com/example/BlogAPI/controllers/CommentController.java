package com.example.BlogAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.example.BlogAPI.enitities.Comment;
import com.example.BlogAPI.services.CommentService;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public Comment addComment(@PathVariable int postId, @PathVariable int userId, @RequestParam String content) {
        return commentService.addCommentToPost(postId, userId, content);
    }

    @GetMapping("/post/{postId}")
    public Page<Comment> getCommentsForPost(
            @PathVariable int postId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return commentService.getCommentsForPost(postId, page, size);
    }

    @DeleteMapping("/{commentId}/user/{UserId}")
    public String deleteComment(@PathVariable int commentId, @PathVariable  int userId) {
        return commentService.deleteComment(commentId, userId);
    }
}
