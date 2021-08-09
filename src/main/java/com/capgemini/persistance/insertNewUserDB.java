package com.capgemini.persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class insertNewUserDB  {
	public static void insertNewUser(String login, String email, String password) {
		try {
			//realiza la conexion
			Connection con = DBConnection.DBAccess();
			Statement stmt = con.createStatement();
			//comprueba si existe el nombre de usuario
			ResultSet checkLogin= stmt.executeQuery("select login from tusers where login ='"+login+"'");
			ResultSet checkFirst = stmt.executeQuery("Select * from tusers");
			if (checkLogin.next()){
				System.out.println("el nombre usuario esta en uso.");
			}
			else {
				if(checkFirst.next()) 
					stmt.executeQuery("INSERT INTO tusers (email, login, password, status) VALUES ('"+email+"','"+login+"','"+password+"','ENABLED')");
				else 
					stmt.executeQuery("INSERT INTO tusers (email, login, password, status) VALUES ('"+email+"','"+login+"','"+password+"','ENABLED')");	
			}
			//cierra la conexion
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
