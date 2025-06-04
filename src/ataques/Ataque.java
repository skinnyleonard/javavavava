package ataques;

public class Ataque {
	private String nombre;
	private int danio;
	private int energiaReq;
	
	public Ataque(String nombre, int danio, int energiaReq) {
		this.nombre = nombre;
		this.danio = danio;
		this.energiaReq = energiaReq;
	}	
}
