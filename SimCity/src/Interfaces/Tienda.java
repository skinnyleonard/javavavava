package Interfaces;

import ciudad.Edificio;
import entidades.Jugador;
import utilidades.Utiles;

public class Tienda {
	
	private String[][] edificiosEnVenta = {   //Nombre - Tipo - Seguridad - Prev Incendios - Felicidad - Precio 
		{"Rascascielos","Maravilla","0","0","10","900000"},
		{"Torre Eiffel","Maravilla","0","0","10","850000"},
		{"Arco del triunfo","Maravilla","0","0","9","700000"},
		{"Pirámide","Maravilla","0","0","9","600000"},
		{"Obelisco","Maravilla","0","0","8","450000"},
		{"Planta de energía eólica","Planta energética","0","0","10","500000"},
		{"Planta de energía solar","Planta energética","0","0","9","400000"},
		{"Planta de energía hidroeléctrica","Planta energética","0","0","8","300000"},
		{"Planta de energía de carbón","Planta energética","0","0","4","150000"},
		{"Empresa de agua corriente","Planta de agua","0","0","10","750000"},
		{"Obras de cañerias para agua potable","Planta de agua","0","0","9","500000"},
		{"Tanques de agua por manzana","Planta de agua","0","10","9","350000"},
		{"Pozos de agua","Planta de agua","0","0","7","200000"},
		{"Mega estación de policía","Seguridad","10","0","10","400000"},
		{"Estación de polocía grande","Seguridad","9","0","9","300000"},
		{"Estación de policía mediana","Seguridad","7","0","5","200000"},
		{"Estación de polocía chica","Seguridad","5","0","2","100000"},
		{"Mega estación de bomberos","Incendios","0","10","10","450000"},
		{"Estación de bomberos grande","Incendios","0","8","8","350000"},
		{"Estación de bomberos mediana","Incendios","0","7","6","250000"},
		{"Estación de bomberos chica","Incendios","0","6","5","150000"},
		{"Rutas","Caminos","0","0","10","400000"},
		{"Autopistas","Caminos","0","0","9","300000"},
		{"Avenidas","Caminos","0","0","8","200000"},
		{"Calles de asfalto","Caminos","0","0","6","150000"},
		{"Calles de tierra","Caminos","0","0","1","50000"},
		{"Reserva natural","Ecología","0","0","10","500000"},
		{"Parque polideportivo","Ecología","0","0","9","300000"},
		{"Parque grande","Ecología","0","0","8","200000"},
		{"Plaza","Ecología","0","0","7","100000"}};
	
	public Edificio[] comprarEdificios(Jugador jugador) {
		System.out.println("Bienvenido a la tienda " + jugador.getNombre());
		Edificio[] edificiosComprados = new Edificio[edificiosEnVenta.length];
		int cantEdificiosComprados = 0;
		int precioEdificioMasBarato = buscarPrecioEdificioMasBarato();
		boolean fin = false;
		do {
			System.out.println("Elija el edificio que desea comprar");
			mostrarMenuEdificios();
			int opcEdificioElegido = Utiles.ingresarEntero(1, edificiosEnVenta.length+1)-1;
			if(opcEdificioElegido != edificiosEnVenta.length) {
				final String NOMBRE = edificiosEnVenta[opcEdificioElegido][0];
				final String TIPO = edificiosEnVenta[opcEdificioElegido][1];
				final int SEGURIDAD = Integer.parseInt(edificiosEnVenta[opcEdificioElegido][2]);
				final int PREV_INCENDIOS = Integer.parseInt(edificiosEnVenta[opcEdificioElegido][3]);
				final int FELICIDAD = Integer.parseInt(edificiosEnVenta[opcEdificioElegido][4]);
				final int PRECIO = Integer.parseInt(edificiosEnVenta[opcEdificioElegido][5]);
				if(jugador.dinero >= PRECIO) {
					boolean encontrado = buscarExistenciaTipo(edificiosComprados, cantEdificiosComprados, edificiosEnVenta[opcEdificioElegido][1]);
					if(encontrado) {
						System.out.println("Ya dispone de un edificio del mismo tipo. No puede comprar otro edificio del mismo tipo.");
					} else {
						Edificio edificio = new Edificio(NOMBRE, TIPO, SEGURIDAD, PREV_INCENDIOS, FELICIDAD, PRECIO);
						edificiosComprados[cantEdificiosComprados++] = edificio;
						jugador.dinero -= PRECIO;
					}
				} else {
					System.out.println("No le alcanza el dinero para comprar este edificio");
				}
			} 
			
			System.out.println("Elija como desea proseguir");
			System.out.println("1) Seguir comprando");
			System.out.println("2) Finalizar compra");
			int opc = Utiles.ingresarEntero(1,2);
			
			if(opc==1) {
				if(jugador.dinero < precioEdificioMasBarato) {
					System.out.println("No le alcanza el dinero para comprar otro edificio");
					fin = true;
				}
			} else {
				fin = true;
			}
			
		} while(!fin);
		
		return edificiosComprados;
	}

	private int buscarPrecioEdificioMasBarato() {
		int iMin = 0;
		for (int i = 1; i < edificiosEnVenta.length; i++) {
			final int PRECIO = Integer.parseInt(edificiosEnVenta[i][5]);
			final int PRECIO_MIN = Integer.parseInt(edificiosEnVenta[iMin][5]);
			if(PRECIO_MIN > PRECIO) {
				iMin = i;
			}
		}
		return Integer.parseInt(edificiosEnVenta[iMin][5]);
	}

	private boolean buscarExistenciaTipo(Edificio[] edificiosComprados, int limite, String tipo) {
		int i = 0;
		boolean encontrado = false;
		while(i < limite && !encontrado) {
			if(tipo.equalsIgnoreCase(edificiosComprados[i].getTipo())) {
				encontrado = true;
			}
			i++;
		}
		return encontrado;
	}

	private void mostrarMenuEdificios() {
		for (int i = 0; i < edificiosEnVenta.length; i++) {
			final String NOMBRE = edificiosEnVenta[i][0];
			final String TIPO = edificiosEnVenta[i][1];
			final int SEGURIDAD = Integer.parseInt(edificiosEnVenta[i][2]);
			final int PREV_INCENDIOS = Integer.parseInt(edificiosEnVenta[i][3]);
			final int FELICIDAD = Integer.parseInt(edificiosEnVenta[i][4]);
			final int PRECIO = Integer.parseInt(edificiosEnVenta[i][5]);
			System.out.println((i+1) + ") Nombre: " + NOMBRE + " Tipo: " + TIPO + " Seguridad: " + SEGURIDAD + " Prev. inc: " + PREV_INCENDIOS + " Felicidad: " + FELICIDAD + " precio: $" + PRECIO);
			if(i == edificiosEnVenta.length-1) {
				System.out.println((i+2)+ ") Volver");
			}
		}
		
	}

}
