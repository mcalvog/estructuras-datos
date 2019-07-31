
public class Principal {

	public static void main(String[] args) {
		ListaDoblementeEnlazada lista = new ListaDoblementeEnlazada();

		// Añadir 10 enteros mediante un bucle for
		for (int i = 0; i < 10; i++) {
			lista.insertarCabezaLista(i);
		}

		// Imprimir datos de la lista
		lista.visualizar();

		// Eliminar el 4
		lista.eliminar(4);

		System.out.println(); // Salto de linea

		// Imprimir datos de la lista por iteracion
		lista.visualizarIterador();

		System.out.println(); // Salto de linea

		// Volver a insertar el 4, despues del 5
		lista.insertaDespues(lista.buscarLista(5), 4);

		// Imprimir datos de la lista
		lista.visualizar();
	}

}
