package efectos;

import robots.Robot;
import utiles.Aleatorio;

public class Efecto {
	protected int duracion;
	protected Robot robot;
	
	public Efecto(final int MIN, final int MAX, Robot robot) {
		this.duracion = Aleatorio.generarEntero(MIN, MAX);
//		System.out.println(duracion);
		this.robot = robot;
	}

	public void producir(Robot enemigo, int cont) {
		System.out.println(this.duracion);
	}
	
	public void duracion(int cant, Efecto efecto) {
		this.duracion-=cant;
		
		if(this.duracion <= 0) {
			restaurar();
			robot.eliminarEfecto(efecto);
		}
	}
	
	public void restaurar() {
		
	}
}
