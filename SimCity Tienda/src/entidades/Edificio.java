package entidades;

public class Edificio {
	
	private String nombre;
	private String tipo;
	private int seguridad, prevIncendios, felicidad, precio;
	
	public Edificio(String nombre, String tipo, int seguridad, int prevIncendios, int felicidad, int precio) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.seguridad = seguridad;
		this.prevIncendios = prevIncendios;
		this.felicidad = felicidad;
		this.precio = precio;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void mostrarDatos(int nro) {
		System.out.println((nro+1) + ") " + this.nombre + " (" + this.tipo + ")");
		System.out.println("Seguridad: " + this.seguridad + " Prev. Incendios: " + this.prevIncendios + " Felicidad: " + this.felicidad + " | $" + this.precio +"\n");
	}

}
