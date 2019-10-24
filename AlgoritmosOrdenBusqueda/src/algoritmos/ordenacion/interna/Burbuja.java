package algoritmos.ordenacion.interna;

import modelos.Libro;

public class Burbuja {

	public static void ordenacionBurbuja(Libro[] libros) {
		int i, j;
		Libro tmp;

		for (i = 1; i < libros.length; i++) {
			for (j = libros.length - 1; j >= 1; j--) {
				if (libros[j].getNumero() < libros[j - 1].getNumero()) {
					tmp = libros[j];
					libros[j] = libros[j - 1];
					libros[j - 1] = tmp;
				}
			}
		}
	}

	public static void ordenacionBurbujaEficiente(Libro[] libros) {
		boolean desorden;
		int j;
		Libro tmp;

		do {
			desorden = false;

			for (j = libros.length - 1; j >= 1; j--) {
				if (libros[j].getNumero() < libros[j - 1].getNumero()) {
					tmp = libros[j];
					libros[j] = libros[j - 1];
					libros[j - 1] = tmp;

					desorden = true;
				}
			}
		} while (desorden);
	}

}
