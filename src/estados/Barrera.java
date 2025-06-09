package estados;

import personajes.Robot;

public class Barrera  extends EstadoBase{

	public Barrera(Robot robot) {
		super(1, 3, robot);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void entrada() {
		this.robot.cambiarGuardia();
	}
	
	@Override
	public void salida() {
		super.salida();
		this.robot.cambiarGuardia();
	}
	

}
