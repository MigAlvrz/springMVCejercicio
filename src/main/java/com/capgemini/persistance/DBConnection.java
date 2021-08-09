package com.capgemini.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {


	/**
	 * Creates a connection to the hsqldb database
	 * @return
	 * @throws SQLException
	 */

	public static Connection DBAccess() throws SQLException{
		try {
			Class.forName("org.hsqldb.jdbcDriver");

		String url = "jdbc:hsqldb:hsql://localhost/";
		String user = "SA";
		String password = "";
		return DriverManager.getConnection(url, user, password);
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("connection failed");
			e.printStackTrace();
			return null;
		}

	}
}
