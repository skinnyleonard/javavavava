package ataques;

import debilidadesyfortalezas.Elemento;

public class Acido extends Ataque{
	public Acido() {
		super(TipoAtaque.ACIDO, 100, 75, 80, Elemento.CORROSION);
	}
}
