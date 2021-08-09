 package com.capgemini.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDB extends DBConnection {
	
	/**
	 * Logs an user into the database if the username and password are correct
	 * 
	 * @param username
	 * @param password
	 */
	
	public void login(String username, String password) {
		try {
			//realiza la conexi�n con la DB a trav�s de su clase padre.
			Connection con;
			con = super.DBAccess();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT login, password FROM tusers WHERE login = '" + username +"' and password = '" + password + "'");
//			rs.updateString(1, username);
//			rs.updateString(2, password);
			if (!rs.next()) {
				System.out.println("Login attempt failed");
			}
			else {
				System.out.println("login O.K.!");
			}
			//			while(rs.next()) {
			//				String loginDB = rs.getString("login");
			//				String passwordDB = rs.getString("password");
			//				if(loginDB.equals(username) && passwordDB.equals(password)) {
			//					System.out.println("login succesfull");
			//				}
			//				else {
			//					System.out.println("login failed.");
			//				}

		} catch (SQLException e) {
			System.out.println("datos incorrectos.");
			e.printStackTrace();
		}
	}
}
