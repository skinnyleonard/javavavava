package estados;

import personajes.Robot;

public class Stun  extends EstadoBase{

	public Stun(Robot robot) {
		super(3, 4, robot);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void entrada() {
		super.entrada();
		this.robot.cambiarActivo();
	}
	
	@Override
	public void salida() {
		System.out.println("Salideaa");
		this.robot.activar();
		this.robot.eliminarEfecto(this);
	}
	

}
