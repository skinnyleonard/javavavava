package entidades;

import robots.Robot;

public abstract class Controlador {
	private String nombre;
	protected Robot robot;
	
	public Controlador(String nombre, Robot robot) {
		this.nombre = nombre;
		this.robot = robot;
	}
	
	public abstract void elegirAtaque(Robot enemigo);
	
	public Robot getRobot() {
		return this.robot;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}
