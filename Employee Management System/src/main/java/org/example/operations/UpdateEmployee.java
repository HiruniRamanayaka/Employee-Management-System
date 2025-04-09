package org.example.operations;

import org.example.Employee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateEmployee {

    public String execute (String id, String attribute, Object value, Connection conn){
        String sql = "UPDATE employees SET " + attribute + " = ? WHERE employee_id = ?";

        // Validate attribute to avoid SQL injection
        if (!isValidAttribute(attribute)) {
            return "Invalid attribute specified for update.";
        }

        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setString(1, value.toString());
            preparedStatement.setString(2, id);

            int res = preparedStatement.executeUpdate();

            if(res>0){
                return "Successfully updated the employee id : "+id;
            }else{
                return "Updating employee is unsuccessful";
            }

        }catch(SQLException e){
            return "Updating employee unsuccessful. Reason: "+e.getMessage();
        }
    }


    // Validate attribute to prevent SQL injection
    private boolean isValidAttribute(String attribute) {
        return attribute.equalsIgnoreCase("name") ||
                attribute.equalsIgnoreCase("department") ||
                attribute.equalsIgnoreCase("email") ||
                attribute.equalsIgnoreCase("hire_date");
    }
}


