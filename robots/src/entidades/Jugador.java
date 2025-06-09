package entidades;

import robots.Robot;
import utiles.Consola;

public class Jugador extends Controlador{
	public Jugador(String nombre, Robot robot) {
		super(nombre, robot);
	}
	
	@Override
	public void elegirAtaque(Robot enemigo) {
		robot.mostrarAtaques();
		int opc = Consola.ingresarEntero(1, robot.getAtaques().length);
		robot.atacar(enemigo, opc);
		System.out.println("el enemigo ahora tiene "+enemigo.getVida()+" de vida y tu energia total es de "+robot.getEnergia()+" y tu vida total "+robot.getVida());
	}
	
	public Robot getRobotElegido() {
		return robot;
	}
}
