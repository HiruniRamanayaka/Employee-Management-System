package org.example;

import org.example.operations.*;
import org.example.utils.DatabaseIntegration;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DatabaseIntegration.getConnection()) {
            System.out.println("Successfully connected to the database.");

            while(true) {
                System.out.println("What want to do: ");
                System.out.println("1 - add an employee\n" +
                        "2 - view employee details\n" +
                        "3 - Update an employee details\n" +
                        "4 - Delete an employee\n" +
                        "0 - Exit");

                Scanner scanner = new Scanner(System.in);
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        System.out.print("Enter ID: ");
                        String id1 = scanner.nextLine();
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Department: ");
                        String department = scanner.nextLine();
                        System.out.print("Enter Email: ");
                        String email = scanner.nextLine();
                        System.out.print("Enter Hire Date (YYYY-MM-DD): ");
                        String hireDate = scanner.nextLine();

                        Employee newEmployee1 = new Employee(id1, name, department, email, hireDate);
                        AddEmployee addEmployee = new AddEmployee();
                        String add = addEmployee.execute(newEmployee1, conn);
                        System.out.println(add);
                        break;

                    case 2:
                        System.out.print("Enter ID: ");
                        String id2 = scanner.next();

                        ViewEmployee viewEmployee = new ViewEmployee();
                        String view = viewEmployee.execute(id2, conn);
                        System.out.println(view);
                        break;

                    case 3:
                        System.out.print("Enter ID: ");
                        String id3 = scanner.nextLine();
                        System.out.print("What is you want to change? (name/ department/ email/ hired date : ");
                        String attribute = scanner.nextLine();
                        System.out.print("Enter the value?");
                        String value = scanner.nextLine();

                        UpdateEmployee updateEmployee = new UpdateEmployee();
                        String update = updateEmployee.execute(id3, attribute, value, conn);
                        System.out.println(update);
                        break;

                    case 4:
                        System.out.print("Enter ID: ");
                        String id4 = scanner.next();

                        DeleteEmployee deleteEmployee = new DeleteEmployee();
                        String delete = deleteEmployee.execute(id4, conn);
                        System.out.println(delete);
                        break;

                    case 0:
                        System.out.println("Exiting...");
                        return; // Exit the program

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
