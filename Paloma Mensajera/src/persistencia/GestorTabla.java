package persistencia;

public class GestorTabla {

	protected GestorBD gestor;
	
	public GestorTabla() {
		this.gestor = GestorBD.getInstance();
	}
}
