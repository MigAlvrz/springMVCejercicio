package com.capgemini.persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class listUsersDB extends DBConnection{
	public void listUsers(){
		//En esta clase mostramos los usuarios de la base de datos exceptuando su contraseña.
		try {
		Connection con = super.DBAccess();
		Statement stmt = con.createStatement();
		//realiza la consulta
		ResultSet rs = stmt.executeQuery(""); 
		
		}
		catch (Exception e) {
			System.out.println("listUsers failed.");
			e.printStackTrace();
		}
	}
}
