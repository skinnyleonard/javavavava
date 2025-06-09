package entidades;

import ataques.Ataque;
import personajes.Robot;
import utiles.Utiles;

public class Maquina  extends Controlador{
	
	public Maquina(Robot robot) {
		super("Maquina",robot);
	}

	@Override
	public void elegirAtaque(Robot rival) {
		
		int opcionRandom =0;
		
		do {
			
			opcionRandom = Utiles.generarNumeroEntreRango(0, robot.getAtaques().length);
	
			
			
		}while(robot.getAtaques()[opcionRandom].getCosteEnergia()>robot.getEnergia() && robot.getEnergia()>0);
		
		System.out.println("Se utilizo el ataque: " + this.robot.getAtaques()[opcionRandom].getNombre());
		robot.atacar(opcionRandom, rival);
		
	}
	
	
	
	
	
	

}
