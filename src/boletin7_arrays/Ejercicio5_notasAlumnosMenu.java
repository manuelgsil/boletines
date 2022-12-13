package boletin7_arrays;

import java.util.Scanner;

public class Ejercicio5_notasAlumnosMenu {

	public static void main(String[] args) {

		/*
		 * Deseamos realizar un programa para el cálculo de ciertos valores con las
		 * notas de la clase. Queremos calcular la nota media, la nota más alta, la más
		 * baja, cuántos alumnos tienen una nota superior a la media y cuántos tienen
		 * una nota inferior a la media. El programa debe presentar un menú de opciones
		 * para que el usuario elija lo que desee hacer y también se presentarán los
		 * resultados. El array de notas se generará aleatoriamente con notas de 1 a 10.
		 */

		int[] notasAlumnos = new int[10];
		int[] menuResultados = new int[5]; // Creamos un array que almacenará los resultados de la opcion del menu

		// 1.-Creamos un metodo para generar las notas aleatorias comprendias entre 1 y
		// 10
		// numAleatorio1_10();

		// 2.-Declaramos un array con las notas, en este caso tendremos 10 alumnos por
		// lo que sera un array de 10

		cargarArray(notasAlumnos);

		/*
		 * for (int i : notasAlumnos) { System.out.print(i+" "); }
		 */

		menuPrincipal();
	}

	private static void menuPrincipal() {
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		String[] opcionesMenu;
		opcionesMenu = plantilaOpciones("1.Calcular nota media", "2.Ver la nota mas alta", "3.Ver la nota mas baja",
				"4.Numero de alumnos por encima de la media", "5.Numero de alumnos por debajo de la media");

		for (int i = 0; i < opcionesMenu.length; i++) {
			System.out.println(opcionesMenu[i]);
		}
		System.out.print("Escoja una opcion: ");
		opcion=sc.nextInt();
		eleccion(opcion);

	}

	private static void eleccion(int opcionUsuario) {
		Scanner sc = new Scanner(System.in);
		do {
			switch (opcionUsuario) {
			case 1: calcularNotaMedia();
				break;
			case 2: verNotaMasAlta();
				break;
			case 3: verNotaMasBaja():
				break;
			case 4: alumnosPorEncimaMedia();
				break;
			case 5: alumnosPorDebajoMedia();
				break;
			default:
				System.out.println("Introduzca una opcion disponible");
				opcionUsuario=sc.nextInt();
			}
		} while (opcionUsuario > 5 || opcionUsuario <= 0);
			
		
	}

	private static void alumnosPorDebajoMedia(int[]arrayNotas) {
		
		for (int i = 0; i < arrayNotas.length; i++) {
			int j = arrayNotas[i];
			
		}
		
	}

	private static void alumnosPorEncimaMedia() {
		// TODO Auto-generated method stub
		
	}

	private static void verNotaMasBaja() {
		// TODO Auto-generated method stub
		
	}

	private static int verNotaMasAlta(int[]arrayNotas) {
		int resultado=0;
		return resultado;
		
		
	}

	private static int calcularNotaMedia(int []arrayNotas) {
		int sumatorio=0, resultado;
		for (int i = 0; i < arrayNotas.length; i++) {
			sumatorio=+arrayNotas[i];
		}
		resultado=sumatorio/10;
		return resultado;
	}

	private static String[] plantilaOpciones(String opcion1, String opcion2, String opcion3, String opcion4,
			String opcion5) {
		String[] opcionesMenu = { opcion1, opcion2, opcion3, opcion4, opcion5 };
		return opcionesMenu;
	}

	private static int numAleatorio1_10() {

		return (int) Math.floor(Math.random() * (10 - 1 + 1) + 1);
	}

	private static void cargarArray(int[] array_a_cargar) {

		for (int i = 0; i < array_a_cargar.length; i++) {
			array_a_cargar[i] = numAleatorio1_10(); // carga del array con el metodo aleatorio.
		}
	}
}
