package Interfaces;

import entidades.Ciudad;
import entidades.Edificio;
import utilidades.Utiles;

public class Tienda {
	
	String[][] edificiosDisponibles = {
			//Nombre - Tipo - Seguridad - Prev Incendios - Felicidad - Precio 
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
			{"Estación de policía grande","Seguridad","9","0","9","300000"},
			{"Estación de policía mediana","Seguridad","7","0","5","200000"},
			{"Estación de policía chica","Seguridad","5","0","2","100000"},
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
	
	final int NOMBRE = 0, TIPO = 1, SEGURIDAD = 2, PREV_INCENDIOS = 3, FELICIDAD = 4, PRECIO = 5;
	
	public void comprarEdificios(Ciudad ciudad) {
		boolean fin = false;
		Edificio[] edificiosCompradosAux = new Edificio[edificiosDisponibles.length];
		int cantEdificiosComprados = 0;
		
		do {
			ciudad.mostrarDatos();
			mostrarEdificiosDisponibles();
			System.out.print("Su opción: ");
			int opcEdificio = Utiles.ingresarEntero(1,edificiosDisponibles.length)-1;
			System.out.println();
			final int PRECIO_EDIFICIO = Integer.parseInt(edificiosDisponibles[opcEdificio][5]);
			final String TIPO_BUSCADO = edificiosDisponibles[opcEdificio][1];
			
			if(ciudad.getAlcalde().dinero >= PRECIO_EDIFICIO) {
				boolean existeEdificio = buscarExistenciaTipoEdificio(edificiosCompradosAux,TIPO_BUSCADO, cantEdificiosComprados);
				
				if(existeEdificio) {
					System.out.println("No puede comprar este edificio por que ya poseee uno del mismo tipo");
				} else {
					final String NOMBRE = edificiosDisponibles[opcEdificio][0];
					final String TIPO = edificiosDisponibles[opcEdificio][1];
					final int SEGURIDAD = Integer.parseInt(edificiosDisponibles[opcEdificio][2]);
					final int PREV_INCENDIOS = Integer.parseInt(edificiosDisponibles[opcEdificio][3]);
					final int FELICIDAD = Integer.parseInt(edificiosDisponibles[opcEdificio][4]);
					final int PRECIO = Integer.parseInt(edificiosDisponibles[opcEdificio][5]);
					Edificio edificio = new Edificio(NOMBRE,TIPO,SEGURIDAD,PREV_INCENDIOS,FELICIDAD,PRECIO);
					edificiosCompradosAux[cantEdificiosComprados] = edificio;
					cantEdificiosComprados++;
					ciudad.getAlcalde().dinero -= PRECIO;
					System.out.println("Compra realizada con éxito");
					System.out.println("Datos actualizados");
					ciudad.mostrarDatos();
					System.out.println("Edificios adquiridos hasta el momento");
					System.out.println("-------------------------------------\n");
					mostrarEdificiosComprados(edificiosCompradosAux,cantEdificiosComprados);
				}
				
				System.out.println("Que desea hacer?");
				System.out.println("1) Seguir comprando");
				System.out.println("2) Finalizar compra");
				int opc = Utiles.ingresarEntero(1, 2);
				
				if(opc==2) {
					boolean cumpleVerificacion = verificarEdificiosTipos(edificiosCompradosAux, cantEdificiosComprados);
					if(cumpleVerificacion) {
						fin = true;
					} else {
						System.out.println("Debe tener un edificio de cada tipo para poder finalizar");
					}
				}
			} else {
				System.out.println("No tiene dinero suficiente para comprar este edificio");
				fin = true;
			}		
		} while(!fin);
		
		Edificio[] edificiosCompradosPosta = new Edificio[cantEdificiosComprados];
		
		for (int i = 0; i < edificiosCompradosPosta.length; i++) {
			edificiosCompradosPosta[i] = edificiosCompradosAux[i];
		}
		
		ciudad.edificios = edificiosCompradosPosta;
		
	}

	private void mostrarEdificiosComprados(Edificio[] edificiosCompradosAux, int cantEdificiosComprados) {
		for (int i = 0; i < cantEdificiosComprados; i++) {
			edificiosCompradosAux[i].mostrarDatos(i);
		}
	}

	private boolean verificarEdificiosTipos(Edificio[] edificiosComprados, int cantEdificiosComprados) {
		String[] tipos = obtenerTipos();
		boolean cumpleCondicion = true;
		int i = 0;
		
		while(i < tipos.length && cumpleCondicion) {
			int j = 0;
			boolean encontrado = false;
			while(j<cantEdificiosComprados && !encontrado) {
				if(tipos[i].equals(edificiosComprados[j].getTipo())) {
					encontrado = true;
				}
				j++;
			}
			if(!encontrado) {
				cumpleCondicion = false;
			}
			i++;
		}
		return cumpleCondicion;
	}

	private String[] obtenerTipos() {
		String[] tiposAux = new String[edificiosDisponibles.length]; 
		
		int indiceInicial = 0;
		boolean primerTipoGuardado = false;
		
		while(!primerTipoGuardado && indiceInicial < edificiosDisponibles.length) {
			
			if(!edificiosDisponibles[indiceInicial][1].equalsIgnoreCase("Maravilla")) {
				tiposAux[0] = edificiosDisponibles[indiceInicial][1];
				primerTipoGuardado = true;
			}
			
			indiceInicial++;
		}
		
		int cantTipos = 1;
		
		for (int i = indiceInicial; i < edificiosDisponibles.length; i++) {
			boolean encontrado = false;
			int j = 0;
			
			while(j < cantTipos && !encontrado ) {
				if(edificiosDisponibles[i][1].equals(tiposAux[j])) {
					encontrado = true;
				}
				j++;
			}
			
			if(!encontrado && !edificiosDisponibles[i][1].equals("Maravilla")) {
				tiposAux[cantTipos] = edificiosDisponibles[i][1];
				cantTipos++;
			}
		}
		
		String[] tipos = new String[cantTipos];
		
		for (int i = 0; i < tipos.length; i++) {
			tipos[i] = tiposAux[i];
		}
		
		return tipos;
	}

	private boolean buscarExistenciaTipoEdificio(final Edificio[] EDIFICIOS, final String TIPO_BUSCADO, final int CANT_EDIFICIOS_COMPRADOS) {
		int i = 0;
		boolean encontrado = false;
		while(i < CANT_EDIFICIOS_COMPRADOS && !encontrado) {
			final String TIPO = edificiosDisponibles[i][1];
			if(TIPO.equals(TIPO_BUSCADO)) {
				encontrado = true;
			}
			i++;
		}
		return encontrado;
	}

	private void mostrarEdificiosDisponibles() {
		for (int i = 0; i < edificiosDisponibles.length; i++) {
			final String NOMBRE = edificiosDisponibles[i][0];
			final String TIPO = edificiosDisponibles[i][1];
			final int SEGURIDAD = Integer.parseInt(edificiosDisponibles[i][2]);
			final int PREV_INCENDIOS = Integer.parseInt(edificiosDisponibles[i][3]);
			final int FELICIDAD = Integer.parseInt(edificiosDisponibles[i][4]);
			final int PRECIO = Integer.parseInt(edificiosDisponibles[i][5]);
			System.out.println((i+1) + ") " + NOMBRE + " (" + TIPO + ")");
			System.out.println("Seguridad: " + SEGURIDAD + " Prev. Incendios: " + PREV_INCENDIOS + " Felicidad: " + FELICIDAD + " | $" + PRECIO +"\n");
		}
	}


}
