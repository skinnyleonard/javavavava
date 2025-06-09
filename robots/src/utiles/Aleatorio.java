package utiles;

import java.util.Random;

public class Aleatorio {
	private static Random r = new Random();
	
	public static int generarEntero(final int num) {
		return r.nextInt(num);
	}

	public static int generarEntero(final int MIN, final int MAX){
        return r.nextInt(MAX - MIN + 1 ) + MIN;
    }
	
	public static boolean calcularProbabilidad(int probabilidad) {
		int rPorcentaje = r.nextInt(100) +1 ;
		boolean acierto = rPorcentaje > probabilidad ? true : false;
		System.out.println(rPorcentaje);
		return acierto;
	}
}
