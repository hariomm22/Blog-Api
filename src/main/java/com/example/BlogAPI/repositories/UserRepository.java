package com.example.BlogAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.BlogAPI.enitities.User;

// This is where we extend JpaRepository
public interface UserRepository extends JpaRepository<User, Integer> {
	
}
