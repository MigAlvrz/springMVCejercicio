package com.capgemini.persistance;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.capgemini.model.Task;

public class addTaskDB extends DBConnection{
	public void addTask(String title, int id_categoria){
		try {
			//conexion con la BD
			Connection con = super.DBAccess();
			Statement stmt = con.createStatement();
			//realiza la consulta
			ResultSet rs = stmt.executeQuery("INSERT INTO ttasks (created, title, category_id) VALUES (current_date, '"+title+"',"+id_categoria+")"); 
			//cerramos la conexión
			con.close();
		}
		catch (Exception e) {
			System.out.println("addTasks failed.");
			e.printStackTrace();
		}
	}
	
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

