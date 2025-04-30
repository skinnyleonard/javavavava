package entidades;

public class Ciudad {
	
	private String nombre;
	private Jugador alcalde;
	public Edificio[] edificios;
	
	public Ciudad(String nombre, Jugador alcalde) {
		this.nombre = nombre;
		this.alcalde = alcalde;
	}
	
	public Jugador getAlcalde() {
		return alcalde;
	}
	
	public void mostrarDatos() {
		System.out.println("\n---------------------------------------------------");
		System.out.println("Ciudad: " + this.nombre + " | Alcalde: " + this.alcalde.getNombre() + " | Dinero: $" + this.alcalde.dinero);
		System.out.println("---------------------------------------------------\n");
	}

}
