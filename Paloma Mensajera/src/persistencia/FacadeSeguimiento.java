package persistencia;

import java.sql.SQLException;

public class FacadeSeguimiento {

	private FacadeSeguimiento() {
		// TODO Auto-generated constructor stub
	}

	public static void insertarSeguimiento(String id,String idAgente,String idGuia) throws SQLException {
		GestorSeguimiento gs = new GestorSeguimiento();
		gs.insertarSeguimiento(id, idAgente, idGuia);
	}
}
