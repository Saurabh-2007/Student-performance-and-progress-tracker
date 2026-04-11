📌 Project Overview

Student Performance and Progress Tracker is a Desktop-Based Java Application developed to manage and monitor students’ academic performance efficiently.
The system allows administrators or teachers to store student details, enter subject-wise marks, calculate percentage & grades, and track overall progress using a MySQL database.

This project is built using Core Java, Java Swing (GUI), JDBC, and MySQL.

🎯 Objectives

To digitize student academic records

To automate percentage and grade calculation

To provide an easy-to-use graphical interface

To store and retrieve student data securely using a database

🛠️ Technologies Used

Java (Core Java)

Java Swing (GUI)

JDBC (Java Database Connectivity)

MySQL Database

MySQL Connector J

Git & GitHub

🏗️ Project Architecture

The project follows a simple layered architecture:

GUI Layer (Presentation Layer)

Student Form

Marks Entry Form

View Records Screen

Business Logic Layer

Percentage Calculation

Grade Calculation

Result Status (Pass/Fail)

Data Access Layer (DAO Pattern)

StudentDAO

MarksDAO

Database Connection Class

Database Layer (MySQL)

students table

marks table

📊 Features

Add new student details

Insert subject-wise marks

Automatic percentage calculation

Automatic grade generation

Pass/Fail status generation

View stored student records

Desktop-based working (runs locally)

🗄️ Database Structure
Students Table

student_id

name

class

roll_number

Marks Table

student_id (Foreign Key)

subject_name

internal_marks

external_marks

total_marks

percentage

grade

▶️ How to Run the Project

Install Java (JDK 8 or above)

Install MySQL

Import the database schema

Add MySQL Connector J .jar file

Compile the project:

javac -cp ".;mysql-connector-j-9.6.0.jar" *.java

Run the main class:

java -cp ".;mysql-connector-j-9.6.0.jar" MainClassName
🔮 Future Enhancements

Attendance Management System

Graphical performance analysis (charts)

Login authentication system

Cloud database integration

Export report as PDF

Multi-user access system

📌 Project Status

Currently in development phase (Phase 1 completed – Basic student & marks management system).

👨‍💻 Developed By

  Saurabh and Team 
  


