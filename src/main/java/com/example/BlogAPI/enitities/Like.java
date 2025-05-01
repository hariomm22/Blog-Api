package com.example.BlogAPI.enitities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
 


@Entity
@Table(
    name = "likes",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"post_id", "user_id"})}
)
public class Like {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
 
	
//    @ManyToOne(optional = false, cascade = CascadeType.REMOVE)
//    @JoinColumn(name = "post_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)     // old one
	@ManyToOne
	@JoinColumn(name = "post_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE) 
	Post post;
	
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) 
	User user;
	
//    @ManyToOne
//	@JoinColumn(name = "user_id", nullable = false)   Take from post entity
//	@OnDelete(action = OnDeleteAction.CASCADE) 
    
	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;

	public Like() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Like(int id , Post post, com.example.BlogAPI.enitities.User user) {
		super();
		this.id = id;
		this.post = post;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	
	
	
}
