import com.capgemini.persistance.CreateDB;

public class testMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreateDB createDB = new CreateDB();
		
		System.out.println("Creando base de datos...");
		createDB.crearDB();
	}

}
