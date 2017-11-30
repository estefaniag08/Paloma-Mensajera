package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FacadeAseguradora {

	private FacadeAseguradora() {
	}
	
	public static ResultSet obtenerRegistros() throws SQLException {
		GestorAseguradora ga = new GestorAseguradora();
		return ga.obtenerRegistros();
	}

}
