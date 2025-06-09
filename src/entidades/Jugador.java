	package entidades;

import personajes.Robot;
import utiles.Utiles;

public class Jugador  extends Controlador{

	public Jugador(String nombre, Robot robot) {
		super(nombre, robot);
		
	}
	
	
	

	@Override
	public void elegirAtaque(Robot rival) {
	
		
		int opcion =0;
		
		do {
			
			
			System.out.println("Elija un ataque");
			robot.mostrarAtaques();
			
			opcion = Utiles.ingresarEntero(opcion, this.robot.getAtaques().length, this.robot)-1;	
			
		}while(robot.getAtaques()[opcion].getCosteEnergia()>robot.getEnergia() && robot.getEnergia()>0);
		
		
		robot.atacar(opcion, rival);
		
	}
		
		
		
		
	}


