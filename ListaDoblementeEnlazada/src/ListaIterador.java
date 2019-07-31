
public class ListaIterador {
	private Nodo primero, actual;

	public ListaIterador(ListaDoblementeEnlazada list) {
		primero = actual = list.leerCabeza();
	}

	/**
	 * Obtener el siguiente elemento de la lista
	 * 
	 * @return
	 */
	public Object siguiente() {
		Object elemento = null;

		if (actual != null) {
			elemento = actual.getDato();
			actual = actual.getAdelante();
		}

		return elemento;
	}

	public void reiniciar() {
		actual = primero;
	}
}
