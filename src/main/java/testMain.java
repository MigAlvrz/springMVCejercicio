import java.util.ArrayList;
import java.util.Scanner;

import com.capgemini.persistance.CreateDB;
import com.capgemini.persistance.LoginDB;
import com.capgemini.persistance.UpdateStatusAdminDB;
import com.capgemini.persistance.deleteUserDB;
import com.capgemini.persistance.listUsersDB;

public class testMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreateDB createDB = new CreateDB();
		LoginDB loginDB = new LoginDB();
		UpdateStatusAdminDB updateStatusDB = new UpdateStatusAdminDB();
		listUsersDB listUsersDB = new listUsersDB();
		deleteUserDB deleteUserDB = new deleteUserDB();
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
		ArrayList<String> arrayListUsers = listUsersDB.listUsers();
		arrayListUsers.forEach(System.out::println);
		//cambiar estado usuarios
		updateStatusDB.UpdateStatusToDisabled(0);
		//mostrar usuarios ordenados por login
		System.out.println("-------------------------------");
		System.out.println("order by Login");
		ArrayList<String> arrayListUsersByLogin = listUsersDB.listUsersOrderByLogin();
		arrayListUsersByLogin.forEach(System.out::println);
		//mostrar usuarios ordenados por mail
		System.out.println("-------------------------------");
		System.out.println("order by email");
		ArrayList<String> arrayListUsersByEmail = listUsersDB.listUsersOrderByEmail();
		arrayListUsersByEmail.forEach(System.out::println);
		//mostrar usuarios ordenados por status
		System.out.println("-------------------------------");
		System.out.println("order by status");
		ArrayList<String> arrayListUsersByStatus = listUsersDB.listUsersOrderByStatus();
		arrayListUsersByLogin.forEach(System.out::println);
		
		//borrar usuario DB
		deleteUserDB.deleteUser(6);
	}

}
