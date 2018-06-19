package com.jdbc.statement.deleteoperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DropTable{

	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;
		String dbUrl = "jdbc:mysql://localhost/bridgelabz?useSSL=false";
		String user = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, user, password);
			String query = "DROP table student";

			stmt = con.createStatement();
			stmt.executeUpdate(query);
			System.out.println("Table deleted successfully");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Table not deleted");
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
