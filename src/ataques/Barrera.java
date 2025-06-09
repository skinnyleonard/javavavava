package ataques;

import enums.Elementos;
import estados.Stun;
import personajes.Robot;

public class Barrera extends Ataque {

	public Barrera() {
		super("Escudo protector", 0, 40, 50, Elementos.IMPACTO);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	public void efectoSecundario(Robot caster) {
		caster.añadirEfecto( new Stun(caster));
	}
	
	
	
}
