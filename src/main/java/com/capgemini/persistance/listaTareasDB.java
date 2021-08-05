package com.capgemini.persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class listaTareasDB extends DBConnection{

	public ArrayList<String> listInbox(){
		ArrayList <String> inbox = new ArrayList<String>();
		//En esta clase mostramos las tareas de la base de datos cumpliendo con los parametros de inbox.
		//estos parámetros son:
		//1-Tareas sin categoría ordenadas por fecha planeada de antigua a reciente (si está especificada)
		//2-Las tareas retrasadas se mostrarán en rojo (no se hace aquí, solamente listo todas las restricciones.)
		//3-No se mostraran las tareas ya terminadas
		//4-Los campos a mostrar son el descripcion ( comments), nombre(title), fecha de inicio(created) y fecha fin(finished).
		try {
			//conexion con la BD
			Connection con = super.DBAccess();
			Statement stmt = con.createStatement();
			//realiza la consulta
			ResultSet rs = stmt.executeQuery("select comments, created, finished, planned, title from ttasks where (finished >= current_date)"); 
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
			System.out.println("listUsers failed.");
			e.printStackTrace();
		}
		return null;
	}
}

