package enums;

public enum Elementos {
	
	
	IMPACTO("Impacto") , CORROSION("Corrosion"), FUEGO("Fuego");

	
	private String nombre;
	
	
	private Elementos(String nobmre) {
		this.nombre = nombre;
	}
	
	
	
	 public String getNombre() {
		return nombre;
	}
	
	
	
}
