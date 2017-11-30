package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logica.Guia;

public class GestorGuia extends GestorTabla{

	public GestorGuia() {
		super();
	}
	
	public void insertarGuia(Guia guia) throws SQLException {
		String consulta = "insert into guia values('"+guia.getId()+"','"+guia.getIdEmbalaje()+"','"+guia.getOrden().getId()+"'"
				+ ",'"+guia.getItem()+"',"+guia.getAseguradora()+",null,"+guia.getempleado()+","+guia.getPrecioTotal()+",current_date,"+guia.getDelicado()+",false);";
		String consulta1 = "update detalle_orden_servicio d set estado_guia = true where d.id_orden_servicio = '"+guia.getOrden().getId()+"'"
				+ " and d.item = '"+guia.getItem()+"';";
		Statement declaracion = this.gestor.getConector().createStatement();
		declaracion.execute(consulta);
		declaracion.execute(consulta1);
	}
	public ResultSet consultarGuiasSinZona() throws SQLException {
		String consulta ="select g.consecutivo, e.nombre_embalaje,g.item,g.id_aseguradora || ' - ' ||"
				+ " a.nombre_aseguradora \"Aseguradora\",g.id_empleado,em.nombre_empleado || ' ' || "
				+ " em.apellido_uno,g.fecha_creacion from guia g,tipo_embalaje e, aseguradora a, empleado em "
				+ " where g.id_embalaje = e.id_embalaje and g.id_aseguradora = a.id_aseguradora and g.id_empleado = "
				+ " em.id_empleado and g.id_zona_entrega is null;";
		Statement declaracion = this.gestor.getConector().createStatement();
		return declaracion.executeQuery(consulta);
	}
	
	public void zonificarGuia(String idGuia,String idZona) throws SQLException {
		String consulta = "update guia set id_zona_entrega = '"+idZona+"' where consecutivo = '"+idGuia+"'";
		Statement declaracion = this.gestor.getConector().createStatement();
		declaracion.execute(consulta);
	}
	
	public ResultSet getGuia(String idGuia) throws SQLException {
		String consulta = "select g.consecutivo,g.fecha_creacion,g.id_empleado || ' - ' || em.nombre_empleado || ' ' || em.apellido_uno, " + 
				" g.id_aseguradora || ' - ' || a.nombre_aseguradora,d.peso,c.cedula_cliente || ' - ' || c.nombre_cliente || ' ' || c.apellido_uno,g.id_embalaje || ' ' || " + 
				" e.nombre_embalaje, g.delicado, g.precio_total_envio,g.precio_total_envio+100000+(g.precio_total_envio)*0.19 from " + 
				" guia g, empleado em, aseguradora a, detalle_orden_servicio d, cliente c, tipo_embalaje e, orden_servicio o where g.id_empleado = em.id_empleado and " + 
				" g.id_aseguradora = a.id_aseguradora and e.id_embalaje = g.id_embalaje and g.item = d.item and g.id_orden_servicio = " + 
				" d.id_orden_servicio and o.id_orden_servicio = d.id_orden_servicio and o.cedula_cliente = c.cedula_cliente and g.consecutivo = '"+idGuia+"';";
		Statement declaracion = this.gestor.getConector().createStatement();
		return declaracion.executeQuery(consulta);
	}
	
	public ResultSet getGuiasPorZona(String idZona) throws SQLException {
		String consulta = "select g.consecutivo,g.fecha_creacion,g.id_empleado || ' - ' || em.nombre_empleado || ' ' || em.apellido_uno, " + 
				" g.id_aseguradora || ' - ' || a.nombre_aseguradora,d.peso,c.cedula_cliente || ' - ' || c.nombre_cliente || ' ' || c.apellido_uno,g.id_embalaje || ' ' || " + 
				" e.nombre_embalaje, case when g.delicado = true then 'Si' else 'No' end, g.precio_total_envio,g.precio_total_envio+100000+(g.precio_total_envio)*0.19 from " + 
				" guia g, empleado em, aseguradora a, detalle_orden_servicio d, cliente c, tipo_embalaje e, orden_servicio o where g.id_empleado = em.id_empleado and " + 
				" g.id_aseguradora = a.id_aseguradora and e.id_embalaje = g.id_embalaje and g.item = d.item and g.id_orden_servicio = " + 
				" d.id_orden_servicio and o.id_orden_servicio = d.id_orden_servicio and o.cedula_cliente = c.cedula_cliente and g.id_zona_entrega = '"+idZona+"';";
		Statement declaracion = this.gestor.getConector().createStatement();
		return declaracion.executeQuery(consulta);
	}
	
	public ResultSet getGuiasDist() throws SQLException {
		String consulta = "select g.consecutivo,g.item,g.fecha_creacion,g.id_zona_entrega || ' - ' || z.nombre from guia g, zona z where "
				+ " g.id_zona_entrega = z.id_zona and g.estado_dist = false;";
		Statement declaracion = this.gestor.getConector().createStatement();
		return declaracion.executeQuery(consulta);
	}
}
