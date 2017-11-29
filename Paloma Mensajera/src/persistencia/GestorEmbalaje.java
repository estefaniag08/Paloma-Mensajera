package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorEmbalaje extends GestorTabla{
	
	public GestorEmbalaje(){
		super();
	}
	
	public ResultSet obtenerRegistros() throws SQLException {
		String consulta = "select id_embalaje || ' - ' || nombre_embalaje \"Embalaje\" from tipo_embalaje;";
		Statement declaracion = this.gestor.getConector().createStatement();
		return declaracion.executeQuery(consulta);
	}
}
