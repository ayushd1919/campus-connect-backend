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
