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
			ResultSet rs = stmt.executeQuery("select id, email, isadmin, login, status from tusers"); 
			while(rs.next()) {
				String idDB = rs.getString("id");
				String emailDB = rs.getString("email");
				Boolean isAdminDB = rs.getBoolean("isadmin");
				String loginDB = rs.getString("login");
				String statusDB = rs.getString("status");
				System.out.println("------------------");
				System.out.print("id: ");
				System.out.println(idDB);
				System.out.print("email: ");
				System.out.println(emailDB);
				System.out.print("¿es administrador? ");
				if(isAdminDB == true) {
					System.out.println("si");
				}
				else{
					System.out.println("no");
				}
				System.out.print("Nombre Login: ");
				System.out.println(loginDB);
				System.out.println("estado: ");
				System.out.println(statusDB);
			}
		}
		catch (Exception e) {
			System.out.println("listUsers failed.");
			e.printStackTrace();
		}
	}
}
