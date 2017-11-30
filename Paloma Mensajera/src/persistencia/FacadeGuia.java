package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import logica.Guia;

public class FacadeGuia {

	private FacadeGuia() {
	}
	
	public static void insertarGuia(Guia guia) throws SQLException {
		GestorGuia gi = new GestorGuia();
		gi.insertarGuia(guia);
	}

	public static ResultSet consultarGuiaSinZona() throws SQLException {
		GestorGuia gi = new GestorGuia();
		return gi.consultarGuiasSinZona();
	}
	
	public static void zonificarGuia(String idGuia,String idZona) throws SQLException {
		GestorGuia gi = new GestorGuia();
		gi.zonificarGuia(idGuia, idZona);
	}
	
	public static ResultSet getGuia(String idGuia) throws SQLException{
		GestorGuia gi = new GestorGuia();
		return gi.getGuia(idGuia);
	}
	
	public static ResultSet getGuiasPorZona(String idZona) throws SQLException {
		GestorGuia gi = new GestorGuia();
		return gi.getGuiasPorZona(idZona);
	}
}
