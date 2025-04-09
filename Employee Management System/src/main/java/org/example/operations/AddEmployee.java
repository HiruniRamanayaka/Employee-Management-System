package org.example.operations;

import org.example.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddEmployee {
    public String execute(Employee employee, Connection conn){
        String sql = "INSERT INTO employees(employee_id,name,department,email,hire_date) VALUES (?,?,?,?,?)";
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){

            preparedStatement.setString(1, employee.getEmpId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getDepartment());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setString(5, employee.getHire_date());

            int res = preparedStatement.executeUpdate();

            if(res>0){
                return "successfully added the employee id " + employee.getEmpId() + ".";
            }else{
                return "Adding employee unsuccessful.";
            }

        }catch(SQLException e){
            return "Adding new employee is unsuccessful. Reason:"+ e.getMessage();
        }
    }
}
