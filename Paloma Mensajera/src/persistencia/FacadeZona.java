package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FacadeZona {

	private FacadeZona() {
	}
	
	public static ResultSet consultarZonas() throws SQLException {
		GestorZona gz = new GestorZona();
		return gz.consultarZonas();
	}

}
