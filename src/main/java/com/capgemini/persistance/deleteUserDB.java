package com.capgemini.persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class deleteUserDB extends DBConnection{
	public void deleteUser(int id) {
		try {
			//realiza la conexion
			Connection con = super.DBAccess();
			Statement stmt = con.createStatement();
			//realiza la consulta
			ResultSet borraUsuario = stmt.executeQuery("DELETE FROM tusers WHERE id = "+id);
			//cierra la conexion
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}	

}