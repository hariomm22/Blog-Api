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
import jakarta.persistence.Table;

@Entity
@Table(name ="likes")
public class like {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	long likeCount;
	
	@ManyToOne(cascade=CascadeType.ALL)
	Post post;
	
	@ManyToOne(cascade=CascadeType.ALL)
	User User;
	
	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	

	public like() {
		super();
		// TODO Auto-generated constructor stub
	}

	public like(int id, long likeCount, Post postId, User user) {
		super();
		this.id = id;
		this.likeCount = likeCount;
		this.post= post;
		User= user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(long likeCount) {
		this.likeCount = likeCount;
	}

	public Post getPost() {
		return post;
	}

	public void setPostId(Post post) {
		this.post = post;
	}

	public User getUser() {
		return User;
	}

	public void setUserId(User user) {
		User = user;
	}
	
	
}
