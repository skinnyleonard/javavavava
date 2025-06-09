import ataques.Ataque;
import entidades.Controlador;
import entidades.Enemigo;
import entidades.Jugador;
import robots.Platino;
import robots.Robot;
import robots.TipoRobot;
import robots.Titanio;
import utiles.Aleatorio;
import utiles.Consola;

public class Principal {
	private static Controlador[] jugadores = new Controlador[2];

	public static void main(String[] args) {
		System.out.println("bienvenido a el juego de los robots");
		
		eleccionJugador();
		batalla();
	}

	private static void batalla() {
		int turno = Aleatorio.generarEntero(2);
		boolean fin = false;
		
		while(!fin){
			fin = false;
			
			if(turno == 0) {
				System.out.println("turno de "+jugadores[turno].getNombre());
				jugadores[turno].elegirAtaque(jugadores[turno+1].getRobot());
				jugadores[turno+1].getRobot().aplicarEfecto(jugadores[turno+1].getRobot());
				
				System.out.println("------------------------------------------------------");
				turno = jugadores[turno+1].getRobot().getEnergia()<=0 ? 0 : 1;
			} else {
				System.out.println("turno de "+jugadores[turno].getNombre());
				jugadores[turno].elegirAtaque(jugadores[turno-1].getRobot());
				jugadores[turno-1].getRobot().aplicarEfecto(jugadores[turno-1].getRobot());
				
				System.out.println("------------------------------------------------------");
				turno = jugadores[turno-1].getRobot().getEnergia()<=0 ? 1 : 0;
			}
		}
	}

	private static void eleccionJugador() {
		System.out.print("nombre? : ");
		String nombre = Consola.s.nextLine();
		
		for (int i = 0; i < TipoRobot.values().length; i++) {
			System.out.println(i+1+") "+TipoRobot.values()[i]);
		}
		System.out.print("tipo de robot : ");
		int opc = Consola.ingresarEntero(0, TipoRobot.values().length);
		
		switch(opc) {
		case 1:
			jugadores[0] = new Jugador(nombre, new Titanio());
			jugadores[1] = new Enemigo(new Platino());
			break;
		case 2:
			jugadores[0] = new Jugador(nombre, new Platino());
			jugadores[1] = new Enemigo(new Titanio());
			break;
		}
	}
}
