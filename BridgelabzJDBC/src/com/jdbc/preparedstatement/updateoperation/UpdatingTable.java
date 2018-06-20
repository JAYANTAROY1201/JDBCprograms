package com.jdbc.preparedstatement.updateoperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdatingTable {

	public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;
		String dbUrl = "jdbc:mysql://localhost/bridgelabz?useSSL=false";
		String user = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, user, password);
			String query = "UPDATE product SET price =? WHERE id=?";

			pstmt = con.prepareStatement(query);
			System.out.println("Choose your id:");
			int id=sc.nextInt();
			System.out.println("Set your price:");
			int price=sc.nextInt();
			pstmt.setInt(1, price);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
			System.out.println("Value updated successfully");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Value not updated");
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
