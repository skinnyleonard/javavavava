package robots;

import ataques.Acido;
import ataques.Ataque;
import ataques.Escudo;
import ataques.Fuego;
import ataques.Metralleta;
import debilidadesyfortalezas.Elemento;

public class Platino extends Robot{
	public Platino() {
		super(TipoRobot.PLATINO, 1200, 1000, 
				new Ataque[] { new Metralleta(), new Acido(), new Fuego(), new Escudo() }, 
				new Elemento[] { Elemento.IMPACTO }, 
				new Elemento[] { Elemento.CORROSION } );
	}
}
