package com.jdbc.employee_payroll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Employee_payrollJDBC {
	public static void main(String[] args)  {
		Connection connection = null;
		PreparedStatement statement = null;
		String query= "select * from payroll_service.employee_payroll where empName = ?";
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee Name to fetch Employee payroll details");
        String Name = sc.next();
        sc.close();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user = root & password = Brijesh@534");
			System.out.println("connection established");
			statement = con.prepareStatement(query);
			System.out.println("platform created");
			statement.setString(1, Name);
			ResultSet resultSet = statement.executeQuery();
			System.out.println("data fetched");
            if(resultSet.next()){
            	String empId = resultSet.getString(1);
                String empName = resultSet.getString(2);
                String salary = resultSet.getString(3);
                Date startDate = resultSet.getDate(4);
                System.out.println("name:" + empId+ " Employee Name : "+ empName+ " Salary: "+ salary+" Start date: "+startDate);
             }
            else{
                System.out.println("no data found : "+ Name);
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