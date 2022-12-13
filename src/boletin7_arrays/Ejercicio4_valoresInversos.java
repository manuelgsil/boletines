package boletin7_arrays;

public class Ejercicio4_valoresInversos {

	public static void main(String[] args) {

		/*
		 * Implementa un método que reciba como parámetro de entrada, un array, y
		 * devuelva otro array (return), con los elementos del primer array al revés
		 * (orden inverso).
		 */

		// 1. Declaramos dos arrays
		int arrayPrimero[] = { 0, 1, 2, 3, 4 }; // el primero cargado directamente
		int arraySegundo[];

		// 2. Creamos un metodo que nos permita copiar los valores
		// copiarValoresArray();

		presentarArray(arrayPrimero, "Array Original");

		arraySegundo = copiarValoresArray(arrayPrimero);

		presentarArray(arraySegundo, "Array Copiado");

	}

	private static void presentarArray(int[] array, String nombreArray) {

		System.out.print(nombreArray + "\n|");
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.print("|");
		System.out.println();
	}

	private static int[] copiarValoresArray(int[] arrayParaCopiar) {
		int tamanioArray = 0;
		int posicion = 0; // Creamos una variable de posicion que nos servirá para el array que queremos
							// obtener
		for (int i = 0; i <= arrayParaCopiar.length; i++) { // con este bucle obtenemos el tamaño
			tamanioArray = i;
		}

		int[] arrayAlReves = new int[tamanioArray]; // Con su tamaño creamos la array nueva

		for (tamanioArray = tamanioArray - 1; tamanioArray >= 0; tamanioArray--) {
			// Al obtener su tamaño, en este ciclo podemos utilizar su tamaño como inicio e
			// ir
			// descendiendo hasta llegar a la posicion 0.
			arrayAlReves[posicion] = arrayParaCopiar[tamanioArray]; // arrayAlReves empezara en posicion 0
			posicion++; // e iremos sumándola. El array a copiar empezara en hueco final (5) e irá
						// descendiendo
			// hasta llegar a 0 por lo cual obtenemos los valores de manera inversa.
		}

		return arrayAlReves;

	}

}
