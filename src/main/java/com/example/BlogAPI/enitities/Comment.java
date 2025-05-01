package com.example.BlogAPI.enitities;
 
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String content;
	
  
    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) 
	Post post;
	
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) 
	User user;
	
	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	@CreationTimestamp
	private LocalDateTime updatedAt;
	
	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Comment(int id, String content, Post post, User user) {
		super();
		this.id = id;
		this.content = content;
		this.post = post;
		this.user = user;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Post getPost() {
		return post;
	}


	public void setPost(Post post) {
		this.post = post;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
	
		

}
