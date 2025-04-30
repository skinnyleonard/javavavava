package ciudad;

public class Edificio {
	
	private String nombre;
	private String tipo;
	private int seguridad;
	private int prevIncendios;
	private int felicidad;
	private int precio;
	
	public Edificio(String nombre, String tipo, int seguridad, int prevIncendios, int felicidad, int precio) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.seguridad = seguridad;
		this.prevIncendios = prevIncendios;
		this.felicidad = felicidad;
		this.precio = precio;
	}
	
	public String getTipo() {
		return this.tipo;
	}

}
