# Sweet-Shop-Management-System


The Sweet Shop Management System is a backend REST API built using Spring Boot to manage sweets, users, and inventory operations for a sweet shop.
The application follows REST principles, implements JWT-based authentication, role-based authorization, and uses PostgreSQL as the database.
The project is fully Dockerized and deployed on Render.

Features

User registration and login
JWT-based authentication
Role-based authorization (USER, ADMIN)
Sweet management (create, update, delete, search)
Inventory management (purchase and restock)
Secure API endpoints
PostgreSQL database integration
Docker containerization
Environment-based configuration
RESTful API design

Tech Stack

Language: Java 17
Framework: Spring Boot 3
Security: Spring Security, JWT
ORM: Spring Data JPA (Hibernate)
Database: PostgreSQL
Build Tool: Maven
Containerization: Docker

Project Structure
src/main/java
 ├── controller
 ├── service
 ├── repositories
 ├── entities
 ├── dto
 └── config

Environment Variables - The application uses environment variables for configuration and security.

DB_URL=jdbc:postgresql://<hostname>:5432/<database_name>
DB_USERNAME=<database_username>
DB_PASSWORD=<database_password>

JWT_SECRET_KEY=<your_jwt_secret>
JWT_EXPIRATION=<expiration_time_in_ms>
JWT_REFRESH_EXPIRATION=<refresh_expiration_time_in_ms>

Running the Application Locally
Using Maven
mvn clean package
mvn spring-boot:run

Using Docker
docker build -t sweet-shop .
docker run -p 8081:8080 sweet-shop


The application will be available at:

http://localhost:8080

API Overview

Auth APIs
Register user
Login user (JWT token generation)
Sweet APIs
Create sweet
Update sweet
Delete sweet (Admin only)
Search sweets
Inventory APIs
Purchase sweet
Restock sweet (Admin only)

All protected endpoints require a valid JWT token.



Environment variables are configured through Render’s dashboard.

My AI Usage
AI Tools Used

ChatGPT

How I Used AI

Used ChatGPT to quickly refactor and rename API endpoints for consistency.
Used ChatGPT to assist in debugging errors related to Spring Boot, Hibernate, Docker, and Render deployment.
Used ChatGPT to validate business logic for inventory operations such as purchasing and restocking sweets.
Used ChatGPT as a learning and clarification tool to understand error logs and configuration issues.

What AI Did Not Do

AI did not design the overall system architecture.
AI did not write the entire project code.
All AI-generated suggestions were reviewed, modified, and manually implemented.
Reflection on AI Impact

AI helped improve development speed and reduced debugging time by providing quick explanations and suggestions.
It acted as a support tool, not a replacement for understanding or implementing the project.
The core logic, structure, and final implementation remain my own.

Author

Abhishek
Backend Developer
Java | Spring Boot | Docker | PostgreSQL
