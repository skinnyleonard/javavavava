package personajes;

import java.util.ArrayList;
import java.util.Iterator;

import ataques.Ataque;
import enums.Elementos;
import estados.EstadoBase;

public  abstract class Robot {

	private String nombre;
	private int vida;
	private int maxVida;
	private int energia;
	private int maxEnergia;
	
	private Ataque[] ataques;
	private Elementos[] debilidades;
	private Elementos[] resistencia;
	
	
	
	private boolean activo = true;
	private boolean defendiendo = false;
	
	private ArrayList<EstadoBase> efectos =  new ArrayList<EstadoBase>();
	
	
	
	public Robot( String nombre, int vida, int energia, Ataque[] ataques, Elementos[] debilidades, Elementos[] resistencia) {
		
		this.nombre = nombre;
		this.vida = vida;
		this.energia = energia;
		this.ataques = ataques;
		this.debilidades = debilidades;
		this.resistencia = resistencia;
		this.maxVida = vida;
		this.maxEnergia =  energia;
	}
	
	
	
	public void atacar(int opcion, Robot rival) {
		
		if(this.energia<=0) {
			System.out.println("Te quedaste sin energia, reza que el otro tambien se quede sin");
			return;
		}
		
		
		if(!this.activo) {
			System.out.println("No podes hacer un turno actualmente");
			return;
		}
		
		Ataque ataqueElegido = ataques[opcion];
		gastarEnergia(ataqueElegido.getCosteEnergia());
		
		ataqueElegido.ejecutar(this, rival);
		
		
		
	}
	
	
	public boolean buscarDebilidad(Elementos elemento) {
		
		if(comprobarElementos(elemento, this.debilidades)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean buscarResistencia(Elementos elemento) {
		
		if(comprobarElementos(elemento, this.resistencia)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	private boolean comprobarElementos(Elementos elemento, Elementos[] array) {
		int i =0;
		boolean encontrado = false;
		do {
			
		if(elemento.equals(array[i])) {
			encontrado = true;
		}
		i++;
			
			
		}while(i< array.length && !encontrado );
		return encontrado;
	}
	
	
	public  void recibirDaño(int vida) {
		
		if(this.defendiendo) {
			vida = vida/2;
			System.out.println("Daño dividido en 2:" + vida);
		}
		
		System.out.println("Se recibio un ataque de " + vida + " daño");
		this.vida -= vida;
		if(this.vida<0) {
			this.vida = 0;
		}
		
	}
	
	public  void gastarEnergia(int energia) {
		System.out.println("Se gasto " + energia + " puntos de energia");
		this.energia -= energia;
		if(this.energia<0) {
			this.energia = 0;
		}
		
	}
	
	
	public void aplicarEfectos() {
		for (int i = 0; i < efectos.size(); i++) {
			efectos.get(i).efectoTurno();
		}
	}
	
	
	
	public void añadirEfecto(EstadoBase efecto) {
		this.efectos.add(efecto);
		efecto.entrada();
	}
	
	public void eliminarEfecto(EstadoBase efecto) {
		this.efectos.remove(efecto);
	}
	
	
	public void mostrarAtaques() {
		for(int i=0;i<ataques.length;i++) {
			ataques[i].mostrarData(i+1);
		}
	}
	
	
	public void mostrarEstadisticas() {
		System.out.println(this.nombre + " vida restante: " + this.vida + " energia restante: " + this.energia);
	}
	
	
	public void cambiarActivo() {
		this.activo = false;
	}
	
	public void activar() {
		this.activo = true;
	}
	
	public void cambiarGuardia() {
		this.defendiendo = !this.defendiendo;
	}
	
	public int getEnergia() {
		return this.energia;
	}
	
	
	public Ataque[] getAtaques() {
		return this.ataques;
	}
	
	public int getVida() {
		return this.vida;
	}
	
	public void añadirEnergia( int energia) {
		this.energia += energia;
		
		if(this.energia > this.maxEnergia) {
			this.energia = this.maxEnergia;
		}
	}
}
