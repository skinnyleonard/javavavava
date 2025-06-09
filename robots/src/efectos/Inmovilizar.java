package efectos;

import robots.Robot;

public class Inmovilizar extends Efecto{
	public Inmovilizar(Robot robot) {
		super(1, 4, robot);
	}
	
	@Override
	public void producir(Robot enemigo, int cont) {
		duracion(cont, this);
		System.out.println("el enemigo fue stuneado");
		enemigo.cambiarEstado();
	}
	
	@Override
	public void restaurar() {
		this.robot.activar();
	}
}
