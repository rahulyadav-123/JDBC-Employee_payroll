package com.jdbc.employee_payroll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Employee_payrollJDBC {
	
		public static void main(String[] args) throws Exception {
			String query= "update payroll_service.employee_payroll set salary =3000000 where empName ='Charlie'";
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user = root & password = Rahulyadav@123");
			System.out.println("connection established");
			Statement statement = con.createStatement();
			System.out.println("platform created");
			int count = statement.executeUpdate(query);
			System.out.println(count + " row/s affected");
			statement.close();
			con.close();
		}
	}