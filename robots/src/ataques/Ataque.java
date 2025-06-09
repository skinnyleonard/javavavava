package ataques;

import debilidadesyfortalezas.Elemento;
import robots.Robot;
import utiles.Aleatorio;

public class Ataque {
	private TipoAtaque nombre;
	private int energia;
	private int danio;
	private int probabilidad;
	private Elemento elemento;
	
	public Ataque(TipoAtaque nombre, int energia, int danio, int probabilidad, Elemento elemento) {
		this.nombre = nombre;
		this.energia = energia;
		this.danio = danio;
		this.probabilidad = probabilidad;
		this.elemento = elemento;
	}

	public void mostrarDatos(int i) {
		System.out.println(i+1+") "+nombre.getNombreAtaque()+ " | Energia necesaria: "+this.energia+" | Daño: "+this.danio+" | probabilidad: "+this.probabilidad);
	}
	
	public int getDanio() {
		return danio;
	}
	
	public int getEnergia() {
		return energia;
	}
	
	
	public void efectoSecundario(Robot enemigo) {
		
	}
	
	public void ejecutar(Robot enemigo) {
		
		if(!Aleatorio.calcularProbabilidad(this.probabilidad)) {
			System.out.println("fallo");
			return;
		}
		if(this.danio>0) {
			int danioReal = this.danio;
			if(enemigo.buscarDebilidad(this.elemento)) {
				danioReal = this.danio*2;
			}
			if(enemigo.buscarResistencias(elemento)) {
				danioReal = this.danio/2;
			}
			
			enemigo.recibirDanio(danioReal);
		}
		efectoSecundario(enemigo);
	}
}
