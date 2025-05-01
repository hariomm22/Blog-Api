package com.example.BlogAPI.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.BlogAPI.enitities.Comment;
import com.example.BlogAPI.enitities.Post;
import com.example.BlogAPI.enitities.User;

// This is where we extend JpaRepository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Page<Comment> findByPost(Post post, Pageable pageable);
    Optional<Comment> findByIdAndUser(int id, User user);
	
}
