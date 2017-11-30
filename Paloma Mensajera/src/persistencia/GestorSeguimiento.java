package persistencia;

import java.sql.SQLException;
import java.sql.Statement;

import logica.EmpleadoLoggeado;

public class GestorSeguimiento extends GestorTabla{

	public GestorSeguimiento() {
		super();
	}
	
	public void insertarSeguimiento(String id,String idAgente,String idGuia) throws SQLException {
		String consulta = "insert into seguimiento values('"+id+"','"+EmpleadoLoggeado.getInstance().getId()+"','1','1','65412','"+idAgente+"')";
		String consulta1 = "insert into generacion_seguimiento values('"+idGuia+"','"+id+"')";
		String consulta2 = "update guia set estado_dist = true where consecutivo = '"+idGuia+"'";
		Statement declaracion = this.gestor.getConector().createStatement();
		declaracion.execute(consulta);
		declaracion.execute(consulta1);
		declaracion.execute(consulta2);


	}
}
