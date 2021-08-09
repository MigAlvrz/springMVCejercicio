package com.capgemini.persistance;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.jsp.tagext.TryCatchFinally;

//con esta clase se pretende que se cree la base de datos en HSQLDB siempre y cuando esta no exista.

public class CreateDB extends DBConnection {

	/**
	 * Creates the tables for the pojo classes if they don't exist
	 */
	
	public void crearDB() {

		try  {
			//realiza la conexi�n con la DB a trav�s de su clase padre.
			Connection con = super.DBAccess();
			Statement stmt = con.createStatement();
			//crea la tabla tusers siempre y cuando no exista
			ResultSet tablaTUSERS = stmt.executeQuery("CREATE TABLE IF NOT EXISTS tusers(\r\n"
					+ "id BIGINT IDENTITY ,\r\n"
					+ "email VARCHAR(255),\r\n"
					+ "isadmin BOOLEAN,\r\n"
					+ "login VARCHAR(255),\r\n"
					+ "password VARCHAR(255),\r\n"
					+ "status VARCHAR(255),\r\n"
					+ "PRIMARY KEY (id)\r\n"
					+ ");");
			//crea la tabla tcategories siempre y cuando no exista.
			ResultSet tablaTCATEGORIES = stmt.executeQuery("CREATE TABLE IF NOT EXISTS tcategories(\r\n"
					+ "id BIGINT IDENTITY ,\r\n"
					+ "name VARCHAR(255),\r\n"
					+ "user_id INT,\r\n"
					+ "FOREIGN KEY(user_id) REFERENCES tusers(id) ON DELETE SET NULL,\r\n"
					+ "PRIMARY KEY (id)\r\n"
					+ ");");
			//Crea la tabla TTASKS siempre y cuando no exista
			ResultSet tablaTTASKS = stmt.executeQuery("CREATE TABLE IF NOT EXISTS ttasks(\r\n"
					+ "id BIGINT IDENTITY ,\r\n"
					+ "comments VARCHAR(255),\r\n"
					+ "created DATE,\r\n"
					+ "finished DATE,\r\n"
					+ "planned DATE,\r\n"
					+ "title VARCHAR(255),\r\n"
					+ "category_id INT,\r\n"
					+ "FOREIGN KEY(category_id) REFERENCES tcategories(id) ON DELETE SET NULL,\r\n"
					+ "user_id INT,\r\n"
					+ "FOREIGN KEY(user_id) REFERENCES tusers(id) ON DELETE SET NULL,\r\n"
					+ "PRIMARY KEY (id)\r\n"
					+ ");");
			//cierra la conexi�n con la base de datos
			con.close();

		}
		catch (Exception e) {
			System.out.println("DB creation failed.");
			e.printStackTrace();
		}
	}

}