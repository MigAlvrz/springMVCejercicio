package com.capgemini.persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class deleteUserDB extends DBConnection{
	
	/**
	 * Deletes a user from the DB
	 * @param id
	 */
	
	public void deleteUser(int id) {
		try {
			//realiza la conexion
			Connection con = super.DBAccess();
			Statement stmt = con.createStatement();
			//realiza la consulta
			//bora la categor�a del usuario indicado.
			ResultSet borraCategoria= stmt.executeQuery("DELETE FROM tcategories WHERE user_id = "+id);
			//borra la tarea del usuario indicado.
			ResultSet borraTarea = stmt.executeQuery("DELETE FROM ttasks WHERE user_id = "+id);
			//borra el usuario indicado.
			ResultSet borraUsuario = stmt.executeQuery("DELETE FROM tusers WHERE id = "+id);
			
			//cierra la conexion
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}	

}