package logica;

public class Guia {
	private String id;
	private String idEmbalaje;
	private OrdenServicio orden;
	private String item;
	private String aseguradora;
	private String zona;
	private String empleado;
	private String precioTotal;
	private String fechaCreacion;
	private String delicado;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdEmbalaje() {
		return idEmbalaje;
	}
	public void setIdEmbalaje(String idEmbalaje) {
		this.idEmbalaje = idEmbalaje;
	}
	public OrdenServicio getOrden() {
		return orden;
	}
	public void setOrden(OrdenServicio orden) {
		this.orden = orden;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getAseguradora() {
		return aseguradora;
	}
	public void setAseguradora(String aseguradora) {
		this.aseguradora = aseguradora;
	}
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	public String getempleado() {
		return empleado;
	}
	public void setempleado(String empleado) {
		this.empleado = empleado;
	}
	public String getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(String precioTotal) {
		this.precioTotal = precioTotal;
	}
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getDelicado() {
		return delicado;
	}
	public void setDelicado(String delicado) {
		this.delicado = delicado;
	}
}
