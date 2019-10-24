package algoritmos.ordenacion.interna;

import modelos.Libro;

public class Shell {

	public static void ordenacionShell(Libro[] libros) {
		int incr = libros.length / 2, p, j;
		Libro tmp;
		
		do {
			for (p = incr + 1; p < libros.length; p++) {
				tmp = libros[p];
				j = p - incr;
				
				while ((j >= 0) && (tmp.getNumero() < libros[j].getNumero())) {
					libros[j + incr] = libros[j];
					j -= incr;
				}
				
				libros[j + incr] = tmp;
			}
			
			incr /= 2;
		} while (incr > 0);

	}

}
