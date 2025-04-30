package entidades;

public class Jugador {
	private String nombre;
	private String apellido;
	private int edad;
	private Estaciones estacion;
	
	public Jugador(String nombre, String apellido, int edad, Estaciones estacion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.estacion = estacion;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getApellido() {
		return this.apellido;
	}
	
	public int getEdad() {
		return this.edad;
	}
	
	public Estaciones getEstacion() {
		return this.estacion;
	}
}
