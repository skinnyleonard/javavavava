package robots;

import java.util.ArrayList;
import ataques.Ataque;
import debilidadesyfortalezas.Elemento;
import efectos.Efecto;

public class Robot {
	private TipoRobot tipoRobot;
	private int vida;
	private int energia;
	private Ataque[] ataques;
	private Elemento[] debilidades;
	private Elemento[] resistencias;
	private boolean defendiendo = false;
	private boolean activo = true;
	private ArrayList<Efecto> efectos = new ArrayList<Efecto>();
	
	public Robot(TipoRobot tipoRobot, int vida, int energia, Ataque[] ataques, Elemento[] debilidades, Elemento[] resistencias) {
		this.tipoRobot = tipoRobot;
		this.vida = vida;
		this.energia = energia;
		this.ataques = ataques;
		this.debilidades = debilidades;
		this.resistencias = resistencias;
	}
	
	public void anadirEfecto(Efecto efecto) {
		this.efectos.add(efecto);
//		efecto.producir();
	}
	
	public void aplicarEfecto(Robot enemigo) {
		int cont = 0;
		cont = cont + 1;
		for (int i = 0; i < efectos.size(); i++) {
			efectos.get(i).producir(enemigo, cont);
		}
	}
	
	public void eliminarEfecto(Efecto efecto) {
		this.efectos.remove(efecto);
	}

	public int getVida() {
		return vida;
	}
	
	public Ataque[] getAtaques() {
		return ataques;
	}
	
	public void mostrarAtaques(){
		for (int i = 0; i < ataques.length; i++) {
			ataques[i].mostrarDatos(i);
		}
	}

	public void recibirDanio(int cant) {
		if(this.defendiendo == true) {
			cant=cant/2;
		}
		this.vida-=cant;
		if(this.vida < 0) {
			this.vida = 0;
		}
	}
	
	public void restarEnergia(int cant) {
		this.energia-=cant;
	}

	public int getEnergia() {
		return energia;
	}
	
	public void cambiarGuardia() {
		this.defendiendo = true;
	}
	public void cambiarGuardiaAAtaque() {
		this.defendiendo = false;
	}
	
	public void cambiarEstado() {
		this.activo = false;
	}
	
	public void activar() {
		this.activo = true;
	}
	
	public boolean getEstado() {
		return this.activo;
	}
	
	public void atacar(Robot enemigo, int opc) {
//		System.out.println("EFECTOS DEL ARRAYLIST: ");
//		for (Efecto i : efectos) {
//			System.out.println(i);
//		}
		if(this.activo == false) {
			System.out.println("Te tienen inhabilitado");
			return;
		}
		if(this.energia <= 0) {
			System.out.println("te queste sin energia");
			return;
		}
		getAtaques()[opc-1].ejecutar(enemigo);
		restarEnergia(getAtaques()[opc-1].getEnergia());
	}

	public boolean buscarDebilidad(Elemento elemento) {
		if(comprobar(elemento, this.debilidades)) {
			return true;
		}else {			
			return false;
		}
	}
	
	public boolean buscarResistencias(Elemento elemento) {
		if(comprobar(elemento, this.resistencias)) {
			return true;
		}else {			
			return false;
		}
	}
	
	public boolean comprobar(Elemento elemento, Elemento[] array) {
		int i = 0;
		boolean encontrado = false;
		while(i<array.length && !encontrado){
			if(elemento.equals(array[i])) {
				encontrado = true;
			}
			i++;
		}
		
		return encontrado;
	}
}
