package com.jdbc.preparedstatement.deleteoperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DropingTable{

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement pstmt = null;
		String dbUrl = "jdbc:mysql://localhost/bridgelabz?useSSL=false";
		String user = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, user, password);
			String query = "DROP table product";

			pstmt = con.prepareStatement(query);
			pstmt.executeUpdate();
			System.out.println("Table deleted successfully");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Table not deleted");
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
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
