import Interfaces.Tienda;
import ciudad.Ciudad;
import ciudad.Edificio;
import entidades.Jugador;
import utilidades.Utiles;

public class Principal {

	public static void main(String[] args) {
		
		String nombreCiudad;		
		Ciudad ciudad;
		Tienda tienda = new Tienda();
		
		System.out.println("Bienvenidos al Sim City");
		
		System.out.println("Ingrese el nombre de la ciudad que va a administrar");
		nombreCiudad = Utiles.s.nextLine();
		
		ciudad = new Ciudad(nombreCiudad, crearJugador());
		
		Edificio[] edificiosComprados = tienda.comprarEdificios(ciudad.getAlcalde());
		ciudad.setEdificios(edificiosComprados);
		
		

		Utiles.s.close();
	}

	private static Jugador crearJugador() {
		String nombreJugador;
		System.out.println("Ingrese su nombre");
		nombreJugador = Utiles.s.nextLine();
		return new Jugador(nombreJugador);
	}

}
