
public class Principal {

	public static void main(String[] args) {
		ListaCircular lista = new ListaCircular();

		// Añadir 10 enteros mediante un bucle for
		for (int i = 0; i < 10; i++) {
			lista.insertar(i);
		}

		// Imprimir datos de la lista
		lista.recorrer();

		// Eliminar el 4
		lista.eliminar(4);

		System.out.println(); // Salto de linea

		// Imprimir datos de la lista
		lista.recorrer();
	}

}
