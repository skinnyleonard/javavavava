package entidades;

public class Jugador {
	
	private String nombre;
	public int dinero;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.dinero = 1000000000;
	}
	
	public String getNombre() {
		return nombre;
	}

}
