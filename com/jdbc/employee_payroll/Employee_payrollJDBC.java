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
		String query1 = "SELECT SUM(Salary) from payroll_service.employee_payroll WHERE gender = 'F' GROUP BY gender;";
		String query2 = "SELECT SUM(Salary) from payroll_service.employee_payroll WHERE gender = 'M' GROUP BY gender;";
		String query3 = "SELECT AVG(Salary) from payroll_service.employee_payroll WHERE gender = 'F' GROUP BY gender;";
		String query4 = "SELECT AVG(Salary) from payroll_service.employee_payroll WHERE gender = 'M' GROUP BY gender;";
		String query5 = "SELECT MIN(Salary) from payroll_service.employee_payroll";
		String query6 = "SELECT MAX(Salary) from payroll_service.employee_payroll";
		String query7 = "SELECT COUNT(Salary) from payroll_service.employee_payroll";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user = root & password = Brijesh@534");
			System.out.println("connection established");
			statement = con.createStatement();
			System.out.println("platform created");
			
			ResultSet result1 = statement.executeQuery(query1);
			if(result1.next()){
				System.out.println("Salary =" +result1.getString("SUM(Salary)"));
				}
			
			ResultSet result2 = statement.executeQuery(query2);
			if(result2.next()){
				System.out.println("Salary =" +result2.getString("SUM(Salary)"));
				}
			
			ResultSet result3 = statement.executeQuery(query3);
			if(result3.next()){
				System.out.println("Salary =" +result3.getString("AVG(Salary)"));
				}
			
			ResultSet result4 = statement.executeQuery(query4);
			if(result4.next()){
				System.out.println("Salary =" +result4.getString("AVG(Salary)"));
				}
			
			ResultSet result5 = statement.executeQuery(query5);
			if(result5.next()){
				System.out.println("Salary =" +result5.getString("MIN(Salary)"));
				}
			
			ResultSet result6 = statement.executeQuery(query6);
			if(result6.next()){
				System.out.println("Salary =" +result6.getString("MAX(Salary)"));
				}
			
			ResultSet result7 = statement.executeQuery(query7);
			if(result7.next()){
				System.out.println("Salary =" +result7.getString("COUNT(Salary)"));
			}
		}
		catch(ClassNotFoundException | SQLException ex){
			 ex.printStackTrace();
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