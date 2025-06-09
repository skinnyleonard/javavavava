package ataques;

import enums.Elementos;
import estados.Stun;
import personajes.Robot;

public class Interferencia extends Ataque {

	public Interferencia() {
		super("Intereferencia electromagnetica", 0, 90, 75, Elementos.IMPACTO);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	public void efectoSecundario(Robot caster,Robot target) {
		target.añadirEfecto( new Stun(target));
	}
	
	
	
}
