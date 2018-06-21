package com.jdbc.batchprocessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchUsingStatement {
	public BatchUsingStatement() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt = null;
		ResultSet rslt = null;
		String dbUrl = "jdbc:mysql://localhost/bridgelabz?useSSL=false";
		String user = "root";
		String password = "root";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, user, password);
			stmt = con.createStatement();
            String query="insert into product values(6,'books',900)";
            stmt.addBatch(query);
			query="insert into product values(7,'stationary',2000)";
			stmt.addBatch(query);
			stmt.executeBatch();
			System.out.println("Inserted sucessfull..");
	         }catch (Exception e) {
	        	 System.out.println("Not inserted......");
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
