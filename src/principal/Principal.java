package principal;

import entidades.Controlador;
import entidades.Jugador;
import entidades.Maquina;
import personajes.RobotPlatino;
import personajes.RobotTungsteneo;
import utiles.Utiles;

public class Principal {

	public static void main(String[] args) {
		
	Controlador[] jugadores = new Controlador[2];	
	
	System.out.println("Ingrese tu nombre");
	String nombre = Utiles.s.nextLine();
	
	jugadores[0] = new Jugador(nombre,new RobotTungsteneo());	
	jugadores[1] = new Maquina(new RobotPlatino());
		
		
		combate(jugadores);

	}
	
	
	
	public static void combate(Controlador[] jugadores) {
		
		int turno = Utiles.generarNumeroEntreRango(0, 2);
		
		
		while(jugadores[0].getRobot().getEnergia()>0 && jugadores[1].getRobot().getEnergia()>0 &&jugadores[0].getRobot().getVida()>0 && jugadores[1].getRobot().getVida()>0) {
			System.out.println("turno de " + (turno==0 ? "jugador" : "maquina"));
			if(turno ==0) {
				for (int i=0;i<jugadores.length;i++) {
					jugadores[i].getRobot().mostrarEstadisticas();
				}
			}
			
			jugadores[turno].getRobot().aplicarEfectos();
			jugadores[turno].elegirAtaque(jugadores[(turno+1)%2].getRobot());
			
			
			turno = (turno+1)%2;
			System.out.println();
		}
		
		String ganador = (jugadores[0].getRobot().getVida()>jugadores[1].getRobot().getVida()) ? "el Jugador" : " la Maquina";
		
		
		System.out.println("El ganador fue " + ganador  );
		
		
		
		
		
	}

}
