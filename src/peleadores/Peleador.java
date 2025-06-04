package peleadores;

import ataques.Ataque;

public class Peleador {
	private String nombre;
	private int cantVida;
	private int cantEnergia;
	private	Ataque[] ataques;
	private int basico = 100;
	
	public Peleador(String nombre, int cantVida, int cantEnergia, Ataque[] ataques) {
		this.nombre = nombre;
		this.cantVida = cantVida;
		this.cantEnergia = cantEnergia;
		this.ataques = ataques;
	}

	public String getNombre() {
		return this.nombre;
	}

}
