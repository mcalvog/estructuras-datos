package algoritmos;

import modelos.Libro;

public class Busqueda {

	public static Libro busquedaLineal(Libro[] libros, int clave) {
		for (int i = 0; i < libros.length; i++) {
			if (clave == libros[i].getNumero()) {
				// Posicion: i + 1
				return libros[i];
			}
		}

		return null;
	}

	public static Libro busquedaBinaria(Libro[] libros, int clave) {
		int first = 0;
		int middle;
		int last = libros.length - 1;

		while (first <= last) {
			middle = (first + last) / 2;

			if (clave == libros[middle].getNumero()) {
				// Posicion: middle + 1
				return libros[middle];
			} else {
				if (libros[middle].getNumero() > clave) {
					last = middle - 1;
				} else {
					first = middle + 1;
				}
			}
		}

		return null;
	}

}
