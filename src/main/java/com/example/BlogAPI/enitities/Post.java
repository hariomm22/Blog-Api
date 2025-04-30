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
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	int title;
	String content;
	
	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	@CreationTimestamp
	private LocalDateTime updatedAt;
	
	@ManyToOne(cascade=CascadeType.ALL)
	User user;
	
	public Post() {
		super();
	}

	public Post(int id, int title, String content, User user) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTitle() {
		return title;
	}

	public void setTitle(int title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", user=" + user + "]";
	}
	
	

}
