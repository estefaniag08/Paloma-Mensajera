package persistencia;

import java.sql.SQLException;

public class FacadeEmpleado {

	
	private FacadeEmpleado() {
	}
	
	public static boolean login(String id, String contrasena) throws SQLException {
		GestorEmpleado ge = new GestorEmpleado();
		return ge.login(id, contrasena);
	}

}
