# 🛍️ User Service - E-commerce Microservice (Spring Boot + MongoDB + PostgreSQL)

This is a microservice for managing user registration, login, and profile data for an e-commerce application. It uses both **PostgreSQL** and **MongoDB** to demonstrate hybrid data storage, and includes **OAuth 2.0** security for authentication.

---

## 📦 Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA (PostgreSQL)
- Spring Data MongoDB
- Spring Security + OAuth 2.0
- Lombok
- Docker (optional)
- Maven

---

## 🧠 Architecture Overview

| Feature         | Storage     | Description |
|----------------|-------------|-------------|
| Credentials     | PostgreSQL  | Email, password hash, roles, timestamps |
| User Profile    | MongoDB     | Name, phone, addresses, preferences, social links |
| Authentication  | OAuth 2.0   | Secure login, token-based auth |

---

## 🔐 Features

- ✅ User registration
- ✅ Secure login with password or OAuth 2.0
- ✅ Dual-database model (SQL + NoSQL)
- ✅ Role-based access control
- 🚧 OAuth provider integrations (Google, GitHub, etc.) – *coming soon*

---

## 🗃️ Database Schema

### PostgreSQL – `users` table
```sql
id UUID PRIMARY KEY,
email VARCHAR UNIQUE,
password_hash VARCHAR,
created_at TIMESTAMP,
...
```
## 🗃️ MongoDB - user_profiles collection
```
{
  "_id": "uuid-matching-postgres",
  "firstName": "John",
  "preferences": {
    "newsletter": true
  },
  ...
}
```

## Docker Commands for PostgreSQL
1. `docker ps `-- to list all the running containers
2. `docker exec -it <container_name> psql -U username -d dbName` -- login to psql terminal
3. `\c dbName;` -- switch to database
4. `\q` -- exit terminal