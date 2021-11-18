package com.jdbc.employee_payroll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee_payrollJDBC {
	
	public static void main(String[] args)  {
		Connection connection = null;
		Statement statement = null;
		String query= "select * from payroll_service.employee_payroll where startDate between cast('2018-01-03' as date) and date(now())";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user = root & password = Rahulyadav@123");
			System.out.println("connection established");
			statement = con.createStatement();
			System.out.println("platform created");
			ResultSet result = statement.executeQuery(query);
			System.out.println("data fetched");
            if(result.next()){
            	 System.out.println("emp_Id = "+result.getInt(1) + " Emp_name = "+result.getString(2) + " Salary =" + result.getInt(3) + " Start Date =" + result.getString(4));
            }
		}
		catch(ClassNotFoundException | SQLException ex){
			((Throwable) ex).printStackTrace();
        }
		finally {
			if(statement != null){
                try{
                    statement.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            } if(connection != null){
                try{
                    connection.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
		}
	}
}
