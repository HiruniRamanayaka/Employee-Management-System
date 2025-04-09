package org.example.operations;

import org.example.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteEmployee{
    public String execute (String id, Connection conn){
        String sql = "DELETE FROM employees WHERE employee_id = ?";

        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setString(1, id);

            int res = preparedStatement.executeUpdate();
            if(res>0){
                return "Successsfully deleted the employee id "+ id;
            } else if (res == 0) {
                return "Employee not found";
            }else{
                return "Deleting employee is unsuccessful";
            }
        }catch(SQLException e){
            return "Deleting employee is unsuccessful. Reason: "+e.getMessage();
        }
    }
}
