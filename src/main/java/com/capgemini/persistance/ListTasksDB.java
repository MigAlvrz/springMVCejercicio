package com.capgemini.persistance;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.capgemini.model.Task;

public class ListTasksDB extends DBConnection{

	/*
	 * En esta metodo mostramos las tareas de la base de datos cumpliendo con los parametros de inbox.
	 * estos parámetros son:
	 * tareas SIN CATEGORIA ordenadas por fecha planeada de mas antiguo a mas reciente.
	 */
	public ArrayList<Task> listInbox(long userID){
		ArrayList <Task> inbox = new ArrayList<Task>();
		
		try {
			//conexion con la BD
			Connection con = super.DBAccess();
			Statement stmt = con.createStatement();
			//realiza la consulta
			ResultSet rs = stmt.executeQuery("SELECT id, comments, created, finished, planned, title, category_id, user_id FROM ttasks WHERE category_id IS NULL AND (user_id = "+userID+") ORDER BY planned ASC"); 
			while(rs.next()) {
				int idDB = rs.getInt("id");
				String commentsDB = rs.getString("comments");
				Date createdDB = rs.getDate("created");
				Date plannedDB = rs.getDate("planned");
				String titleDB = rs.getString("title");
				Task Temp = new Task(idDB, titleDB);
				Temp.setComments(commentsDB);
				Temp.setCreated(createdDB);
				Temp.setPlanned(plannedDB);
				inbox.add(Temp);
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
	public ArrayList<Task> listHoy(long UserID){
		ArrayList <Task> hoy = new ArrayList<Task>();
		try {
			//conexion con la BD
			Connection con = super.DBAccess();
			Statement stmt = con.createStatement();
			//realiza la consulta
			ResultSet rs = stmt.executeQuery("SELECT id, comments, created, finished, planned, title, category_id, user_id FROM ttasks INNER JOIN tcategories ON TTASKS.category_id = tcategories.id WHERE (planned <= current_date) AND (user_id = "+UserID+") ORDER BY planned ASC ");
			while(rs.next()) {
				int idDB = rs.getInt("id");
				String commentsDB = rs.getString("comments");
				Date createdDB = rs.getDate("created");
				Date plannedDB = rs.getDate("planned");
				String titleDB = rs.getString("title");
				String categoria = rs.getString("category_id");
				Task temp = new Task(idDB, titleDB);
				temp.setComments(commentsDB);
				temp.setCreated(createdDB);
				temp.setPlanned(plannedDB);
				temp.setCategoria(categoria);
				hoy.add(temp);
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
	public ArrayList<Task> listSemana(long UserID){
		ArrayList <Task> semana = new ArrayList<Task>();
		try {
			//conexion con la BD
			Connection con = super.DBAccess();
			Statement stmt = con.createStatement();
			//realiza la consulta
			ResultSet rs = stmt.executeQuery("SELECT t.id, t.comments, t.created, t.finished, t.planned, t.title, t.category_id, t.user_id, c.id,  c.name FROM ttasks t, tcategories c WHERE (planned <= current_date + (INTERVAL '7' DAY)) AND (user_id = "+UserID+") AND c.id = t.category_id ORDER BY planned ASC, name");
			while(rs.next()) {
				int idDB = rs.getInt("id");
				String commentsDB = rs.getString("comments");
				Date createdDB = rs.getDate("created");
				Date plannedDB = rs.getDate("planned");
				String titleDB = rs.getString("title");
				String categoria = rs.getString("category_id");
				Task temp = new Task(idDB, titleDB);
				temp.setComments(commentsDB);
				temp.setCreated(createdDB);
				temp.setPlanned(plannedDB);
				temp.setCategoria(categoria);
				semana.add(temp);
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
	public ArrayList<Task> listTareasCategorias(long UserID, String nombreCategoria){
		ArrayList <Task> tareasCategorias = new ArrayList<Task>();
		try {
			//conexion con la BD
			Connection con = super.DBAccess();
			Statement stmt = con.createStatement();
			//realiza la consulta
			ResultSet rs = stmt.executeQuery("SELECT t.comments, t.created, t.finished, t.planned, t.title, t.category_id, t.user_id, c.id,  c.name FROM ttasks t, tcategories c WHERE (c.name = '"+nombreCategoria+"') AND (user_id = "+UserID+") AND c.id = t.category_id ORDER BY planned ASC");
			while(rs.next()) {
				int idDB = rs.getInt("id");
				String commentsDB = rs.getString("comments");
				Date createdDB = rs.getDate("created");
				Date plannedDB = rs.getDate("planned");
				String titleDB = rs.getString("title");
				String categoria = rs.getString("name");
				Task temp = new Task(idDB, titleDB);
				temp.setComments(commentsDB);
				temp.setCreated(createdDB);
				temp.setPlanned(plannedDB);
				temp.setCategoria(categoria);
				tareasCategorias.add(temp);
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