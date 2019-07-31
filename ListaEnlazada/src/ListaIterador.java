
public class ListaIterador {
	private Nodo primero, actual;

	public ListaIterador(Lista list) {
		primero = actual = list.leerPrimero();
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
			actual = actual.getEnlace();
		}

		return elemento;
	}

	public void reiniciar() {
		actual = primero;
	}
}
