package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static Connection conn = null;
	// provides a static method using the username and password
	public static Connection getConnection() {
		try {

			if (conn == null) {
				// load the JDBC driver for MySQL
				Class.forName("com.mysql.cj.jdbc.Driver");
				//a new connection is established to the database
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecom_store", "root", "root");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
