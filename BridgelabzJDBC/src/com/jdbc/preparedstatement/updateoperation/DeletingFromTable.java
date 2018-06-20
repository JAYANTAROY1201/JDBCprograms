package com.jdbc.preparedstatement.updateoperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeletingFromTable{

	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;
		String dbUrl = "jdbc:mysql://localhost/bridgelabz?useSSL=false";
		String user = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, user, password);
			String query = "DELETE from product WHERE id=?";
			pstmt = con.prepareStatement(query);
			System.out.println("Enter id to delete row: ");
			int id=sc.nextInt();
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		  System.out.println("Deleted....");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Data not deleted");
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
