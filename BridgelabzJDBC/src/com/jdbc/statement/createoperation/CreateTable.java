package com.jdbc.statement.createoperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null;
		String dbUrl = "jdbc:mysql://localhost/bridgelabz?useSSL=false";
		String user = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, user, password);
			String query = "create table student(id int(10) NOT NULL primary key, fName varchar(50),"
					+ " lName varchar(50), mobile varchar(10))";

			stmt = con.createStatement();
			stmt.executeUpdate(query);
			System.out.println("Table created successfully");
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Table not created");
		} 
		finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} 
			catch (Exception e) {
				e.getStackTrace();
			}
		}
	}
}
