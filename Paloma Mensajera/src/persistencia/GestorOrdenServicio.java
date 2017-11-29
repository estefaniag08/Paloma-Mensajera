package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestorOrdenServicio extends GestorTabla{

	public GestorOrdenServicio() {
		super();
	}
	
	public ResultSet buscarOrdenes() throws SQLException {
		String consulta = "select o.id_orden_servicio, c.cedula_cliente,c.nombre_cliente || ' ' || c.apellido_uno \"Nombre del cliente\", o.direccion_recoleccion, o.fecha_creacion from orden_servicio o,cliente c\r\n" + 
				"where o.cedula_cliente = c.cedula_cliente and estado = true;";
		Statement declaracion = this.gestor.getConector().createStatement();
		ResultSet rs = declaracion.executeQuery(consulta);
		return rs;
	}
	
	public ResultSet buscarDetalles(String idOrden) throws SQLException {
		String consulta = "select d.item, e.nombre_embalaje,d.precio_individual,d.peso from (detalle_orden_servicio d left join guia g on (g.item = d.item and " + 
				" g.id_orden_servicio = d.id_orden_servicio)) inner join tipo_embalaje e on d.id_embalaje = e.id_embalaje and  d.id_orden_servicio = '"+idOrden+"';";
		Statement declaracion = this.gestor.getConector().createStatement();
		ResultSet rs = declaracion.executeQuery(consulta);
		return rs;
	}
}
