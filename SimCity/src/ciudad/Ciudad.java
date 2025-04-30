package ciudad;

import entidades.Jugador;

public class Ciudad {
	
	private String nombre;
	private Jugador alcalde;
	private Edificio[] edificios;
	
	public Ciudad(String nombre, Jugador alcalde) {
		this.nombre = nombre;
		this.alcalde = alcalde;
	}
	
	public Jugador getAlcalde() {
		return alcalde;
	}

	public void setEdificios(Edificio[] edificios) {
		this.edificios =  edificios;
	}

}
