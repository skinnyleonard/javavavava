package interfaces;

import Terreno.Cultivo;
import entidades.Jugador;
import utiles.Utiles;

public class Mercado {
	String[][] cultivosStrings = {
            {"Maíz", "120", "5.0", "1.0"},
            {"Trigo", "90", "3.0", "0.75"},
            {"Soja", "150", "6.0", "1.20"},
            {"Girasol", "110", "4.0", "0.90"},
            {"Papa", "180", "2.5", "0.50"},
            {"Zanahoria", "100", "3.5", "0.60"},
            {"Tomate", "75", "7.0", "1.50"},
            {"Lechuga", "60", "2.0", "0.30"},
            {"Avena", "105", "2.8", "0.70"},
            {"Cebada", "115", "3.2", "0.80"},
            {"Centeno", "130", "3.1", "0.78"},
            {"Remolacha", "160", "2.2", "0.45"},
            {"Calabaza", "140", "4.5", "1.10"},
            {"Espinaca", "50", "5.5", "0.95"},
            {"Brócoli", "95", "6.2", "1.30"},
            {"Repollo", "85", "2.7", "0.55"},
            {"Coliflor", "100", "4.0", "0.85"},
            {"Pepino", "65", "3.8", "0.70"},
            {"Pimiento", "80", "5.8", "1.25"},
            {"Ajo", "210", "8.0", "1.80"},
            {"Cebolla", "190", "3.3", "0.65"},
            {"Arveja", "70", "4.2", "0.90"},
            {"Poroto", "125", "4.8", "1.05"},
            {"Lenteja", "110", "3.9", "0.82"},
            {"Batata", "155", "2.9", "0.60"},
            {"Rábano", "30", "1.5", "0.25"},
            {"Zapallo", "135", "4.1", "0.98"},
            {"Maíz Dulce", "95", "5.3", "1.15"},
            {"Alfalfa", "365", "1.8", "0.35"},
            {"Sorgo", "110", "2.6", "0.58"}
    };
	Jugador granjero;
	int CANT_MAX_COMPRA_CULTIVOS = 25;
	
	public Cultivo[] comprarCultivos(Jugador granjero) {
		System.out.println("Bienvenido a la tienda " + granjero.getNombre());
		Cultivo[] cultivosCompradosAux = new Cultivo[CANT_MAX_COMPRA_CULTIVOS];
		int cantCultivosComprados = 0;
		
		boolean fin = false;
		
		do{
			fin = false;
			System.out.println("Elija el cultivo a comprar : ");
			mostrarCultivos();
			int cultivoElegido = Utiles.ingresarEntero(1, cultivosStrings.length)-1;
			
			final String tipo = cultivosStrings[cultivoElegido][0];
			final int tiempoCrecimiento = Integer.valueOf(cultivosStrings[cultivoElegido][1]);
			final float valorVenta = Float.valueOf(cultivosStrings[cultivoElegido][2]);
			final float costoCultivo = Float.valueOf(cultivosStrings[cultivoElegido][3]);
			
			Cultivo cultivo = new Cultivo(tipo, tiempoCrecimiento, valorVenta, costoCultivo);
			cultivosCompradosAux[cantCultivosComprados++] = cultivo;
			
			System.out.print("Desea comprar mas cultivos? (0 = NO; 1 = SI) : ");
			int opc = Utiles.ingresarEntero(0, 1);
			if(opc == 1) {
				fin = false;
			} else {
				fin = true;
			}
			
			if(cantCultivosComprados==25) {
				System.out.println("Ya alcanzo el limite maximo de compra");
				fin=true;
			}
			
		}while(!fin);
		
		Cultivo[] cultivosCompradosFinal = new Cultivo[cantCultivosComprados];
		
		for (int i = 0; i < cultivosCompradosFinal.length; i++) {
			cultivosCompradosFinal[i] = cultivosCompradosAux[i];
		}
		
		return cultivosCompradosFinal;
	}

	private void mostrarCultivos() {
		for (int i = 0; i < cultivosStrings.length; i++) {
			final String tipo = cultivosStrings[i][0];
			final int tiempoCrecimiento = Integer.valueOf(cultivosStrings[i][1]);
			final float valorVenta = Float.valueOf(cultivosStrings[i][2]);
			final float costoCultivo = Float.valueOf(cultivosStrings[i][3]);
			
			System.out.println(i+1+") "+" Tipo: "+tipo+
										" Tiempo de crecimiento: "+tiempoCrecimiento+
										" Valor de venta: $"+valorVenta+
										" Costo de cultivo: $"+costoCultivo);
		}
	}
}
