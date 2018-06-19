package com.jdbc.statement.readoperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectStatement {

	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;
		ResultSet rslt = null;
		String dbUrl = "jdbc:mysql://localhost/bridgelabz?useSSL=false";
		String user = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, user, password);
			String query = "select * from student";
			stmt = con.createStatement();
			rslt = stmt.executeQuery(query);
			while (rslt.next()) {
				int id = rslt.getInt("id");
				String fName = rslt.getString("fName");
				String lName = rslt.getString("lName");
				String mobile = rslt.getString("mobile");

				System.out.println("Student ID: " + id);
				System.out.println("First Name: " + fName);
				System.out.println("Last Name: " + lName);
				System.out.println("Mobile: " + mobile);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Data not found");
		} finally {
			try {
				if (rslt != null) {
					rslt.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
	}
}
