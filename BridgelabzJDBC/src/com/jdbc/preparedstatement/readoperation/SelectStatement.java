package com.jdbc.preparedstatement.readoperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class SelectStatement {

	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		String dbUrl = "jdbc:mysql://localhost/bridgelabz?useSSL=false";
		String user = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, user, password);
			String query = "select * from product where id=?";
			pstmt = con.prepareStatement(query);
			System.out.println("Enter id to show details: ");
			int id=sc.nextInt();
			pstmt.setInt(1, id);
			rslt = pstmt.executeQuery();
			while (rslt.next()) {
				int id1 = rslt.getInt("id");
				String pName = rslt.getString("pName");
				int price = rslt.getInt("price");

				System.out.println("Product ID: " + id1);
				System.out.println("Product Name: " + pName);
				System.out.println("Product Price: " + price);
			
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Data not found");
		} finally {
			try {
				if (rslt != null) {
					rslt.close();
				}
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
