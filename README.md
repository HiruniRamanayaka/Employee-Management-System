## Employee Management System

This is an Employee Management System built using Java, Maven, and MySQL. It allows you to perform CRUD operations (Create, Read, Update, Delete) on employee data. The application interacts with a MySQL database via JDBC.

# **Features**
•	Create: Add new employee records to the database.
•	Read: View employee records.
•	Update: Modify employee details.
•	Delete: Remove employee records from the database.

# **Requirements**
Prerequisites
•	Java 8 or above
•	Maven: For managing project dependencies.
•	MySQL: Database for storing employee data.
•	MySQL JDBC Driver: For connecting Java to MySQL.

# **Installation**
Step 1: Install MySQL
Make sure MySQL is installed on your machine. You can download and install MySQL from the official MySQL website.
Step 2: Set Up the MySQL Database
1.	Create the database:
CREATE DATABASE employee_management_system;
2.	Create the employees table:
CREATE TABLE employees (
    employee_id VARCHAR(50) NOT NULL PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(100),
    email VARCHAR(100),
    hire_date DATE
);

Step 3: Clone the Repository
Clone this repository to your local machine:
git clone https://github.com/yourusername/employee-management.git
Step 4: Configure Database Connection
1.	Open the DatabaseIntegration.java class in the src/utils directory.
2.	Modify the connection details (URL, USER, PASSWORD) to match your MySQL setup:
private static final String URL = "jdbc:mysql://localhost:3306/employee_management_system"; 
private static final String USER = "root";  // your MySQL username
private static final String PASSWORD = "password";  // your MySQL password

Step 5: Add Dependencies
Ensure that your Maven project is set up to use the MySQL JDBC driver. Open the pom.xml file and add the following dependency for MySQL:
<dependencies>
    <!-- MySQL JDBC Driver -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.34</version>
    </dependency>

    <!-- Other dependencies (if any) -->
</dependencies>

Run the following command to install the dependencies:
mvn clean install

Step 6: Running the Application
1.	Open the project in your IDE (e.g., IntelliJ IDEA or Eclipse).
2.	Run the Main.java class to start the application.
The program will attempt to connect to the MySQL database and allow you to perform CRUD operations.

# **Usage**
The application allows you to interact with the Employee Management System in the following ways:
1. Create Employee
You can add a new employee record by providing their id, name, email, department, and hired date. This will insert the record into the MySQL database.
2. Read Employees
You can view all employee records stored in the system. The records will be displayed with the id, name, email, department, and hired date.
3. Update Employee
You can update an employee's information by providing their employee ID and the new values for name, email, department, and hired date.
4. Delete Employee
You can delete an employee record from the system by providing their employee ID.

## **Demo Video**
[Watch the Demo Video](https://youtu.be/O9wXSm7Rffs)

