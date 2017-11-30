package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorAgente extends GestorTabla{

	public GestorAgente() {
		super();
	}
	
	public ResultSet obtenerAgentes() throws SQLException {
		String consulta = "select id_agente || ' - ' || nombre_agente from agente;";
		Statement declaracion = this.gestor.getConector().createStatement();
		return declaracion.executeQuery(consulta);
	}

}
