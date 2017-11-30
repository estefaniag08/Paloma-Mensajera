package persistencia;

import java.sql.SQLException;
import java.sql.Statement;

import logica.Guia;

public class GestorGuia extends GestorTabla{

	public GestorGuia() {
		super();
	}
	
	public void insertarGuia(Guia guia) throws SQLException {
		String consulta = "insert into guia values('"+guia.getId()+"','"+guia.getIdEmbalaje()+"','"+guia.getOrden().getId()+"'"
				+ ",'"+guia.getItem()+"',"+guia.getAseguradora()+",null,"+guia.getempleado()+","+guia.getPrecioTotal()+",current_date,"+guia.getDelicado()+");";
		String consulta1 = "update detalle_orden_servicio d set estado_guia = true where d.id_orden_servicio = '"+guia.getOrden().getId()+"'"
				+ " and d.item = '"+guia.getItem()+"'";
		Statement declaracion = this.gestor.getConector().createStatement();
		declaracion.execute(consulta);
		declaracion.execute(consulta1);
	}
}
