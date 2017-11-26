package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorBD {

	private static Connection conector;
	private static String nombreBD = "PalomaMensajera";
	private static String url = "jdbc:postgresql://localhost:5432/"+nombreBD;
	private static String usuario = "postgres";
	private static String contrasena = "990209leo";

	
	private static GestorBD gestor;
	
	public static GestorBD getInstance() {
		if(gestor==null) {
			gestor = new GestorBD();
		}
		return gestor;
	}
	
	private GestorBD() {
		conectarBD();
	}
	
	

	public static Connection getConector() {
		return conector;
	}


	public void conectarBD() {
		try {
			Class.forName("org.postgresql.Driver");
			conector = DriverManager.getConnection(url, usuario, contrasena);
		} catch (ClassNotFoundException cnf) {
			System.out.println("Clase no encontrada: " + cnf.getMessage());
		} catch (SQLException sqle) {
			System.out.println("Descripción del error al crear la base de datos: " + sqle.getMessage());
		}

	}
}
