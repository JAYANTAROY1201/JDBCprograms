package com.jdbc.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

public class SavePoint {

	public static void main(String args[]) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rslt = null;
		String dbUrl = "jdbc:mysql://localhost/bridgelabz?useSSL=false";
		String user = "root";
		String password = "root";
       Scanner sc=new Scanner(System.in);
		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, user, password);
            String query="insert into product values(5,'shoes',2000)";
			stmt = con.createStatement();
			stmt.executeUpdate(query);
			
			con.setAutoCommit(false);
			query="insert into product values(5,'bag',2000)";
			stmt.executeUpdate(query);
			Savepoint sp=con.setSavepoint("messege");
			query="delete from product where id=5";
			stmt.executeUpdate(query);
			con.rollback(sp);
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
					if (stmt != null) {
						stmt.close();
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
