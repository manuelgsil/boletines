package boletin7_arrays;

import java.util.Scanner;

public class Ejercicio5_notasAlumnosMenu {

	public static void main(String[] args) {

		/*
		 * Deseamos realizar un programa para el cálculo de ciertos valores con las
		 * notas de la clase. Queremos calcular la nota media, la nota más alta, la
		 * más baja, cuántos alumnos tienen una nota superior a la media y cuántos
		 * tienen una nota inferior a la media. El programa debe presentar un menú de
		 * opciones para que el usuario elija lo que desee hacer y también se
		 * presentarán los resultados. El array de notas se generará aleatoriamente
		 * con notas de 1 a 10.
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

		menuPrincipal(notasAlumnos);
	}

	private static void menuPrincipal(int[] notasAlumnos) {
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		String[] opcionesMenu;
		opcionesMenu = plantilaOpciones("1.Calcular nota media", "2.Ver la nota mas alta", "3.Ver la nota mas baja",
				"4.Numero de alumnos por encima de la media", "5.Numero de alumnos por debajo de la media");

		for (int i = 0; i < opcionesMenu.length; i++) {
			System.out.println(opcionesMenu[i]);
		}

		do {
			System.out.print("Escoja una opcion: ");
			opcion = sc.nextInt();
			eleccion(opcion, notasAlumnos);
		} while (opcion != 0);

	}

	private static void eleccion(int opcionUsuario, int[] notas) {
		Scanner sc = new Scanner(System.in);
		int media = calcularNotaMedia(notas);// la colocamos aqui porque la necesitamos para todo
		int resul;

		switch (opcionUsuario) {
		case 1:
			System.out.println("-----------------------------");
			System.out.println("La nota media ha sido de: " + media + " |");
			System.out.println("-----------------------------");
			break;
		case 2:
			resul = verNotaMasAlta(notas);
			System.out.println("---------------------------");
			System.out.println("La nota mas alta es: " + resul + " |");
			System.out.println("---------------------------");
			break;
		case 3:
			resul = verNotaMasBaja(notas);
			System.out.println("------------------------");
			System.out.println("La nota mas baja es: " + resul + " |");
			System.out.println("------------------------");
			break;
		case 4:
			resul=alumnosPorEncimaMedia(notas);
			System.out.println("------------------------");
			System.out.println("El numero de alumnos por encima de la media: " + resul + " |");
			System.out.println("------------------------");
			break;
		case 5:
			 resul=alumnosPorDebajoMedia(notas);
			 System.out.println("Numero de alumnos por debajo de la media: "+resul);
			 System.out.println("------------------------");
				System.out.println("El numero de alumnos por debajo de la media:  " + resul + " |");
				System.out.println("------------------------");
			break;
		case 0:
			break;
		default:
			System.out.println("Introduzca una opcion disponible");
			System.out.println("Si desea salir introduzca 0");
		}

	}

	private static int alumnosPorDebajoMedia(int[] arrayNotas) {
		int notamedia = calcularNotaMedia(arrayNotas);
		int cantidadAlumnosDebajoMedia = 0;
		for (int i = 0; i < arrayNotas.length; i++) {
			if (arrayNotas[i] < notamedia)
				cantidadAlumnosDebajoMedia++;
		}
		return cantidadAlumnosDebajoMedia;
	}

	private static int alumnosPorEncimaMedia(int[]arrayNotas) {
		int notamedia = calcularNotaMedia(arrayNotas);
		int cantidadAlumnosEncimaMedia = 0;
		for (int i = 0; i < arrayNotas.length; i++) {
			if (arrayNotas[i] > notamedia)
				cantidadAlumnosEncimaMedia++;
		}
		return cantidadAlumnosEncimaMedia;

	}

	private static int verNotaMasBaja(int[] notas) {
		int notaMasBaja = notas[0];

		for (int i = 0; i < notas.length; i++) {
			if (notas[i] < notaMasBaja)
				notaMasBaja = notas[i];
		}

		return notaMasBaja;
	}

	private static int verNotaMasAlta(int[] arrayNotas) {
		int notaMasAlta = arrayNotas[0];

		for (int i = 0; i < arrayNotas.length; i++) {
			if (arrayNotas[i] > notaMasAlta)
				notaMasAlta = arrayNotas[i];
		}

		return notaMasAlta;

	}

	private static int calcularNotaMedia(int[] arrayNotas) {
		int sumatorio = 0, resultado;
		for (int i = 0; i < arrayNotas.length; i++) {
			sumatorio = arrayNotas[i] + sumatorio;
		}
		resultado = sumatorio / 10;
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
