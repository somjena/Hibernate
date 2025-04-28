
# 1. HibernateAnotations

# Student Entity Persistence Application

## Overview
This project demonstrates a basic Java application that uses **JPA (Jakarta Persistence API)** to perform a simple **Create (Insert)** operation on a **Student** entity. 

The application connects to a database using an `EntityManager`, captures user input through the console, and persists the data into the database.

## Technology Stack
- Java
- JPA (Jakarta Persistence API)
- EntityManager & EntityTransaction
- Database (Configured in `persistence.xml`)
- Scanner for user input

## How it Works
1. **Setup Entity Manager**:  
   - `EntityManagerFactory` and `EntityManager` are initialized using the persistence unit name `"HNA"`.

2. **Capture User Input**:  
   - The user is prompted to enter the Student's ID, Name, Age, and Marks via the console.

3. **Persist Data**:  
   - A `Student` object is created and populated with the provided input.
   - A transaction is started, and the student object is persisted to the database.

4. **Commit Transaction**:  
   - The transaction is committed to ensure that the data is saved permanently.

5. **Confirmation**:  
   - After committing, a confirmation message "Data Saved" is displayed to the user.

## Files
- `StudentDriver.java` (Located in `com.codecomrades.controller`):  
  Contains the `main` method that handles the entire process of entity creation and persistence.
  
- `Student.java` (Entity Class):  
  Should be annotated properly (typically with `@Entity`) and contain fields like `sid`, `sname`, `sage`, and `mark`.

- `persistence.xml` (Configuration File):  
  Contains database connection properties and persistence unit definition with the name `HNA`.

## Important Notes
- Ensure the database connection details in `persistence.xml` are correct and the database is running.
- The `Student` entity must be correctly mapped with appropriate JPA annotations.
- Proper error handling and resource closing (EntityManager, Scanner) are recommended for production-ready code.
- 
 🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀🚀
