package utils;

import java.util.Random;

import modelos.Libro;

public class Utils {

	public static void shuffleArray(Libro[] array) {
		int index;
		Libro temp;
		Random random = new Random();

		for (int i = array.length - 1; i > 0; i--) {
			index = random.nextInt(i + 1);
			temp = array[index];
			array[index] = array[i];
			array[i] = temp;
		}
	}

	private static double calcularMediana(int[] numeros) {
		double mediana;
		int numElementos = numeros.length;

		if (numElementos % 2 == 0) { // Numero par elementos, calcular media de los dos elementos centrales
			int sumaMedios = numeros[numElementos / 2] + numeros[numElementos / 2 - 1];
			mediana = (double) sumaMedios / 2;
		} else { // Numero impar de elementos, devolver el elemento central
			mediana = numeros[numElementos / 2];
		}

		return mediana;
	}

	private static double calcularMedia(int[] numeros) {
		int numElementos = numeros.length;
		int cont = 0;

		for (int num : numeros) {
			cont += num;
		}

		return (double) cont / numElementos;
	}

}
