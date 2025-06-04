package utiles;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Consola {

	public static Scanner s = new Scanner(System.in);
	
	public static int ingresarEntero(final int min, final int max) {
		int nro = 0;
		
		if(min > max) {
			System.err.println("el tecnico hizo algo mal, llamalo");
			System.exit(1);
		}
		
		boolean error = false;
		
		do {
			error = false;
			try {
				nro = s.nextInt();
				if(nro < min || nro > max) {
					System.out.println("Error. el numero esta fuera de rango");
					error = true;
				}
			} catch(InputMismatchException e){
				System.out.println("Error. tipo de dato erroneo");
			} catch(Exception e) {
				System.out.println("ni idea mano");
			} finally {
				s.nextLine();
			}
			
		}while(error);
		
		return nro;
	}
}
