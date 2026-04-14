# 📌 Student Performance and Progress Tracker

## 📖 Project Overview

**Student Performance and Progress Tracker** is a Desktop-Based Java Application designed to efficiently manage and analyze students’ academic performance.

The system enables administrators or teachers to:

* Store student details
* Enter subject-wise marks
* Automatically calculate percentage & grades
* Track overall performance
* Export reports

This project is developed using **Core Java, JDBC, MySQL**, and is currently evolving with advanced features.

---

## 🎯 Objectives

* To digitize student academic records
* To automate percentage and grade calculation
* To provide structured data management using database
* To enable performance analysis and reporting
* To build a scalable system for future GUI integration

---

## 🛠️ Technologies Used

* **Java (Core Java)**
* **JDBC (Java Database Connectivity)**
* **MySQL Database**
* **MySQL Connector/J**
* **Git & GitHub**

*(GUI using Java Swing will be implemented in Phase 3)*

---

## 🏗️ Project Architecture

The project follows a **Layered Architecture (DAO Pattern)**:

### 🔹 Presentation Layer (Currently Console-Based)

* Menu-driven interface
* User interaction via terminal

### 🔹 Business Logic Layer

* Percentage Calculation
* Grade Calculation (A, B, C, Fail)
* Average Marks Calculation
* Topper Identification

### 🔹 Data Access Layer (DAO)

* `StudentDAO`
* `MarksDAO`
* `DBConnection`

### 🔹 Database Layer (MySQL)

* `student` table
* `marks` table

---

## 📊 Features (Phase 1 + Phase 2)

### ✅ Core Functionalities

* Add Student
* View Students
* Add Marks
* View Marks
* Calculate Average Marks
* Generate Performance Report

### 🚀 Advanced Functionalities (Phase 2)

* Update Marks
* Delete Student
* Find Topper
* Auto Grade System (A/B/C/Fail)
* Data Validation (numeric checks, empty fields)
* CSV Report Export 📄
* Structured & Modular Code (DAO-based)

---

## 📄 Report Export Feature

The system allows exporting student performance reports in **CSV format**, which can be opened in Excel.

### Includes:

* Student Name
* Subject-wise Marks
* Total Marks
* Percentage
* Grade

---

## 🗄️ Database Structure

### 📘 Student Table

* `student_id` (Primary Key)
* `name`
* `roll_no`
* `semester`

### 📗 Marks Table

* `student_id` (Foreign Key)
* `subject`
* `marks`

---

## ▶️ How to Run the Project

### 1️⃣ Install Requirements

* Install **Java (JDK 8+)**
* Install **MySQL**

### 2️⃣ Setup Database

* Create database and tables
* Update DB credentials in `DBConnection.java`

### 3️⃣ Add JDBC Driver

* Add `mysql-connector-j-9.6.0.jar`

### 4️⃣ Compile

```bash
javac -cp ".;mysql-connector-j-9.6.0.jar" *.java
```

### 5️⃣ Run

```bash
java -cp ".;mysql-connector-j-9.6.0.jar" Main
```

---

## 🔮 Future Enhancements (Phase 3)

* 🎨 GUI using Java Swing
* 🔐 Login Authentication System
* 📊 Graphical Analysis (Charts)
* 📄 PDF Report Export
* 🌐 Cloud Database Integration
* 👥 Multi-user Access

---

## 📌 Project Status

✅ **Phase 1 Completed** – Core Student & Marks Management
✅ **Phase 2 In Progress** – Advanced Features & Optimization
⏳ **Phase 3 Planned** – GUI & Advanced UI

---

## 👨‍💻 Developed By

**Saurabh and Team**
