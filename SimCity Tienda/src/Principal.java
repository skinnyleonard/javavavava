import Interfaces.Tienda;
import entidades.Ciudad;
import entidades.Jugador;
import utilidades.Utiles;

public class Principal {
	
	public static void main(String[] args) {
		String nombreCiudad;
		Ciudad ciudad;
		Tienda tienda = new Tienda();
		
		System.out.println("Bienvenidos al Sim City");
		
		System.out.println("Ingrese el nombre de la ciudad que desea administrar");
		nombreCiudad = Utiles.s.nextLine();		
		ciudad = new Ciudad(nombreCiudad, crearJugador());

		tienda.comprarEdificios(ciudad);
		
		Utiles.s.close();
	}

	private static Jugador crearJugador() {
		String nombreAlcalde;
		Jugador jugador;
		System.out.println("Ingrese su nombre");
		nombreAlcalde = Utiles.s.nextLine();
		jugador = new Jugador(nombreAlcalde);
		return jugador;
	}

}
