package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FacadeEmbalaje {
	public FacadeEmbalaje(){
		
	}
	
	public static ResultSet obtenerRegistros() throws SQLException {
		GestorEmbalaje ge = new GestorEmbalaje();
		return ge.obtenerRegistros();
	}
}
