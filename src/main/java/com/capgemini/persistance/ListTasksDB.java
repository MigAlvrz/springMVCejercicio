package com.capgemini.persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ListTasksDB extends DBConnection{

	/*
	 * En esta metodo mostramos las tareas de la base de datos cumpliendo con los parametros de inbox.
	 * estos parámetros son:
	 * tareas SIN CATEGORIA ordenadas por fecha planeada de mas antiguo a mas reciente.
	 */
	public ArrayList<String> listInbox(int userID){
		ArrayList <String> inbox = new ArrayList<String>();
		try {
			//conexion con la BD
			Connection con = super.DBAccess();
			Statement stmt = con.createStatement();
			//realiza la consulta
			ResultSet rs = stmt.executeQuery("SELECT comments, created, finished, planned, title, category_id, user_id FROM ttasks WHERE category_id IS NULL AND (user_id = "+userID+") ORDER BY planned ASC"); 
			while(rs.next()) {
				String commentsDB = rs.getString("comments");
				String createdDB = rs.getString("created");
				String plannedDB = rs.getString("planned");
				String titleDB = rs.getString("title");
				inbox.add(titleDB);
				inbox.add(createdDB);
				inbox.add(plannedDB);
				inbox.add(commentsDB);
			}
			//cerramos la conexión
			con.close();
			return inbox;
		}
		catch (Exception e) {
			System.out.println("listTasks failed.");
			e.printStackTrace();
		}
		return null;
	}

	/*
	 *  En esta metodo mostramos las tareas de la base de datos cumpliendo con los parametros de hoy.
	 *  Estos parámetros son:
	 *  Mostrar las tareas cuya fecha planeada es HOY y todas las retrasadas. Las tareas se listaran agrupadas por categoria de usuario y ordenas por fecha de mas antiguo 
	 *  a mas reciente
	 */
	public ArrayList<String> listHoy(int UserID){
		ArrayList <String> hoy = new ArrayList<String>();
		try {
			//conexion con la BD
			Connection con = super.DBAccess();
			Statement stmt = con.createStatement();
			//realiza la consulta
			ResultSet rs = stmt.executeQuery("SELECT comments, created, finished, planned, title, category_id, user_id FROM ttasks INNER JOIN tcategories ON TTASKS.category_id = tcategories.id WHERE (planned <= current_date) AND (user_id = "+UserID+") ORDER BY planned ASC ");
			while(rs.next()) {
				String commentsDB = rs.getString("comments");
				String createdDB = rs.getString("created");
				String plannedDB = rs.getString("planned");
				String titleDB = rs.getString("title");
				String categoria = rs.getString("category_id");
				hoy.add(titleDB);
				hoy.add(createdDB);
				hoy.add(plannedDB);
				hoy.add(commentsDB);
				hoy.add(categoria);
			}
			//cerramos la conexión
			con.close();
			return hoy;
		}
		catch (Exception e) {
			System.out.println("listTasks failed.");
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 *  En esta metodo mostramos las tareas de la base de datos cumpliendo con los parametros de "semana".
	 *  Estos parámetros son:
	 *  
	 *  
	 */
	public ArrayList<String> listSemana(int UserID){
		ArrayList <String> semana = new ArrayList<String>();
		try {
			//conexion con la BD
			Connection con = super.DBAccess();
			Statement stmt = con.createStatement();
			//realiza la consulta
			ResultSet rs = stmt.executeQuery("SELECT t.comments, t.created, t.finished, t.planned, t.title, t.category_id, t.user_id, c.id,  c.name FROM ttasks t, tcategories c WHERE (planned <= current_date + (INTERVAL '7' DAY)) AND (user_id = "+UserID+") AND c.id = t.category_id ORDER BY planned ASC, name");
			while(rs.next()) {
				String commentsDB = rs.getString("comments");
				String createdDB = rs.getString("created");
				String plannedDB = rs.getString("planned");
				String titleDB = rs.getString("title");
				String categoria = rs.getString("name");
				semana.add(titleDB);
				semana.add(createdDB);
				semana.add(plannedDB);
				semana.add(commentsDB);
				semana.add(categoria);
			}
			//cerramos la conexión
			con.close();
			return semana;
		}
		catch (Exception e) {
			System.out.println("listTasks failed.");
			e.printStackTrace();
		}
		return null;
	}
	/*
	 *  En esta metodo mostramos las tareas de la base de datos cumpliendo con los parametros de "semana".
	 *  Estos parámetros son:
	 *  
	 *  
	 */
	public ArrayList<String> listTareasCategorias(int UserID, String nombreCategoria){
		ArrayList <String> tareasCategorias = new ArrayList<String>();
		try {
			//conexion con la BD
			Connection con = super.DBAccess();
			Statement stmt = con.createStatement();
			//realiza la consulta
			ResultSet rs = stmt.executeQuery("SELECT t.comments, t.created, t.finished, t.planned, t.title, t.category_id, t.user_id, c.id,  c.name FROM ttasks t, tcategories c WHERE (c.name = '"+nombreCategoria+"') AND (user_id = "+UserID+") AND c.id = t.category_id ORDER BY planned ASC");
			while(rs.next()) {
				String commentsDB = rs.getString("comments");
				String createdDB = rs.getString("created");
				String plannedDB = rs.getString("planned");
				String titleDB = rs.getString("title");
				String categoria = rs.getString("name");
				tareasCategorias.add(titleDB);
				tareasCategorias.add(createdDB);
				tareasCategorias.add(plannedDB);
				tareasCategorias.add(commentsDB);
				tareasCategorias.add(categoria);
			}
			//cerramos la conexión
			con.close();
			return tareasCategorias;
		}
		catch (Exception e) {
			System.out.println("listTasks failed.");
			e.printStackTrace();
		}
		return null;
	}
	
}