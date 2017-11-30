package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FacadeAgente {

	private FacadeAgente() {
		
	}
	
	public static ResultSet obtenerRegistros() throws SQLException {
		GestorAgente ga = new GestorAgente();
		return ga.obtenerAgentes();
	}

}
