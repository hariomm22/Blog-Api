# Blog API - Spring Boot Project

A RESTful Blog API built with Spring Boot, designed for managing users, posts, comments, and likes. This project demonstrates layered architecture (Controller → Service → Repository), consistent API responses, and basic error handling.

---

## Technologies Used

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL or H2 (configurable)
- Maven
- Postman (for testing APIs)

---

## Features

- Create, Read, Update, and Delete (CRUD) for Users and Posts
- Comment on posts (Add, View with Pagination, Delete)
- Like/Unlike posts
- API response format with status, message, and data
- Proper HTTP status codes and error handling
- Unique constraints (e.g., one like per user per post)
- Three-layer architecture: Controller → Service → Repository

---

## Project Structure
com.example.BlogAPI ├── controllers ├── entities ├── repositories ├── services ├── exceptions └── payloads (for ApiResponse)

##API Endpoint
#user
| Method | Endpoint              | Description                  |
|--------|-----------------------|------------------------------|
| GET    | `/api/users`          | List all users               |
| GET    | `/api/users/{id}`     | Get user by ID               |
| POST   | `/api/users`          | Create new user              |
| PUT    | `/api/users/{id}`     | Update user by ID            |
| DELETE | `/api/users/{id}`     | Delete user by ID            |

#Post
| Method | Endpoint              | Description                  |
|--------|-----------------------|------------------------------|
| GET    | `/api/posts`          | List all posts               |
| GET    | `/api/posts/{id}`     | Get post by ID               |
| POST   | `/api/posts`          | Create new post              |
| PUT    | `/api/posts/{post_id}/user/{user_id}`     | Update post by ID            |
| DELETE | `/api/posts/{post_id}/user/{user_id}`     | Delete post by ID            |

#Like
| Method | Endpoint                        | Description                     |
|--------|----------------------------------|---------------------------------|
| POST   | `/api/posts/{postId}/likes/{userId}` | Like a post                 |
| DELETE | `/api/posts/{postId}/likes/{userId}` | Unlike a post               |
| GET    | `/api/posts/{postId}/likes/count`     | Get total likes for a post |

#Comment
| Method | Endpoint                                 | Description                     |
|--------|------------------------------------------|---------------------------------|
| POST   | `/api/posts/{postId}/comments`           | Add a comment to a post         |
| GET    | `/api/posts/{postId}/comments?page=0&size=5` | List comments (paginated) |
| DELETE | `/api/comments/{commentId}/users/{userId}` | Delete comment by user & ID     |

#Author
Developed by Hariom

Contact: hariommahajan686@gmail.com






