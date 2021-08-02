package com.capgemini.persistance;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.jsp.tagext.TryCatchFinally;

//con esta clase se pretende que se cree la base de datos en HSQLDB siempre y cuando esta no exista.

public class CreateDB extends DBConnection {

	public void crearDB() {

		try  {


			Connection con = super.DBAccess();
			Statement stmt = con.createStatement();
			//TABLA tusers
			ResultSet tablaTUSERS = stmt.executeQuery("CREATE TABLE IF NOT EXISTS tusers(\r\n"
					+ "id BIGINT IDENTITY ,\r\n"
					+ "email VARCHAR(255),\r\n"
					+ "isadmin BOOLEAN,\r\n"
					+ "login VARCHAR(255),\r\n"
					+ "password VARCHAR(255),\r\n"
					+ "status VARCHAR(255),\r\n"
					+ "PRIMARY KEY (id)\r\n"
					+ ");");
			//TABLA tcategories
			ResultSet tablaTCATEGORIES = stmt.executeQuery("CREATE TABLE IF NOT EXISTS tcategories(\r\n"
					+ "id BIGINT IDENTITY ,\r\n"
					+ "name VARCHAR(255),\r\n"
					+ "user_id INT,\r\n"
					+ "FOREIGN KEY(user_id) REFERENCES tusers(id) ON DELETE SET NULL,\r\n"
					+ "PRIMARY KEY (id)\r\n"
					+ ");");
			//TABLA ttasks
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
			//cierra la conexión con la base de datos
			con.close();

		}
		catch (Exception e) {
			System.out.println("DB creation failed.");
			e.printStackTrace();
		}
	}

}