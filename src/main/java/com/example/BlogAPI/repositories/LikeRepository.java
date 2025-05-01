package com.example.BlogAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.BlogAPI.enitities.Like;

// This is where we extend JpaRepository
public interface LikeRepository extends JpaRepository<Like, Integer> {
	
}
