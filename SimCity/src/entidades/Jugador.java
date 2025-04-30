package entidades;

public class Jugador {
	
	private String nombre;
	public int dinero;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.dinero = 10000000;
	}
	
	public String getNombre() {
		return this.nombre;
	}

}
