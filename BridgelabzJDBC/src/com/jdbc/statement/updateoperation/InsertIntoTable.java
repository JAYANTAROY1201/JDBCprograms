package com.jdbc.statement.updateoperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertIntoTable {

	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;
		String dbUrl = "jdbc:mysql://localhost/bridgelabz?useSSL=false";
		String user = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, user, password);
			String query = "insert into student values(1,'Jayanta','Roy','9740204317')";

			stmt = con.createStatement();
			stmt.executeUpdate(query);
			System.out.println("Value inserted successfully");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Value not inserted");
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
