package com.capgemini.persistance;

import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.capgemini.model.Task;

public class updateTaskDB extends DBConnection{
	
	/**
	 * Updated a task 
	 * 
	 * @param comments
	 * @param planned
	 * @param title
	 * @param id_tarea
	 */
	
	public void updateTask(String comments, String planned, String title, int id_tarea){
		try {
			//conexion con la BD
			Connection con = super.DBAccess();
			Statement stmt = con.createStatement();
			//realiza la consulta
			ResultSet rs = stmt.executeQuery("UPDATE ttasks SET comments = '"+comments+"' , planned = '"+planned+"', title ='"+title+"' WHERE id = "+id_tarea); 
			//cerramos la conexión
			con.close();
		}
		catch (Exception e) {
			System.out.println("updateTask failed.");
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns all the entries from the Cateogry table
	 * @return
	 */
	
	public ArrayList<String> categoryDB (){
		ArrayList<String> showCategory= new ArrayList<String>();
		try {
			//conexion con la BD
			Connection con = super.DBAccess();
			Statement stmt = con.createStatement();
			//realiza la consulta
			ResultSet rs = stmt.executeQuery("SELECT * FROM tcategories");
			//cerramos la conexión
			con.close();
			while(rs.next()) {
				String idCategory = rs.getString("id");
				String nameCategory = rs.getString("name");
				showCategory.add(idCategory);
				showCategory.add(nameCategory);
			}
		}
		catch (Exception e) {
			System.out.println("categoryDB failed.");
			e.printStackTrace();
		}
		return null;
	}
}
