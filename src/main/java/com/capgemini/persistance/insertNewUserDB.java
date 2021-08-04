package com.capgemini.persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class insertNewUserDB extends DBConnection {
	public void insertNewUser(String login, String email, String password) {
		try {
			//realiza la conexion
			Connection con = super.DBAccess();
			Statement stmt = con.createStatement();
			//comprueba si existe el nombre de usuario
			ResultSet checkLogin= stmt.executeQuery("select login from tusers where login ='"+login+"'");
			if (checkLogin.next()){
				System.out.println("el nombre usuario esta en uso.");
			}
			else {
				ResultSet insertNewUser = stmt.executeQuery("INSERT INTO tusers (email, login, password) VALUES ('"+email+"','"+login+"','"+password+"')");

			}
			//cierra la conexion
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
