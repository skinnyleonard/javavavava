package ataques;

public enum TipoAtaque {
	METRALLETA("Metralleta"),
	ACIDO("Acido"),
	FUEGO("Fuego"),
	INTERFERENCIA("Interferencia electromagnetica"),
	ESCUDO("Escudo protector");
	
	private String nombreAtaque;
	
	TipoAtaque(String nombreAtaque) {
		this.nombreAtaque = nombreAtaque;
	}

	public String getNombreAtaque() {
		return nombreAtaque;
	}
}
