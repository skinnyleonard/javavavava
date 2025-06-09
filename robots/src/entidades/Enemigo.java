package entidades;

import robots.Robot;
import utiles.Aleatorio;

public class Enemigo extends Controlador{
	public Enemigo(Robot robot) {
		super("rival", robot);
	}

	@Override
	public void elegirAtaque(Robot enemigo) {
		int opc = Aleatorio.generarEntero(1, robot.getAtaques().length);
		robot.atacar(enemigo, opc);
		System.out.print("el enemigo uso el ");
		robot.getAtaques()[opc-1].mostrarDatos(opc-1);
	}
}
