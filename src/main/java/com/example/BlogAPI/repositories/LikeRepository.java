package com.example.BlogAPI.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.BlogAPI.enitities.Like;
import com.example.BlogAPI.enitities.Post;
import com.example.BlogAPI.enitities.User;

// This is where we extend JpaRepository
public interface LikeRepository extends JpaRepository<Like, Integer> {
    boolean existsByPostAndUser(Post post, User user);
    
    Optional<Like> findByPostAndUser(Post post, User user);
    
    long countByPost(Post post);
	
}
