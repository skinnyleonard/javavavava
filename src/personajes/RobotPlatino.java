package personajes;

import ataques.Acido;
import ataques.Ataque;
import ataques.Barrera;
import ataques.Fuego;
import ataques.Metralleta;
import enums.Elementos;

public class RobotPlatino extends Robot {

	public RobotPlatino() {
	super("Robot de Platino", 1200, 1000, new Ataque[] { new Metralleta(), new Acido(), new Fuego(), new Barrera()}, new Elementos[]{Elementos.IMPACTO}, new Elementos[]{Elementos.CORROSION});
	}
	
}
