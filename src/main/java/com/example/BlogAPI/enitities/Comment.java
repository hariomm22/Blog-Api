package com.example.BlogAPI.enitities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String content;
	
	@ManyToOne(cascade=CascadeType.ALL)
	Post post;
	
	@ManyToOne(cascade=CascadeType.ALL)
	User user;
	
	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	@CreationTimestamp
	private LocalDateTime updatedAt;
	
	public Comment() {
		super();
	}

	public Comment(int id, String content, Post post, User user) {
		super();
		this.id = id;
		this.content = content;
		this.post = post;
		this.user = user;
	}
	
	
	
	

}
