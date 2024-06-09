# Examination Management System

This project is an Examination Management System built using Java, JDBC, MySQL, and Apache Tomcat. It demonstrates CRUD operations to manage student details, monitor attendance, set and check exam eligibility criteria, and print student records.

## Features

- **Add/Delete Student Details**: Add new students to the system and delete existing student records.
- **Attendance Monitoring**: Update and monitor student attendance.
- **Set/Edit Eligibility Criteria**: Define and update criteria for exam eligibility based on attendance.
- **Check Eligible Students**: Identify students eligible for exams based on the defined criteria.
- **Print All Records**: Display all student records.

## Database

Database named `ExamManagementDB`.

    ```sql
    CREATE DATABASE ExamManagementDB;

    USE ExamManagementDB;

    CREATE TABLE Students (
        student_id INT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        email VARCHAR(255) NOT NULL,
        attendance INT DEFAULT 0
    );

    CREATE TABLE EligibilityCriteria (
        id INT AUTO_INCREMENT PRIMARY KEY,
        attendanceThreshold INT NOT NULL
    );
    ```


