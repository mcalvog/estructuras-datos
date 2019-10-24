package algoritmos.ordenacion.interna;

import modelos.Libro;

public class Seleccion {

	public static void ordenacionSeleccion(Libro[] libros) {
		int i, j, k;

		for (i = 0; i < libros.length - 1; i++) {
			for (k = i, j = i + 1; j < libros.length; j++) {
				if (libros[j].getNumero() < libros[k].getNumero())
					k = j;

				if (k != i)
					intercambiar(libros, i, k);
			}
		}
	}

	private static void intercambiar(Libro[] libros, int i, int j) {
		Libro temp = libros[i];
		libros[i] = libros[j];
		libros[j] = temp;
	}

}
