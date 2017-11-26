package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorEmpleado extends GestorTabla{

	public GestorEmpleado() {
		super();
	}
	
	public boolean login(String id,String contrasena) throws SQLException {
		String consulta = "select * from empleado where id_empleado = '"+ id +"' and contrasena = '"+contrasena+"';";
		Statement declaracion = this.gestor.getConector().createStatement();
		ResultSet rs = declaracion.executeQuery(consulta);
		if(!rs.next()) return false;
		else return true;
	}

}
