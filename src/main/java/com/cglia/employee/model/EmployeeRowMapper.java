package com.cglia.employee.model;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;



public class EmployeeRowMapper implements RowMapper<Employee>{
	
	
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException{
    	System.out.println("stated the rowMapper");
        return new Employee(
            rs.getInt("employeeId"),
            rs.getString("employeeName"),
            rs.getString("email"),
            rs.getString("department")

        );
    }
 }
