package ataques;

import debilidadesyfortalezas.Elemento;
import efectos.Inmovilizar;
import robots.Robot;

public class Interferencia extends Ataque{
	public Interferencia() {
		super(TipoAtaque.INTERFERENCIA, 75, 0, 50, Elemento.IMPACTO);
	}
	
	@Override
	public void efectoSecundario(Robot enemigo) {
		enemigo.anadirEfecto(new Inmovilizar(enemigo));
	}
}
