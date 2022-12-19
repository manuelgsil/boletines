package boletin7_arrays;

import java.util.Scanner;

public class Ejercicio07_Vuelos {
	public static Scanner scInt = new Scanner(System.in);
	public static Scanner scString = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		 * Ejercicio 6: (Sistema de Reserva de Vuelos). Una pequeña compañía aérea acaba
		 * de comprar un ordenador para su sistema de reserva de vuelos. Escribir un
		 * programa que asigne asientos para cada vuelo del único avión de la compañía
		 * (capacidad: 20 asientos). El programa debe contemplar zona de fumadores y no
		 * fumadores. Los no fumadores ocuparan los asientos 1-15 y los fumadores el
		 * resto. Utiliza un array de una dimensión para representar los asientos del
		 * avión. Utiliza 0 para indicar asiento vacío y 1 asiento ocupado. El programa
		 * nunca debe hacer "overbooking", es decir, reasignar un asiento que ya está
		 * ocupado. Si la sección de fumadores se llena, el programa debe preguntar al
		 * pasajero si desea un asiento en la zona de no fumadores, y viceversa. Si
		 * acepta, entonces has de realizar la asignación de asiento correspondiente. Si
		 * no acepta, avise de la salida del próximo vuelo.
		 */

		// 1. necesito crear un metodo pregunte al usuario si quiere un viaje
		// Si la respuesta es afirmativa tendrá que cargarlo, podriamos

		int[] asientos = new int[20];

		asientos = cargarArray(asientos);

		preguntarUsuario(asientos);

	}

	private static int[] arrayAsientosLibres(int[] arrayACopiar, int tamanio) {

		int[] asientosLibres;
		int posicion = 0;
		asientosLibres = new int[tamanio];

		for (int i = 0; i < arrayACopiar.length; i++) {
			if (arrayACopiar[i] == 0) {
				asientosLibres[posicion] = i;
				posicion++;
			}

		}

		return asientosLibres;
	}

	private static void mostrarAsientos(int[] asientosLibres, int tamanioAsientos, int[] asientosAvion) {
		int asientosLibresNofumadores = 0, asientosLibresFumadores = 0;

		System.out.println(" * * *  A tener en cuenta * * * ");
		System.out.println("1.-Los asientos para no fumadores estan numerados del 1 al 15");
		System.out.println("2.-Los asientos para fumadores del 16 al 20");
		System.out.println();

		for (int i : asientosLibres) { // Identificamos el numero de asientos libres en cada secccion
			if ((i + 1) <= 15)
				asientosLibresNofumadores++;
			else
				asientosLibresFumadores++;
		}

		if (asientosLibresNofumadores == 0 && asientosLibresFumadores != 0) {
			System.out.println("Desea un asiento en la zona de fumadores?");
			System.out.println("Asientos libres en fumadores:" + asientosLibresFumadores);
			for (int i : asientosLibres) {
				if (i > 15) {
					System.out.print("nº asiento: " + i);
				}
			}
			asignarAsiento(asientosLibres, tamanioAsientos);
		} else if (asientosLibresFumadores == 0 && asientosLibresNofumadores != 0) {
			System.out.println("Desea un asiento en la zona de no fumadores?");
			System.out.println("Asientos libres en no fumadores: " + asientosLibresNofumadores);
			for (int i : asientosLibres) {
				if (i <= 15) {
					System.out.print("nº asiento: " + i);
				}
				asignarAsiento(asientosLibres, tamanioAsientos);
			}
		} else if (asientosLibresNofumadores == 0 && asientosLibresFumadores == 0)
			System.out.println("No hay asientos disponibles en este vuelo. El proximo saldrá mañana");

		else {
			System.out.println("Asientos libres en fumadores: " + asientosLibresFumadores);
			System.out.println("Asientos libres en no fumadores: " + asientosLibresNofumadores);
			System.out.print("nº asiento: ");
			for (int i : asientosLibres) {
				System.out.print(" " + (i + 1));
			}
			asignarAsiento(asientosAvion, tamanioAsientos);
		}

	}

	private static void asignarAsiento(int[] asientosAvion, int tamanioAsientos) {
		int opcionUsuario = 0;
		boolean bandera = false;

		System.out.println("\nQue asiento desea escoger?");
		opcionUsuario = scInt.nextInt();
		do {
			for (int i = 0; i < asientosAvion.length; i++) {
				if (opcionUsuario - 1 == i && asientosAvion[i] == 0) {
					asientosAvion[i] = 1;
					System.out.println("plaza reservada");
					bandera = true;
				} else if (opcionUsuario - 1 == i && asientosAvion[i] == 1) {
					System.out.println("Este asiento no se encuentra disponible");
					opcionUsuario = scInt.nextInt();
					i = 0;
					bandera = false;
				}
			}

		} while (!bandera);

		for (int i : asientosAvion) {
			System.out.print(i + " ");
		}
	}

	private static void comprobarAsientos(int[] asientos) {
		int[] asientosLibres;
		int zonaNofumadores = 0, zonaFumadores = 0, tamanioAsientosLibres;
		for (int i = 0; i < asientos.length; i++) {

			int disponibilidad = asientos[i];

			if (disponibilidad == 0 && (i) <= 15)
				zonaNofumadores++;

			else if (disponibilidad == 0 && i > 15)
				zonaFumadores++;
		}

		tamanioAsientosLibres = zonaFumadores + zonaNofumadores;

		asientosLibres = arrayAsientosLibres(asientos, tamanioAsientosLibres);

		mostrarAsientos(asientosLibres, tamanioAsientosLibres, asientos);

	}

	private static int[] cargarArray(int[] arrayParaCargar) {
		for (int i = 0; i < arrayParaCargar.length; i++) {
			if (i < 18)
				arrayParaCargar[i] = 0;
			else
				arrayParaCargar[i] = 1; // carga de array
		}
		return arrayParaCargar;
	}

	private static boolean comprobadorEleccion(String opcion, boolean eleccion) {

		while (!(opcion.equalsIgnoreCase("si") || opcion.equalsIgnoreCase("no"))) {
			System.out.println("introduzca una opcion valida");
			opcion = scString.nextLine();
		}

		if (opcion.equalsIgnoreCase("si"))
			eleccion = true;
		else
			eleccion = false;

		return eleccion;
	}

	private static void preguntarUsuario(int[] asientos) {
		String opcion = "";
		boolean eleccion = false;

		System.out.println("Desea reservar un billete? \n-Si.\n-No.");
		opcion = scString.nextLine();
		eleccion = comprobadorEleccion(opcion, eleccion);

		do {
			if (eleccion) {
				comprobarAsientos(asientos);
				System.out.println("Quiere reservar otra plaza?");
				opcion = scString.nextLine();
				eleccion = comprobadorEleccion(opcion, eleccion);
			}
		} while (eleccion);
		System.out.println("Adios!");
	}
}
