package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FacadeOrdenes {

	private FacadeOrdenes() {
	}
	
	public static ResultSet consultarOrdenes() throws SQLException {
		GestorOrdenServicio go = new GestorOrdenServicio();
		return go.buscarOrdenes();
	}
	
	public static ResultSet consultarDetalles(String idOrden) throws SQLException {
		GestorOrdenServicio go = new GestorOrdenServicio();
		return go.buscarDetalles(idOrden);
	}

}
