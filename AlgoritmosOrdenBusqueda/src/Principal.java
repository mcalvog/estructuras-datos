import algoritmos.Busqueda;
import algoritmos.ordenacion.interna.MergeSort;
import modelos.Libro;
import utils.Utils;

public class Principal {

	public static void main(String[] args) {
		Libro[] libros = crearLibros();
		mostrarLibros("Libros por defecto", libros);

		MergeSort.mergeSort(libros, 0, libros.length - 1);
		mostrarLibros("Libros mergeSort", libros);
		
		System.out.println();
		
		mostrarLibro("Busqueda binaria", Busqueda.busquedaBinaria(libros, 2));
	}

	private static Libro[] crearLibros() {
		Libro[] libros = new Libro[5];

		for (int i = 0; i < 5; i++) {
			libros[i] = new Libro(i, "Libro " + i);
		}

		Utils.shuffleArray(libros);

		return libros;
	}

	private static void mostrarLibros(String texto, Libro[] libros) {
		System.out.print(texto + ": ");

		for (int i = 0; i < libros.length; i++) {
			System.out.print(libros[i].getNombre() + ", ");
		}

		System.out.println();
	}

	private static void mostrarLibro(String texto, Libro libro) {
		System.out.print(texto + ": " + libro.getNombre());

		System.out.println();
	}

}
