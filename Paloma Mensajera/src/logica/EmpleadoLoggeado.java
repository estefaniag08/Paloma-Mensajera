package logica;

public class EmpleadoLoggeado {

	private EmpleadoLoggeado() {
		// TODO Auto-generated constructor stub
	}
	
	private static String id;
	private static String contrasena;
	
	private static EmpleadoLoggeado instance;
	
	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		EmpleadoLoggeado.id = id;
	}

	public static String getContrasena() {
		return contrasena;
	}

	public static void setContrasena(String contrasena) {
		EmpleadoLoggeado.contrasena = contrasena;
	}

	public static EmpleadoLoggeado getInstance() {
		if(instance==null) {
			instance = new EmpleadoLoggeado();
		}
		return instance;
	}
	

}
