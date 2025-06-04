import peleadores.*;
import utiles.Aleatorio;
import utiles.Consola;

public class Principal {
//	private static Jugador jugador;
	private static Peleador peleador, enemigo;

	public static void main(String[] args) {
		peleador = elegirLuchador();
		enemigo = peleador.getNombre().equals("goku" ? new Freezer():new Goku());
		System.out.println("evidentemente elegiste a "+peleador.getNombre());
		batalla();
		
		Consola.s.close();
	}

	private static Peleador elegirLuchador() {
		System.out.print("desea ser goku o freezer? [1=goku, 2=freezer] : ");
		int opc = Consola.ingresarEntero(1, 2);
		switch(opc) {
		case 1:
			peleador = new Goku();
			break;
		case 2:
			peleador = new Freezer();
			break;
		}
		return peleador;
	}

	private static void batalla() {
		System.out.println("que empieze la batalla");
		
		int turno = Aleatorio.generarEntero(2);
		
		if(turno == 0) {
			System.out.println("turno de goku");
			peleador.
		}
		else {
			System.out.println("turno de freezer");
		}
	}
}
