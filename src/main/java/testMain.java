//import java.util.ArrayList;
//import java.util.Scanner;
//
//import com.capgemini.persistance.CreateDB;
//import com.capgemini.persistance.LoginDB;
//import com.capgemini.persistance.UpdateStatusAdminDB;
//import com.capgemini.persistance.deleteUserDB;
//import com.capgemini.persistance.insertNewUserDB;
//import com.capgemini.persistance.listUsersDB;
//import com.capgemini.persistance.ListTasksDB;
//
//public class testMain {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		CreateDB createDB = new CreateDB();
//		LoginDB loginDB = new LoginDB();
//		UpdateStatusAdminDB updateStatusDB = new UpdateStatusAdminDB();
//		listUsersDB listUsersDB = new listUsersDB();
//
//		deleteUserDB deleteUserDB = new deleteUserDB();
//		insertNewUserDB insertNewUser = new insertNewUserDB();
//		ListTasksDB listTasks = new ListTasksDB();

		//		System.out.println("Creando base de datos...");
		//		createDB.crearDB();
		//		--------------------------------------------------------------------------------------------------------------------------------------------------
		//		//login base de datos
		//				String username;
		//				String password;
		//				Scanner in = new Scanner(System.in);
		//				System.out.println("introduzca nombre login");
		//				username = in.next();
		//				System.out.println("introduzca Contrase�a");
		//				password = in.next();
		//				loginDB.login(username, password);

		//		------------------------------------------------------------------------------------------------------------------------------------------------

		//				//mostrar usuarios sin contrase�a
		//				ArrayList<String> arrayListUsers = listUsersDB.listUsers();
		//			arrayListUsers.forEach(System.out::println);

		//		------------------------------------------------------------------------------------------------------------------------------------------------
		//
		//cambiar estado usuarios
		//		updateStatusDB.UpdateStatusToDisabled(0);
		//		
		//mostrar usuarios ordenados por login
		//		System.out.println("-------------------------------");
		//		System.out.println("order by Login");
		//		ArrayList<String> arrayListUsersByLogin = listUsersDB.listUsersOrderByLogin();
		//		arrayListUsersByLogin.forEach(System.out::println);
		//		
		//mostrar usuarios ordenados por mail
		//		System.out.println("-------------------------------");
		//		System.out.println("order by email");
		//		ArrayList<String> arrayListUsersByEmail = listUsersDB.listUsersOrderByEmail();
		//		arrayListUsersByEmail.forEach(System.out::println);
		//		
		//mostrar usuarios ordenados por status
		//		System.out.println("-------------------------------");
		//		System.out.println("order by status");
		//		ArrayList<String> arrayListUsersByStatus = listUsersDB.listUsersOrderByStatus();
		//		arrayListUsersByLogin.forEach(System.out::println);

		//		------------------------------------------------------------------------------------------------------------------------------------------------

		//		//borrar usuario DB
		//		deleteUserDB.deleteUser(1);

		//		------------------------------------------------------------------------------------------------------------------------------------------------

		//test insert new user
		//		String login = "";
		//		String email= "xddd@jajaj.com";
		//		String password = "xd";
		//		insertNewUser.insertNewUser(login , email, password);
		//

		//-----------------------------------------------------------------------------------------------------------------------------------------------------

		//test lista tareas
//		System.out.println("inbox");
//			ArrayList<String> arrayListInbox= listTasks.listInbox(2);
//			arrayListInbox.forEach(System.out::println);
//		System.out.println("hoy");
//			ArrayList<String> arrayListHoy = listTasks.listHoy(2);
//			arrayListHoy.forEach(System.out::println);
//		System.out.println("semana");
//			ArrayList<String> arrayListSemana = listTasks.listSemana(2);
//			arrayListSemana.forEach(System.out::println);
//	}
//
//}
