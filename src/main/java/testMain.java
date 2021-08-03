import java.util.Scanner;

import com.capgemini.persistance.CreateDB;
import com.capgemini.persistance.LoginDB;
import com.capgemini.persistance.listUsersDB;

public class testMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreateDB createDB = new CreateDB();
		LoginDB loginDB = new LoginDB();
		listUsersDB listUsersDB = new listUsersDB();
		System.out.println("Creando base de datos...");
		createDB.crearDB();
		//login base de datos
		String username;
		String password;
		Scanner in = new Scanner(System.in);
		System.out.println("introduzca nombre login");
		username = in.next();
		System.out.println("introduzca Contraseña");
		password = in.next();
		loginDB.login(username, password);
		//mostrar usuarios sin contraseña
		listUsersDB.listUsers();
	}

}
