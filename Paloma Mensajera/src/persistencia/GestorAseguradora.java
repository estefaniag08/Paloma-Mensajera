package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestorAseguradora extends GestorTabla{

	public GestorAseguradora() {
		super();
	}

	public ResultSet obtenerRegistros() throws SQLException {
		String consulta = "select id_aseguradora || ' - ' || nombre_aseguradora \"Aseguradora\" from aseguradora;";
		Statement declaracion = this.gestor.getConector().createStatement();
		return declaracion.executeQuery(consulta);
	}
}
