package algoritmos.ordenacion.interna;

import modelos.Libro;

public class HeapSort {

	public static void heapSort(Libro[] libros) {
		int n = libros.length;

		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(libros, n, i);

		// One by one extract an element from heap
		for (int i = n - 1; i >= 0; i--) {
			// Move current root to end
			Libro temp = libros[0];
			libros[0] = libros[i];
			libros[i] = temp;

			// call max heapify on the reduced heap
			heapify(libros, i, 0);
		}
	}

	private static void heapify(Libro[] libros, int n, int i) {
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < n && libros[l].getNumero() > libros[largest].getNumero())
			largest = l;

		// If right child is larger than largest so far
		if (r < n && libros[r].getNumero() > libros[largest].getNumero())
			largest = r;

		// If largest is not root
		if (largest != i) {
			Libro swap = libros[i];
			libros[i] = libros[largest];
			libros[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(libros, n, largest);
		}
	}

}
