package persistencia;

import java.sql.SQLException;
import java.sql.Statement;

import logica.EmpleadoLoggeado;

public class GestorSeguimiento extends GestorTabla{

	public GestorSeguimiento() {
		super();
	}
	
	public void seguimientoZonificacion(String idSeguimiento,String idGuia) throws SQLException {
		String consulta = "insert into seguimiento values('"+idSeguimiento+"','"+EmpleadoLoggeado.getInstance().getId()+"',null,'1',null,null)";
		String consulta1 =  "insert into generacion_seguimiento values('"+idGuia+"','"+idSeguimiento+"')";
		Statement declaracion = this.gestor.getConector().createStatement();
		declaracion.execute(consulta);
		declaracion.execute(consulta1);
	}
	
	public void seguimientoDistribución(String idSeguimiento,String idGuia,String idMensajero,String idAgente) throws SQLException {
		String consulta = "insert into seguimiento values('"+idSeguimiento+"',null,null,'2','"+idMensajero+"','"+idAgente+"')";
		String consulta1 =  "insert into generacion_seguimiento values('"+idGuia+"','"+idSeguimiento+"')";
		Statement declaracion = this.gestor.getConector().createStatement();
		declaracion.execute(consulta);
		declaracion.execute(consulta1);
	}
}
