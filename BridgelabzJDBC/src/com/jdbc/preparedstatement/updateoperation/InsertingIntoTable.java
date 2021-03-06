package com.jdbc.preparedstatement.updateoperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertingIntoTable {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement pstmt = null;
		String dbUrl = "jdbc:mysql://localhost/bridgelabz?useSSL=false";
		String user = "root";
		String password = "root";
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, user, password);
			String query = "insert into product values(?,?,?)";
			pstmt = con.prepareStatement(query);
			System.out.println("Enter product id:");
			int id=sc.nextInt();
			System.out.println("Enter product name: ");
			String pName=sc.next();
			System.out.println("Enter product price:");
			int price=sc.nextInt();
			pstmt.setInt(1,id);
			pstmt.setString(2,pName);
			pstmt.setInt(3, price);			
			pstmt.executeUpdate();
			System.out.println("Value inserted successfully");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Value not inserted");
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
