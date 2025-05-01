package com.example.BlogAPI.services;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.example.BlogAPI.enitities.Comment;
import com.example.BlogAPI.enitities.Post;
import com.example.BlogAPI.enitities.User;
import com.example.BlogAPI.repositories.CommentRepository;
import com.example.BlogAPI.repositories.PostRepository;
import com.example.BlogAPI.repositories.UserRepository;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public Comment addCommentToPost(int postId, int userId, String content) {
        Post post = postRepository.findById(postId)
            .orElseThrow(() -> new RuntimeException("Post not found"));
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));

        Comment comment = new Comment();
        comment.setContent(content);
        comment.setPost(post);
        comment.setUser(user);

        return commentRepository.save(comment);
    }

    public Page<Comment> getCommentsForPost(int postId, int page, int size) {
        Post post = postRepository.findById(postId)
            .orElseThrow(() -> new RuntimeException("Post not found"));
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        return commentRepository.findByPost(post, pageable);
    }

    public Comment deleteComment(int commentId, int userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));

        Comment comment = commentRepository.findByIdAndUser(commentId, user)
            .orElseThrow(() -> new RuntimeException("Comment not found or not owned by user"));

        commentRepository.delete(comment);
        
        return comment;
    }
}
