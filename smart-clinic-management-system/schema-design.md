# Smart Clinic Database Schema Design

This document describes the MySQL database schema for the Smart Clinic system.

---

## Doctors Table

Stores doctor information.

```sql
CREATE TABLE doctors (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    specialization VARCHAR(100),
    phone VARCHAR(15),
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);
