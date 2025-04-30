package Terreno;

public class Cultivo {
	private String tipo;
	private int tiempoCrecimiento;
	private float valorVenta;
	private float costoCultivo;
	
	public Cultivo(String tipo, int tiempoCrecimiento, float valorVenta, float costoCultivo) {
		this.tipo = tipo;
		this.tiempoCrecimiento = tiempoCrecimiento;
		this.valorVenta = valorVenta;
		this.costoCultivo = costoCultivo;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public float getValorVenta() {
		return this.valorVenta;
	}
	
	public float getCostoCultivo() {
		return this.costoCultivo;
	}
	
	public int getTiempoCrecimiento() {
		return this.tiempoCrecimiento;
	}
}
