package entidades;

import personajes.Robot;

public abstract class Controlador {

	private String nombre;
	protected Robot robot;
	
	
	
	public Controlador(String nombre, Robot robot) {
		this.nombre = nombre;
		this.robot = robot;
	}
	
	
	
	
	
	public abstract void elegirAtaque(Robot rival);
	
	
	
	public Robot getRobot() {
		return this.robot;
	}
	
}
