package robots;

import ataques.Acido;
import ataques.Ataque;
import ataques.Fuego;
import ataques.Interferencia;
import ataques.Metralleta;
import debilidadesyfortalezas.Elemento;

public class Titanio extends Robot{
	public Titanio() {
		super(TipoRobot.TITANIO, 1000, 1500, 
				new Ataque[] { new Metralleta(), new Acido(), new Fuego(), new Interferencia()}, 
				new Elemento[] { Elemento.IMPACTO }, 
				new Elemento[] { Elemento.FUEGO });
	}
}
