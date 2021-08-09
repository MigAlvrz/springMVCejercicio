 package com.capgemini.persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;

import com.capgemini.model.User;
import com.capgemini.model.UserStatus;

public class listUsersDB {
	public static ArrayList<User> listUsers(){
		//declaramos un arraylist de usuarios
		ArrayList <User> user = new ArrayList<User>();
		//En esta clase mostramos los usuarios de la base de datos exceptuando su contrase�a.
		try {
			Connection con = DBConnection.DBAccess();
			Statement stmt = con.createStatement();
			//realiza la consulta
			ResultSet rs = stmt.executeQuery("select id, email, isadmin, password, login, status from tusers"); 
			while(rs.next()) {
				Long id = Long.parseLong(rs.getString("id"));
				user.add(new User(id, rs.getString("login") , rs.getString("email"),rs.getString("password"), UserStatus.ENABLED, rs.getBoolean("isadmin")));

			}
			con.close();
			return user;
		}
		catch (Exception e) {
			System.out.println("listUsers failed.");
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<String> listUsersOrderByLogin(){
		//declaramos un arraylist de usuarios
		ArrayList <String> user = new ArrayList<String>();
		//En esta clase mostramos los usuarios de la base de datos exceptuando su contrase�a.
		try {
			Connection con = DBConnection.DBAccess();
			Statement stmt = con.createStatement();
			//realiza la consulta
			ResultSet rs = stmt.executeQuery("select id, email, isadmin, login, status from tusers ORDER BY login"); 
			while(rs.next()) {
				String idDB = rs.getString("id");
				String emailDB = rs.getString("email");
				Boolean isAdminDB = rs.getBoolean("isadmin");
				String loginDB = rs.getString("login");
				String statusDB = rs.getString("status");
				String BooleanResultAdmin;
				if(isAdminDB == true) {
					BooleanResultAdmin= "si es administrador";
				}
				else{
					BooleanResultAdmin= "no es administrador";
				}
				user.add(idDB);
				user.add(emailDB);
				user.add(BooleanResultAdmin);
				user.add(loginDB);
				user.add(statusDB);

			}
			con.close();
			return user;
		}
		catch (Exception e) {
			System.out.println("listUsers failed.");
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<String> listUsersOrderByEmail(){
		//declaramos un arraylist de usuarios
		ArrayList <String> user = new ArrayList<String>();
		//En esta clase mostramos los usuarios de la base de datos exceptuando su contrase�a.
		try {
			Connection con = DBConnection.DBAccess();
			Statement stmt = con.createStatement();
			//realiza la consulta
			ResultSet rs = stmt.executeQuery("select id, email, isadmin, login, status from tusers ORDER BY Email"); 
			while(rs.next()) {
				String idDB = rs.getString("id");
				String emailDB = rs.getString("email");
				Boolean isAdminDB = rs.getBoolean("isadmin");
				String loginDB = rs.getString("login");
				String statusDB = rs.getString("status");
				String BooleanResultAdmin;
				if(isAdminDB == true) {
					BooleanResultAdmin= "si es administrador";
				}
				else{
					BooleanResultAdmin= "no es administrador";
				}
				user.add(idDB);
				user.add(emailDB);
				user.add(BooleanResultAdmin);
				user.add(loginDB);
				user.add(statusDB);

			}
			con.close();
			return user;
		}
		catch (Exception e) {
			System.out.println("listUsers failed.");
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<String> listUsersOrderByStatus(){
		//declaramos un arraylist de usuarios
		ArrayList <String> user = new ArrayList<String>();
		//En esta clase mostramos los usuarios de la base de datos exceptuando su contrase�a.
		try {
			Connection con = DBConnection.DBAccess();
			Statement stmt = con.createStatement();
			//realiza la consulta
			ResultSet rs = stmt.executeQuery("select id, email, isadmin, login, status from tusers ORDER BY status"); 
			while(rs.next()) {
				String idDB = rs.getString("id");
				String emailDB = rs.getString("email");
				Boolean isAdminDB = rs.getBoolean("isadmin");
				String loginDB = rs.getString("login");
				String statusDB = rs.getString("status");
				String BooleanResultAdmin;
				if(isAdminDB == true) {
					BooleanResultAdmin= "si es administrador";
				}
				else{
					BooleanResultAdmin= "no es administrador";
				}

				//				System.out.print("Nombre Login: ");
				//				System.out.println(loginDB);
				//				System.out.println("estado: ");
				//				System.out.println(statusDB);

				user.add(idDB);
				user.add(emailDB);
				user.add(BooleanResultAdmin);
				user.add(loginDB);
				user.add(statusDB);

			}

			con.close();

			return user;
		}
		catch (Exception e) {
			System.out.println("listUsers failed.");
			e.printStackTrace();
		}
		return null;
	}
}