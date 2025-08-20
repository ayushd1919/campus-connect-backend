# CampusConnect - Backend API

![Java](https://img.shields.io/badge/Java-17-blue) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen) ![MySQL](https://img.shields.io/badge/MySQL-8.0-orange) ![JWT](https://img.shields.io/badge/Security-JWT-blueviolet)

This repository contains the backend server for **CampusConnect**, a comprehensive engineering college management platform. Built with Spring Boot, it provides a secure, role-based REST API to manage students, faculty, timetables, and academic data.

---

##  Key Features Implemented

* **Authentication & Security:** Secure user registration and login system using JSON Web Tokens (JWT).
* **Role-Based Access Control (RBAC):** Differentiated permissions for `ADMIN`, `HOD`, `FACULTY`, and `STUDENT` roles.
* **Admin Dashboard API:** Endpoints for managing departments, subjects, rooms, and faculty accounts.
* **HOD Dashboard API:** Endpoints for HODs to create and manage exam timetables for their specific department.
* **Academic Structure:** A detailed database schema to handle a complex curriculum, including department-specific core subjects and elective tracks (DLOCs & ILOCs).

---

## Tech Stack

* **Framework:** Spring Boot 3
* **Language:** Java 17
* **Database:** MySQL 8
* **Security:** Spring Security, JSON Web Tokens (JWT)
* **Data Access:** Spring Data JPA (Hibernate)
* **Build Tool:** Maven

---

## Setup and Installation

### Prerequisites

* Java JDK 17 or later
* Apache Maven
* MySQL Server 8

### 1. Database Setup

1.  Open your MySQL client and create a new database.
    ```sql
    CREATE DATABASE campusconnect;
    ```
2.  The application will automatically create all the necessary tables when it first runs.

### 2. Application Configuration

1.  Open the `src/main/resources/application.properties` file.
2.  Update the following properties to match your local MySQL setup:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/campusconnect
    spring.datasource.username=YOUR_MYSQL_USERNAME
    spring.datasource.password=YOUR_MYSQL_PASSWORD
    ```

### 3. Running the Application

1.  Navigate to the root of the project folder in your terminal.
2.  Build the project using Maven:
    ```bash
    mvn clean install
    ```
3.  Run the application:
    ```bash
    java -jar target/campus-connect-0.0.1-SNAPSHOT.jar
    ```
The server will start on `http://localhost:8080` (or `8081` if you've changed the port).
