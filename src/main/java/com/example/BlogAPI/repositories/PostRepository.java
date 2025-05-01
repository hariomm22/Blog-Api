package com.example.BlogAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.BlogAPI.enitities.Post;

// This is where we extend JpaRepository
public interface PostRepository extends JpaRepository<Post, Integer> {
	
}
