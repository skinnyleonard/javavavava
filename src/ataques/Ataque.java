package ataques;

import 

enums.Elementos;
import personajes.Robot;
import utiles.Utiles;

public  abstract class Ataque {

	private String nombre;

	private int daño;
	private int probabilidad;
	private int costeEnergia;
	private Elementos elemento;
	
	
	public Ataque(String nombre,int daño, int probabilidad, int costeEnergia, Elementos elemento) {
		this.nombre = nombre;
		this.daño = daño;
		this.probabilidad = probabilidad;
		this.costeEnergia = costeEnergia;
		this.elemento = elemento;
	}
	
	
	public String getNombre() {
		return nombre;
	}


	public  void ejecutar(Robot caster,Robot target) {
		
		
		
		if (Utiles.comprobarChance(this.probabilidad)) {
			System.out.println("Fallo!");
			return;
		}
		
		if( this.daño >0) {
			int dañoReal = this.daño;
			if(target.buscarDebilidad(this.elemento)) {
				
				dañoReal = (int) this.daño * 2;
			}
			
			if(target.buscarResistencia(this.elemento)) {
				
				dañoReal = (int) this.daño / 2;
			}
			
			target.recibirDaño(dañoReal);
			
		}
		
		efectoSecundario(caster,target);
		
		
	}
	
	
	public void mostrarData(int indice) {
		System.out.println(indice + this.nombre + " coste: " + this.costeEnergia + " daño " + this.daño +  " probabilidad " + this.probabilidad);
	}
	
	public void efectoSecundario(Robot caster,Robot target) {
		
	}
	
	public int getCosteEnergia() {
		return costeEnergia;
	}
	
	
	
	
	
	
}
