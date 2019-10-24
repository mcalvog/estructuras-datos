package algoritmos.ordenacion.interna;

import modelos.Libro;

public class Inserccion {

	public static void ordenacionInserccion(Libro[] libros) {
		int p, j;
		Libro tmp;
		
		for (p = 1; p < libros.length; p++) {
			tmp = libros[p];
			j = p - 1;
			
			while ((j >= 0) && (tmp.getNumero() < libros[j].getNumero())) {
				libros[j + 1] = libros[j];
				j--;
			}
			
			libros[j + 1] = tmp;
		}
	}

}
