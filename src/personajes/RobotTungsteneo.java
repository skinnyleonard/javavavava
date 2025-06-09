package personajes;

import ataques.Acido;
import ataques.Ataque;
import ataques.Fuego;
import ataques.Interferencia;
import ataques.Metralleta;
import enums.Elementos;

public class RobotTungsteneo extends Robot {

	public RobotTungsteneo() {
		super("Robot de Titanio", 1000, 1500, new Ataque[] { new Metralleta(), new Acido(), new Fuego(), new Interferencia() }, new Elementos[]{Elementos.FUEGO}, new Elementos[]{Elementos.IMPACTO});
	}

}
