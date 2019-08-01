
public class ListaCircular {

	private Nodo lc;

	public ListaCircular() {
		lc = null;
	}

	/**
	 * Insertar elemento en la lista
	 * 
	 * @param dato
	 */
	public void insertar(Object dato) {
		Nodo nuevo = new Nodo(dato);

		if (esVacia()) {
			nuevo.setEnlace(nuevo);
			lc = nuevo;
		} else {
			// Lista circular no vacia
			nuevo.setEnlace(lc.getEnlace());
			lc.setEnlace(nuevo);
		}
	}

	/**
	 * Eliminar elemento de la lista
	 * 
	 * @param dato
	 */
	public void eliminar(Object dato) {
		Nodo actual = lc;
		boolean encontrado = false;

		// bucle de búsqueda
		while ((actual.getEnlace() != lc) && (!encontrado)) {
			encontrado = actual.getEnlace().getDato().equals(dato);

			if (!encontrado) {
				actual = actual.getEnlace();
			}
		}

		encontrado = actual.getEnlace().getDato().equals(dato);

		// Enlace de nodo anterior con el siguiente
		if (encontrado) {
			Nodo p;
			p = actual.getEnlace(); // Nodo a eliminar

			if (lc == lc.getEnlace()) {
				// Lista con un solo nodo
				lc = null;
			} else {
				if (p == lc) {
					// Se borra el elemento referenciado por lc,
					// el nuevo acceso a la lista es el anterior
					lc = actual;
				}

				actual.setEnlace(p.getEnlace());
			}

			p = null;
		}
	}

	/**
	 * Vaciar lista
	 */
	public void borrarLista() {
		Nodo p;

		if (lc != null) {
			p = lc;

			do {
				p = p.getEnlace();
			} while (p != lc);
		} else {
			System.out.print("Lista vacia.");
		}

		lc = null;
	}

	/**
	 * Recorrer lista
	 */
	public void recorrer() {
		Nodo p;

		if (lc != null) {
			p = lc.getEnlace(); // siguiente nodo al de acceso
			do {
				System.out.print(p.getDato() + ", ");
				p = p.getEnlace();
			} while (p != lc.getEnlace());
		} else {
			System.out.print("Lista vacia.");
		}
	}

	public boolean esVacia() {
		return lc == null;
	}

}
