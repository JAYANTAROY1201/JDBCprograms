package com.jdbc.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertUsingTransaction {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rslt = null;
		String dbUrl = "jdbc:mysql://localhost/bridgelabz?useSSL=false";
		String user = "root";
		String password = "root";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, user, password);
			con.setAutoCommit(false);

			ps = con.prepareStatement("insert into product values(?,?,?)");
			System.out.println("Enter id");

			int id = sc.nextInt();

			System.out.println("Enter product name");
			String pName = sc.next();

			System.out.println("enter price");

			int price = sc.nextInt();

			ps.setInt(1, id);
			ps.setString(2, pName);
			ps.setInt(3, price);
			ps.executeUpdate();

			System.out.println("commit/rollback");
			String answer = sc.next();
			if (answer.equals("commit")) {
				con.commit();
			}
			if (answer.equals("rollback")) {
				con.rollback();
			}
			System.out.println("record successfully saved");

		} catch (Exception e) {
			System.out.println(e);
		} finally {

			{
				try {
					if (ps != null) {
						ps.close();
					}
					if (con != null) {
						con.close();
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
