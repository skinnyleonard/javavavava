package estados;

import personajes.Robot;
import utiles.Utiles;

public class EstadoBase {
	
	
	
	
	private int duracion;
	
	protected Robot robot;
	
	
	
	
	public EstadoBase(int min, int max, Robot robot) {
		this.duracion = Utiles.generarNumeroEntreRango(min, max);
		this.robot = robot;
	}
	
	public void entrada() {
		System.out.println(this.duracion);
	}
	
	
	public void efectoTurno() {
		System.out.println(this.duracion);
		
		
		if(this.duracion<=0) {
			salida();
		}
		
	}
	
	public int getDuracion() {
		return this.duracion;
	}
	
	public void salida() {
		this.robot.eliminarEfecto(this);
		System.out.println("FIN");
		
	}
	

}
