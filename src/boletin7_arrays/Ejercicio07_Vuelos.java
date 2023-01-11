package boletin7_arrays;

import java.util.Random;
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

		int[] asientos = new int[20]; // Declaramos un ARRAY con 20 posiciones

		asientos = cargarArray(asientos); // llamamos al metodo que nos carga el array (en este caso podemos modificar
											// el metodo invocado
											// para cargarlo segun nuestras preferencias

		preguntarUsuario(asientos); // Este metodo tiene como funcion preguntar al usuario si desea reserver el
									// billete.
									// tendremos que introducir el array cargado para trabajar con el
									// posteriormente.

	}

	/**
	 * Este metodo nos sirve para cargar de manera automatica el array que simulará
	 * los asientos del avion.
	 * 
	 * @param arrayParaCargar. Introducimos el array que será cargado
	 * @return Devuelve el mismo array cargado
	 */
	private static int[] cargarArray(int[] arrayParaCargar) {

		Random aleatorio = new Random();

		for (int i = 0; i < arrayParaCargar.length; i++) {
			arrayParaCargar[i] = aleatorio.nextInt(-1, 1) + 1;
			; // Con esta formula asignamos valores entre 0 y 1

		}
		return arrayParaCargar;
	}

	/**
	 * Este metodo almacena es el menú principal del programa, donde le preguntamos
	 * al usuario si desea reservar un billete. contiene llamadas a distintos
	 * metodos. Como elemento principal nos encontramos un bucle do while que se
	 * ejecuta hasta que el usuario haya terminado de reservar sus billetes.
	 * 
	 * @see #comprobadorEleccion(String, boolean) #comprobarAsientos(int[])
	 * 
	 * 
	 * 
	 * @param asientos Debe introducirse el array que almacena las plazas del avion
	 */
	private static void preguntarUsuario(int[] asientos) {
		String opcion = "";
		boolean eleccion = false;

		System.out.println("Desea reservar un billete? \n-Si.\n-No."); // Le preguntamos al usuario si quiere reservar.
		opcion = scString.nextLine(); // Escaner para la recogida de datos
		eleccion = comprobadorEleccion(opcion, eleccion); // Llamada a método que nos permite reducir la cantidad de
															// codigo en este metodo
		// y por la cual se carga el booleano 'eleccion'.
		
		do { // Este bucle se ejecutará hasta que el valor de eleccion sea FALSE. 
			if (eleccion) { // si la eleccion es 'true' comprobaremos los asientos disponibles en el vuelo.
				comprobarAsientos(asientos);
				System.out.println("Quiere reservar otra plaza?");
				opcion = scString.nextLine();
				eleccion = comprobadorEleccion(opcion, eleccion);
			}
		} while (eleccion);
		System.out.println("Adios!");
	}

	/**
	 * Este metodo nos permite validar la opcion del usuario siendo las unicas
	 * opciones posibles 'si'o 'no'.
	 * 
	 * @param opcion   (Será introducida por el usuario)
	 * @param eleccion (el booleano estará
	 * @return Devuelve el valor booleano resultado del bucle condicional
	 */
	private static boolean comprobadorEleccion(String opcion, boolean eleccion) {

		while (!(opcion.equalsIgnoreCase("si") || opcion.equalsIgnoreCase("no"))) { // Con esta condicion solo marcamos
																					// dos opciones posibles
			System.out.println("introduzca una opcion valida"); // le pedimos al usuario que reintroduzca los datos
			opcion = scString.nextLine();
		}

		if (opcion.equalsIgnoreCase("si")) // Si la opcione es 'si' marcamos el booleano como true
			eleccion = true;
		else
			eleccion = false; // En el caso de que sea 'no' se establecerá como falso

		return eleccion;
	}

	/**
	 * Con este metodo comprobaremos la disponibilidad de los asientos en el array
	 * 
	 * @param asientos (el array que hemos cargado previamente que define la
	 *                 situación de los asientos)
	 */
	private static void comprobarAsientos(int[] asientos) {
		int[] asientosLibres; // creamos un nuevo array para posteriormente mostrarlo por pantalla segun
								// nuestras preferencias
		int zonaNofumadores = 0, // Variable para almacenar los asientos disponibles de la zona de No Fumadores
				zonaFumadores = 0, // Variable para almacenar los asientos disponibles de la zona de Fumadores
				tamanioAsientosLibres; // Con esta última variable crearemos un nuevo array que nos permitirá definir
										// la situación
		for (int i = 0; i < asientos.length; i++) {

			int disponibilidad = asientos[i]; // con esta variable declarada dentro del bucle vamos comprobando la
												// disponibilidad de los asientos

			if (disponibilidad == 0 && (i) <= 15) // Si resulta que está libre y es <=15 estará dentro de la zona de no
													// fumadores
				zonaNofumadores++; // y almacenamos aquí el numero

			else if (disponibilidad == 0 && i > 15) // Si resulta que está libre (=0) y es <=15 estará dentro de la zona
													// de fumadores
				zonaFumadores++; // y almacenamos aquí el numero
		}

		tamanioAsientosLibres = zonaFumadores + zonaNofumadores; // el numero de asientos libres sera igual a la suma de
																	// las variables anteriores

		asientosLibres = arrayAsientosLibres(asientos, tamanioAsientosLibres); // Llamamos a un metodo que nos permitirá
																				// cargar un array con los asientos
																				// disponibles
		// En esta llamada tiene como parametros el array original de los asientos y el
		// numero de asientos libres en total

		mostrarAsientos(asientosLibres, asientos);

	}

	/**
	 * 
	 * @param arrayACopiar Este array se corresponde al array original, el de los
	 *                     asientos que cargamos al principio
	 * @param tamanio      El tamanio sera el numero de asientos libres que hemos
	 *                     deducido anteriormente
	 * @return devolverá un array con los asientos disponibles
	 */
	private static int[] arrayAsientosLibres(int[] arrayACopiar, int tamanio) {

		int[] asientosLibres; // Declaramos un array que nos permita almacenar los asientos disponibles
		int posicion = 0; // nos apoyaremos en esta variable llamada posición para movernos dentro del
							// array
		asientosLibres = new int[tamanio]; // Con esta sentencia declaramos el tamanio de asientosLibres con la
											// informacion recabada anteriormente

		for (int i = 0; i < arrayACopiar.length; i++) { // Con este bucle nos moveremos en el array original para saber
														// asientos estan libres
			if (arrayACopiar[i] == 0) { // si resulta que está libre
				asientosLibres[posicion] = i; // copiaremos el asiento a nuestra nueva array en el valor de la posicion
												// que empieza en 0
				posicion++; // Una vez que hayamos copiado el asiento que está disponible, el valor auxiliar
							// de POSICION se incrementará desplazándose
							// el mismo número de veces que asientos haya disponibles en el ARRAY ORIGINAL.
			}

		}

		return asientosLibres; // Devolveremos el array asientos libres, es decir, la información exacta de
								// disponibilidad en el avion
	}

	/**
	 * Este metodo nos permitirá mostrar los asientos disponibles y reservar la
	 * opción del usuario a través del uso de un IF anidado
	 * 
	 * @param asientosLibres Este es el array que hemos cargado previamente con la
	 *                       situación de los asientos disponibles
	 * 
	 * @param asientosAvion
	 */
	private static void mostrarAsientos(int[] asientosLibres, int[] asientosAvion) {
		int asientosLibresNofumadores = 0, asientosLibresFumadores = 0;

		System.out.println(" * * *  A tener en cuenta * * * ");
		System.out.println("1.-Los asientos para no fumadores estan numerados del 1 al 15");
		System.out.println("2.-Los asientos para fumadores del 16 al 20");
		System.out.println();

		for (int i : asientosLibres) { // Volvemos a realizar una comprobación de que zona son de fumadores o no ya que
										// estamos analizando
			if ((i + 1) <= 15) // los asientos del arrayCopia, no el ORIGINAL, y con esta información
								// realizaremos unos condicionales que nos permitirán indicarle al usuario la
								// situación del avion
				asientosLibresNofumadores++;
			else
				asientosLibresFumadores++;
		}

		if (asientosLibresNofumadores == 0 && asientosLibresFumadores != 0) { // Si solo hay asientos en FUMADORES
			System.out.println("Desea un asiento en la zona de fumadores?");
			System.out.println("Asientos libres en fumadores:" + asientosLibresFumadores);
			for (int i : asientosLibres) {
				if (i > 15) {
					System.out.print(" " + (i + 1));
				}
			}
			asignarAsiento(asientosAvion);
		} else if (asientosLibresFumadores == 0 && asientosLibresNofumadores != 0) { // Si solo hay asientos en NO
																						// FUMADORES
			System.out.println("Desea un asiento en la zona de no fumadores?");
			System.out.println("Asientos libres en no fumadores: " + asientosLibresNofumadores);
			for (int i : asientosLibres) {
				if (i <= 15) {
					System.out.print(" " + (i + 1));
				}

			}
			asignarAsiento(asientosAvion);
		} else if (asientosLibresNofumadores == 0 && asientosLibresFumadores == 0) // SI no hay asientos libres en el
																					// avion
			System.out.println("No hay asientos disponibles en este vuelo. El proximo saldrá mañana");

		else { // Cuando hay en asientos en ambas zonas
			System.out.println("Asientos libres en fumadores: " + asientosLibresFumadores);
			System.out.println("Asientos libres en no fumadores: " + asientosLibresNofumadores);
			System.out.print("nº asiento: ");
			for (int i : asientosLibres) {
				System.out.print(" " + (i + 1));
			}
			asignarAsiento(asientosAvion);
		}

	}

	/**
	 * 
	 * @param asientosAvion recibe el array
	 */
	private static void asignarAsiento(int[] asientosAvion) {
		int opcionUsuario = 0; // Variable para almacenar la opciond el usuario
		boolean bandera = false; // booleano que utilizaremos para realizar un bucle hasta que escoja un asiento

		System.out.println("\nQue asiento desea escoger?");
		opcionUsuario = scInt.nextInt();
		do {
			for (int i = 0; i < asientosAvion.length; i++) {
				if (opcionUsuario - 1 == i && asientosAvion[i] == 0) { // le restamos 1 a la opcion del usuario ya que
																		// modificamos el array para mostrar
					asientosAvion[i] = 1; // los asientos empezando desde 1 y no desde 0. Así será mas coherente de cara
											// a él.
					System.out.println("plaza reservada"); // Si está disponible se cambiara a 1 en el indice del array
															// ORIGINAL.
					bandera = true; // Y se detiene el bucle
				} else if (opcionUsuario - 1 == i && asientosAvion[i] == 1) {
					System.out.println("Este asiento no se encuentra disponible");
					System.out.println("Introduzca un asiento disponible");
					opcionUsuario = scInt.nextInt();
					i = 0; // reiniciamos el bucle para que vuelva a repasar las posiciones
					bandera = false;
				}
			}

		} while (!bandera);

		/*
		 * for (int i : asientosAvion) { System.out.print(i + " "); }
		 */
	}
}
