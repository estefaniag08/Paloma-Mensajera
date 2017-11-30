package persistencia;

import java.sql.SQLException;

public class FacadeSeguimiento {

	private FacadeSeguimiento() {
		// TODO Auto-generated constructor stub
	}

	public static void seguimientoZonificacion(String idSeguimiento,String idGuia) throws SQLException {
		GestorSeguimiento gs = new GestorSeguimiento();
		gs.seguimientoZonificacion(idSeguimiento, idGuia);
	}
	
	public static void seguimientoDistribucion(String idSeguimiento,String idGuia,String idMensajero,String idAgente) throws SQLException {
		GestorSeguimiento gs = new GestorSeguimiento();
		gs.seguimientoDistribución(idSeguimiento, idGuia, idMensajero, idAgente);
	}
}
