package efectos;

import robots.Robot;

public class Proteccion extends Efecto{
	public Proteccion(Robot robot) {
		super(1, 3, robot);
	}
	
	@Override
	public void producir(Robot enemigo, int cont) {
		duracion(cont, this);
		enemigo.cambiarGuardia();
	}
	
	@Override
	public void restaurar() {
		this.robot.cambiarGuardiaAAtaque();
	}
}
