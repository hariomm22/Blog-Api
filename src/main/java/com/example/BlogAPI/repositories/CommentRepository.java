package com.example.BlogAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.BlogAPI.enitities.Comment;

// This is where we extend JpaRepository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
	
}
