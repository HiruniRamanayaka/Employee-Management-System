package org.example.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewEmployee {
    public String execute (String id, Connection conn){
        String sql = "SELECT * FROM employees WHERE employee_id = ?";
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){

            preparedStatement.setString(1, id);
            ResultSet res = preparedStatement.executeQuery();

            if(res.next()){
                String empId = res.getString("employee_id");
                String name = res.getString("name");
                String department = res.getString("department");
                String email = res.getString("email");
                String date = res.getString("hire_date");

                return ("Employee Id = " + empId + ", Name = " + name + ", Department : " + department + ", Email : " + email + ", Hired date : " + date);
            }else{
                return "Employee record is empty";
            }

        }catch (SQLException e){
            return "Retrieving Employee details unsuccessful. Reason: "+e.getMessage();
        }
    }
}
