package algoritmos.ordenacion.interna;

import modelos.Libro;

public class MergeSort {

	public static void mergeSort(Libro[] libros, int primero, int ultimo) {
		int central;

		if (primero < ultimo) {
			central = (primero + ultimo) / 2;
			mergeSort(libros, primero, central);
			mergeSort(libros, central + 1, ultimo);
			mezcla(libros, primero, central, ultimo);
		}
	}

	private static void mezcla(Libro[] libros, int izq, int medio, int der) {
		Libro[] tmp = new Libro[libros.length];
		int x, y, z;

		x = z = izq;
		y = medio + 1;

		while (x <= medio && y <= der) { // bucle de mezcla
			if (libros[x].getNumero() <= libros[y].getNumero())
				tmp[z++] = libros[x++];
			else
				tmp[z++] = libros[y++];
		}
		
		while (x <= medio) { // se copian elementos de sublistas
			tmp[z++] = libros[x++];
		}
		
		while (y <= der) { // se copian elementos de sublistas
			tmp[z++] = libros[y++];
		}
		
		for (z = izq; z <= der; z++) { // Los elementos del array temporal al final
			libros[z] = tmp[z];
		}

	}

}
