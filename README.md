
# 🍬 Sweet Shop Management System

> A robust backend REST API built using Spring Boot to manage sweets, users, and inventory operations.

The **Sweet Shop Management System** is a backend application designed to streamline operations for a sweet shop. It follows **REST principles**, implements secure **JWT-based authentication**, enforces **role-based authorization**, and utilizes **PostgreSQL** for data persistence. The project is fully containerized using **Docker** and deployed on **Render**.

-----

## 🚀 Features

  * **User Management:** Secure user registration and login.
  * **Security:** JWT-based authentication (Stateless) & Role-based authorization (`USER`, `ADMIN`).
  * **Sweet Catalog:** Create, update, delete, and search for sweets.
  * **Inventory Control:** Manage stock levels through purchase and restock workflows.
  * **Database:** Persistent storage using PostgreSQL.
  * **DevOps:** Docker containerization and environment-based configuration.
  * **Design:** Clean RESTful API architecture.

-----

## 🛠️ Tech Stack

| Category | Technology |
| :--- | :--- |
| **Language** | Java 17 |
| **Framework** | Spring Boot 3 |
| **Security** | Spring Security, JWT |
| **Database** | PostgreSQL |
| **ORM** | Spring Data JPA (Hibernate) |
| **Build Tool** | Maven |
| **Containerization** | Docker |
| **Deployment** | Render |

-----

## 📂 Project Structure

```text
src/main/java
 ├── config          # Security & App configuration
 ├── controller      # REST API endpoints
 ├── dto             # Data Transfer Objects
 ├── entities        # JPA Entities (Database models)
 ├── repositories    # Data Access Layer
 └── service         # Business Logic
```

-----

## ⚙️ Configuration

The application uses environment variables for security and database connection. You must configure these in your local `.env` file or your deployment platform variables.

```properties
# Database Configuration
DB_URL=jdbc:postgresql://<hostname>:5432/<database_name>
DB_USERNAME=<database_username>
DB_PASSWORD=<database_password>

# JWT Security Configuration
JWT_SECRET_KEY=<your_secure_jwt_secret>
JWT_EXPIRATION=86400000        # e.g., 24 hours in ms
JWT_REFRESH_EXPIRATION=604800000 # e.g., 7 days in ms
```

-----

## 🏃‍♂️ Running the Application Locally

### Prerequisites

  * Java 17+
  * Maven
  * Docker (Optional)

### Option 1: Using Maven

```bash
# Clean and package the application
mvn clean package

# Run the application
mvn spring-boot:run
```

### Option 2: Using Docker

```bash
# Build the Docker image
docker build -t sweet-shop .

# Run the container (Mapping port 8080 to 8081)
docker run -p 8081:8080 sweet-shop
```

The application will be accessible at: `http://localhost:8080` (or `8081` if using Docker command above).

-----

## 🔌 API Overview

All protected endpoints require a valid **Bearer Token** in the `Authorization` header.

### 🔐 Auth APIs

| Method | Endpoint | Description | Access |
| :--- | :--- | :--- | :--- |
| `POST` | `/api/auth/register` | Register a new user | Public |
| `POST` | `/api/auth/login` | Login & generate JWT | Public |

### 🍭 Sweet APIs

| Method | Endpoint | Description | Access |
| :--- | :--- | :--- | :--- |
| `POST` | `/api/sweets` | Create a new sweet | Admin |
| `PUT` | `/api/sweets/{id}` | Update sweet details | Admin |
| `DELETE` | `/api/sweets/{id}` | Delete a sweet | Admin |
| `GET` | `/api/sweets/search` | Search sweets | Public/User |

### 📦 Inventory APIs

| Method | Endpoint | Description | Access |
| :--- | :--- | :--- | :--- |
| `POST` | `/api/inventory/purchase` | Purchase sweet (reduce stock) | User |
| `POST` | `/api/inventory/restock` | Restock sweet (increase stock) | Admin |

-----

## 🤖 AI Usage Disclosure

Transparency regarding the use of AI tools in this project.

**AI Tools Used:** ChatGPT

**How AI Was Used:**

1.  **Refactoring:** Quickly refactored and renamed API endpoints to ensure RESTful consistency.
2.  **Debugging:** Assisted in troubleshooting specific errors related to Spring Boot configurations, Hibernate mappings, and Docker deployment on Render.
3.  **Validation:** Used to validate the logic flow for inventory operations (purchasing vs. restocking).
4.  **Learning:** Served as a clarification tool to better understand specific error logs.

**What AI Did Not Do:**

  * AI did **not** design the system architecture.
  * AI did **not** write the core project code from scratch.
  * All suggestions were manually reviewed, tested, and implemented by the author.

**Reflection:**

> AI significantly improved development speed and reduced debugging time. However, it acted solely as a support tool. The core logic, structure, and final implementation remain the work of the author.

-----

## 👨‍💻 Author

**Abhishek**
*Backend Developer*

  * **Skills:** Java, Spring Boot, Docker, PostgreSQL
  * **Focus:** Building scalable and secure backend systems.
