package persistencia;

import java.sql.SQLException;

import logica.Guia;

public class FacadeGuia {

	private FacadeGuia() {
	}
	
	public static void insertarGuia(Guia guia) throws SQLException {
		GestorGuia gi = new GestorGuia();
		gi.insertarGuia(guia);
	}

}
