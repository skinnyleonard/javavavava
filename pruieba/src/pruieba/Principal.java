package pruieba;

import Terreno.Cultivo;
import entidades.Estaciones;
import entidades.Jugador;
import interfaces.Mercado;
import utiles.Utiles;

public class Principal {

	public static void main(String[] args) {
		System.out.println("Bienvenido al gran juego de ser un granjero que compra cultivos y cosas de granja y verduras"); 
		
		Mercado mercado = new Mercado();
		Jugador granjero = crearJugador();
		Cultivo [] cultivosComprados = mercado.comprarCultivos(granjero);
		datosFinales(cultivosComprados, granjero);
	}
	
	private static void datosFinales(Cultivo cultivosComprados[], Jugador granjero) {
		System.out.println("----------------------------------------");
		System.out.println("Datos finales de: " +granjero.getNombre()+" "+granjero.getApellido()+" de "+granjero.getEdad()+" años"+" estacion del año favorita: "+granjero.getEstacion());
		for (int i = 0; i < cultivosComprados.length; i++) {
			System.out.print("Tipo: "+cultivosComprados[i].getTipo()+
					" - Tiempo de crecimiento: "+cultivosComprados[i].getTiempoCrecimiento()+
					" - Valor de Venta: "+cultivosComprados[i].getValorVenta()+
					" - Costo Cultivo: "+cultivosComprados[i].getCostoCultivo()
					+ "\n");
		}
		
		float auxVentas = 0;
		float auxCostos = 0;
		for (int i = 0; i < cultivosComprados.length; i++) {
			auxVentas += cultivosComprados[i].getValorVenta();
			auxCostos += cultivosComprados[i].getCostoCultivo();
		}
		System.out.print("[+]Rendimientos promedio: " +(auxVentas/auxCostos));
		
		auxVentas = Integer.MAX_VALUE;
		for (int i = 0; i < cultivosComprados.length; i++) {
			if(cultivosComprados[i].getValorVenta() < auxVentas) {
				
			}
		}
	}
	
	private static Jugador crearJugador() {
		String nombreJugador;
		String apellido;
		int edad;
		Estaciones estacion = null;
		int opc = 0;
		
		System.out.print("Ingrese un nombre : ");
		nombreJugador= Utiles.s.nextLine();
		
		System.out.print("Ingrese su apellido : ");
		apellido = Utiles.s.nextLine();
		
		System.out.print("Ingrese su edad : ");
		edad = Utiles.ingresarEntero(Integer.MIN_VALUE, 100);
		
		System.out.print("Que estacion te gusta? : ");
		opc = Utiles.ingresarEntero(1, 4);
		switch(opc) {
		case 1:{
			estacion = estacion.INVIERNO;
		}
		case 2:{
			estacion = estacion.OTOÑO;
		}
		case 3:{
			estacion = estacion.PRIMAVERA;
		}
		case 4:{
			estacion = estacion.VERANO;
		}
		}
		
		return new Jugador(nombreJugador, apellido, edad, estacion);
	}
}
