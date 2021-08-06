package com.capgemini.persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ListTasksDB extends DBConnection{

	public ArrayList<String> listInbox(int userID){
		ArrayList <String> inbox = new ArrayList<String>();
		//En esta clase mostramos las tareas de la base de datos cumpliendo con los parametros de inbox.
		//estos parámetros son:
		//tareas SIN CATEGORIA ordenadas por fecha planeada de mas antiguo a mas reciente, si una tarea ya esta retrasada se mostrara la fecha en rojo.
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

				//				System.out.println("------------------");
				//				System.out.print("id: ");
				//				System.out.println(idDB);
				//				System.out.print("email: ");
				//				System.out.println(emailDB);
				//				System.out.print("�es administrador? ");
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
	
	public ArrayList<String> listHoy(){
		ArrayList <String> hoy = new ArrayList<String>();
		//En esta clase mostramos las tareas de la base de datos cumpliendo con los parametros de la pseudolista hoy.
		//estos parámetros son:
		//1-Tareas cuya fecha planeada es hoy y todas las retrasadas
		//2-Las tareas retrasadas se mostrarán en rojo (no se hace aquí, solamente estoy listando todas las restricciones.)
		//3-Las tareas se listaran agrupadas por categoria de usuario 
		//4-Las tareas estarán ordenadas por fecha planeada de mas antiguo a mas reciente
		//4-Los campos a mostrar son el descripcion ( comments), nombre(title), fecha de inicio(created) y fecha fin(finished).
		try {
			//conexion con la BD
			Connection con = super.DBAccess();
			Statement stmt = con.createStatement();
			//realiza la consulta
			ResultSet rs = stmt.executeQuery("select comments, created, finished, planned, title from ttasks where (planned <= current_date)"); 
			while(rs.next()) {
				String commentsDB = rs.getString("comments");
				String createdDB = rs.getString("created");
				String plannedDB = rs.getString("planned");
				String titleDB = rs.getString("title");

				//				System.out.println("------------------");
				//				System.out.print("id: ");
				//				System.out.println(idDB);
				//				System.out.print("email: ");
				//				System.out.println(emailDB);
				//				System.out.print("�es administrador? ");

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
}

