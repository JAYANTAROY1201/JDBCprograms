package com.jdbc.preparedstatement.createoperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreatingTable {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement pstmt = null;
		String dbUrl = "jdbc:mysql://localhost/bridgelabz?useSSL=false";
		String user = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, user, password);
			String query = "create table product(id int(10) NOT NULL primary key, pName varchar(50),price int(20))";

			pstmt = con.prepareStatement(query);
			pstmt.executeUpdate();
			System.out.println("Table created successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Table not created");
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
