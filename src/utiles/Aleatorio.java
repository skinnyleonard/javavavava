package utiles;

import java.util.Random;

public class Aleatorio {
	private static Random r = new Random();
	
	public static int generarEntero(final int num) {
		return r.nextInt(num);
	}
}
