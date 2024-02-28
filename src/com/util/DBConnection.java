package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	// 6 step of JDBC
	// 1)load driver class
	// 2)getting connection with database
	
	// 3)create statement or prepared statement
	// 4)prepare query
	// 5)submit query
	// 6)getting result

	// 7)transaction managament... [connection close...]

	private static String userName = "root";
	private static String password = "root";
	private static String connectionURL = "jdbc:mysql://localhost:3306/club6";
	private static String driverClass = "com.mysql.jdbc.Driver";

	// Connection ---> centeral interface for..

	public static Connection getDBConnection() {

		Connection conn = null;

		try {
			Class.forName(driverClass); // 1 load driver class

			conn = DriverManager.getConnection(connectionURL, userName, password);
			if (conn != null) {

				System.out.println("Connected to Db");
			} else {

				System.out.println("Not connected...");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;

	}

	public static void main(String[] args) {

		DBConnection.getDBConnection();

	}

}
