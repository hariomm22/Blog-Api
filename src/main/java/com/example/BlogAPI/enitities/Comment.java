package com.example.BlogAPI.enitities;
 
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
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
	
    @ManyToOne(optional = false, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "post_id", nullable = false)
	Post post;
	
    @ManyToOne(optional = false, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", nullable = false)
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
	
	
	
	
		

}
