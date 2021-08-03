package com.capgemini.persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class UpdateStatusAdminDB extends DBConnection{
	
	public void UpdateStatusToEnabled(int id){
		try {
			//realiza la conexion
			Connection con = super.DBAccess();
			Statement stmt = con.createStatement();
			//realiza la consulta
			ResultSet rs = stmt.executeQuery("UPDATE tusers SET status = 'ENABLED' WHERE id = "+id);
			//cierra la conexion
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public void UpdateStatusToDisabled(int id){
		try {
			//realiza la conexion
			Connection con = super.DBAccess();
			Statement stmt = con.createStatement();
			//realiza la consulta
			ResultSet rs = stmt.executeQuery("UPDATE tusers SET status = 'DISABLED' WHERE id = "+id);
			//cierra la conexion
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			
		} 
	}
}
