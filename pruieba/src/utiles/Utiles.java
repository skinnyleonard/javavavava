package utiles;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Utiles {
	
	public static Scanner s = new Scanner(System.in);
	
	public static int ingresarEntero(final int MIN, final int MAX) {

		if(MIN > MAX) {
			System.err.println("Error. El min no puede ser mayor al max. Llame a soporte técnico");
			System.exit(1);
		}
	
		int nro = 0;
		boolean error = false;
		
		do {
			error = false;
			try {
				nro = s.nextInt();
				if(nro < MIN || nro > MAX) {
					System.out.println("Error. El número no está dentro del rango requerido");
					error = true;
				}
			} catch(InputMismatchException e) {
				System.out.println("Error. Tipo de dato erroneo");
				error = true;
			} catch(Exception e) {
				System.out.println("Error no contemplado");
			} finally {
				s.nextLine();
			}
			
		} while(error);
		
		return nro;
		
	}

}
