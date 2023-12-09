# Task Management API

The Task Management API is a Spring Boot application that provides CRUD operations for managing tasks along with user authentication.

## Setup

Before running the project, ensure you have the following prerequisites:

- Java Development Kit (JDK) installed (version 8 or higher)
- Apache Maven installed
- MySQL database server installed

## Database Setup

1. **Database Installation:**

   Install MySQL database server.

2. **Create Database:**

   Create a database named `TaskManagementDB` in your MySQL database server.

3. **Create Tables:**

   Create two tables in the `TaskManagementDB` database:

   - **User Table:**

     ```sql
     CREATE TABLE user (
       userId INT AUTO_INCREMENT PRIMARY KEY,
       userName VARCHAR(255),
       userEmail VARCHAR(255),
       userPassword VARCHAR(255),
       userRole VARCHAR(255)
     );
     ```

   - **Task Table:**

     ```sql
     CREATE TABLE task (
       taskId INT AUTO_INCREMENT PRIMARY KEY,
       userId INT, -- Foreign key referencing user table
       title VARCHAR(255),
       description VARCHAR(255),
       dueDate DATE,
       status VARCHAR(255),
       FOREIGN KEY (userId) REFERENCES user(userId)
     );
     ```

4. **Database Configuration:**

   Update the `application.properties` file in the `src/main/resources` directory of the project with your database configuration:

   ```properties
   server.port=8088
   spring.datasource.url=jdbc:your-database-url/TaskManagementDB
   spring.datasource.username=your-database-username
   spring.datasource.password=your-database-password

4. **Run Following Commands to Run the code:**

  ```mvn clean install ```

  ```java -jar target/your-project.jar```