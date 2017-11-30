package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorZona extends GestorTabla{

	public GestorZona() {
		super();
	}
	
	public ResultSet consultarZonas() throws SQLException {
		String consulta = "select z1.id_zona,z1.id_tipo_zona || ' - ' || tz.nombre_tipo_zona," + 
				" z1.nombre, z1.id_rural, z1.latitud,z1.longitud,z2.nombre from zona z1, tipo_zona tz, zona z2 where z1.id_tipo_zona = tz.id_tipo_zona " + 
				" and z1.id_tipo_zona != '4' and z2.id_zona = z1.id_zona_superior;";
		Statement declaracion = this.gestor.getConector().createStatement();
		return declaracion.executeQuery(consulta);
	}

}
