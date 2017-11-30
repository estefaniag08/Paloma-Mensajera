package logica;

import java.sql.Date;

public class OrdenServicio {

	private int id;
	private Empleado empleado;
	private Cliente cliente;
	private String direccionRecoleccion;
	private Date fechaCreacion;
	private boolean estado;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getDireccionRecoleccion() {
		return direccionRecoleccion;
	}

	public void setDireccionRecoleccion(String direccionRecoleccion) {
		this.direccionRecoleccion = direccionRecoleccion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public OrdenServicio() {
	}

}
