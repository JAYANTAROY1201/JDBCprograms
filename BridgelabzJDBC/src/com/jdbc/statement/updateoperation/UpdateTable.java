package com.jdbc.statement.updateoperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateTable {

	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;
		String dbUrl = "jdbc:mysql://localhost/bridgelabz?useSSL=false";
		String user = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, user, password);
			String query = "UPDATE student SET lName = 'Roy Chowdhury' WHERE id=1";

			stmt = con.createStatement();
			stmt.executeUpdate(query);
			System.out.println("Value updated successfully");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Value not updated");
		} finally {
			try {
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
