package utiles;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import personajes.Robot;

public class Utiles {
	
	
	public static Scanner s = new Scanner(System.in);
	public static Random r = new Random();
	
	
	
	
	public static int ingresarEntero(int min,int max, Robot jugador) {
		int num = 0;
		boolean error =false;
		
		
		do {
			error = false;
			try {
				num = s.nextInt();
				
				if(num>max||num<min) {
					
					System.out.println("Numero fuera del rango de " + min + " " + max);
					error = true;
					
				}
				
			}
			catch(InputMismatchException e) {
				System.out.println(num);
				System.out.println("Error, tipo de dato no es un entero");
				error = true;
			}
			catch (Exception e) {
				System.out.println("Error del sistema");
				System.exit(1);
			}
			
			finally {
				String resto = s.nextLine();
				if(resto.toLowerCase().equals("moarenergy")) {
					System.out.println("Codigo secreto activado! + 500 de energia!");
					jugador.añadirEnergia(500);
				}
			}
			
			
			
			
		}while(error);
		
		return num;
		
	}
	
	public static int ingresarEntero(int min,int max) {
		int num = 0;
		boolean error =false;
		
		
		do {
			error = false;
			try {
				num = s.nextInt();
				
				if(num>max||num<min) {
					
					System.out.println("Numero fuera del rango de " + min + " " + max);
					error = true;
					
				}
				
			}
			catch(InputMismatchException e) {
				System.out.println(num);
				System.out.println("Error, tipo de dato no es un entero");
				error = true;
			}
			catch (Exception e) {
				System.out.println("Error del sistema");
				System.exit(1);
			}
			
			finally {
				s.nextLine();
				}
			
			
			
			
		}while(error);
		
		return num;
		
	}
	
	
	public static int generarNumeroEntreRango(int min, int max) {
		
		return r.nextInt(min,max);
		
	}
	
	
	public static boolean comprobarChance(int probabilidad) {
		int random = r.nextInt(100)+1;
		
		boolean acierto = random > probabilidad ?   true :  false;
		
		return acierto;
		
	}

}
