package boletin7_arrays;

import java.util.Arrays;

public class Ejercicio2_arrayIntroducir100300 {

	public static void main(String[] args) {

		int[] array20 = new int[20];
		/*
		 * Ejercicio 2: Implementa un método que genere un array de 20 elementos, con
		 * números aleatorios comprendidos entre 100 y 300, de forma que no se repita
		 * ningún elemento.
		 */

		// 1. Debemos crear con la formula math. un metodo que nos cargue numeros
		// aleatorios
		// 2. Otro metodo reflexivo que compare un array consigo mismo
		// 3. Otro para cargar array

		cargarArray(array20);
		compararArray(array20);
		for (int i : array20) {
			System.out.print(i + " ");
		}

	}

	/**
	 * En este metodo realizamos un IF que nos permita comprobar la relacion entre
	 * los numeros y su posicion en el array.
	 * 
	 * @param comparacionReflexiva El array que queramos comparar consigo mismo.
	 * @param numero1              Introducimos el primer valor del array en
	 *                             determinada posicion
	 * @param numero2              Introducimos el segundo valor del array en
	 *                             determinada posicion
	 * @param posicion1            La posición en el array de numero1
	 * @param posicion2            La posición en el array de numero2
	 * @return Devuelve un valor booleano que nos indicará si es repetido o no.
	 */
	private static boolean comprobacionNumerosIguales(int[] comparacionReflexiva, int numero1, int numero2,
			int posicion1, int posicion2) {
		boolean resultado = false; // Variable local para almacenar el resultado

		if (numero1 == numero2 && posicion1 != posicion2) // Condicional que valora si el numero es repetido o no
			resultado = false; // Es decir, si los numeros son iguales y la posicion del numero 1 y numero 2
		else // son distintas, devuelve FALSE por lo cual, los numeros están repetidos
			resultado = true; // Si devuelve true, no son repetidos

		return resultado;

	}

	/**
	 * Genera un numero aleatorio entre 100 y 300
	 * 
	 * @return devuelve dicho numero aleatorio
	 */
	private static int numeroAleatorio100300() {

		return (int) Math.floor(Math.random() * (300 - 100 + 1) + 100);

	}

	/**
	 * Con este metodo comparamos el array introducido consigo mismo para ver si
	 * existen números repetidos. Contiene una llamada a otro metodo para comparar
	 * exactamente el numero y la posicion que ocupan en el array
	 * 
	 * @see {@link #comprobacionNumerosIguales(int[], int, int, int, int)}.
	 * @param array_a_comprobar
	 */
	private static void compararArray(int[] array_a_comprobar) {
		int numeroPrimerArray, numeroSegundoArray;
		boolean comprobacion = false;
		Arrays.sort(array_a_comprobar); // lo ordeno para mayor claridad y rapidez de ejecucion ya que si son iguales
										// estarán al lado

		for (int i = 0; i < array_a_comprobar.length; i++) { // Creamos un bucle for que recorrar el array
			numeroPrimerArray = array_a_comprobar[i]; // creamos una variable que almacene el valor del array en i
														// posicion

			for (int j = 0; j < array_a_comprobar.length; j++) { // Creamos otro bucle que nos sirva como auxiliar para
																	// comparar dicho array
				numeroSegundoArray = array_a_comprobar[j]; // creamos una variable que almacene el valor del array en j
															// posicion

				comprobacion = comprobacionNumerosIguales(array_a_comprobar, numeroPrimerArray, numeroSegundoArray, i,
						j); // A traves de una variable booleana almacenamos el resultado del metodo que
							// compara dichos numeros. En el metodo invocado se compara los valores y su
							// posicion.

				if (!comprobacion) { // Si el numero resultante de la comparacion es repetido, se cambia
					array_a_comprobar[i] = numeroAleatorio100300(); // el valor del array I, digamos el original.
					i = 0;
					Arrays.sort(array_a_comprobar); // Con esto lo vuelvo a ordenar y nos ayuda en la comparacion
				}
			}

		}

	}

	/**
	 * Con este metodo cargamos un array con los datos que queramos. En este caso,
	 * realizamos una llamada al metodo numeroAleatorio.
	 * 
	 * @see {@link #numeroAleatorio100300()}
	 * @param array_a_cargar
	 */
	private static void cargarArray(int[] array_a_cargar) {

		for (int i = 0; i < array_a_cargar.length; i++) {
			array_a_cargar[i] = numeroAleatorio100300(); // carga del array con el metodo aleatorio.
		}

	}

}
