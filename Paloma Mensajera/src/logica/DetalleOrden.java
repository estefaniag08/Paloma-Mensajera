package logica;

public class DetalleOrden {

	private OrdenServicio orden;
	private String item;
	private int embalaje;
	private float precio;
	private float peso;
	
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

	public int getEmbalaje() {
		return embalaje;
	}

	public void setEmbalaje(int embalaje) {
		this.embalaje = embalaje;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public DetalleOrden() {
	}

}
