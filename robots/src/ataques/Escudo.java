package ataques;

import debilidadesyfortalezas.Elemento;
import efectos.Proteccion;
import robots.Robot;

public class Escudo extends Ataque{
	public Escudo() {
		super(TipoAtaque.ESCUDO, 50, 0, 40, Elemento.IMPACTO);
	}
	
	@Override
	public void efectoSecundario(Robot enemigo) {
		enemigo.anadirEfecto(new Proteccion(enemigo));
	}
}
