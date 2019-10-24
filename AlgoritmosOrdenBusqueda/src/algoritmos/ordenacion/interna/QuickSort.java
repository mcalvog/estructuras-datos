package algoritmos.ordenacion.interna;

import modelos.Libro;

public class QuickSort {

	public static void quickSort(Libro[] libros, int primero, int ultimo) {
		Libro pivote, tmp;
		int i, j, central;
		central = (primero + ultimo) / 2;
		pivote = libros[central];
		i = primero;
		j = ultimo;

		do {
			while (libros[i].getNumero() < pivote.getNumero())
				i++;
			while (libros[j].getNumero() > pivote.getNumero())
				j--;
			
			if (i <= j) {
				tmp = libros[i];
				libros[i] = libros[j];
				libros[j] = tmp;
				i++;
				j--;
			}
			
		} while (i <= j);

		if (primero < j)
			quickSort(libros, primero, j);
		
		if (i < ultimo)
			quickSort(libros, i, ultimo);
	}

}
