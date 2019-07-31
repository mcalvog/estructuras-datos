
public class Lista {

	protected Nodo primero;

	public Lista() {
		primero = null;
	}

	/**
	 * Insertar al principio de la lista
	 * 
	 * @param dato
	 */
	public void insertarCabezaLista(Object dato) {
		Nodo nuevo = new Nodo(dato);
		nuevo.setEnlace(primero);

		primero = nuevo;
	}

	/**
	 * Insertar elemento como antecesor
	 * 
	 * @param anterior
	 * @param dato
	 */
	public void insertarLista(Nodo anterior, Object dato) {
		Nodo nuevo = new Nodo(dato);
		nuevo.setEnlace(anterior.getEnlace());

		anterior.setEnlace(nuevo);
	}

	/**
	 * Eliminar elemento de la lista
	 * 
	 * @param dato
	 */
	public void eliminar(Object dato) {
		Nodo actual = primero, anterior = null;

		while ((actual != null) && !actual.getDato().equals(dato)) {
			if (!actual.getDato().equals(dato)) {
				anterior = actual;
				actual = actual.getEnlace();
			}
		}

		if (actual != null) {
			// Se distingue entre que el nodo sea el cabecera
			// o del resto de la lista
			if (actual == primero) {
				primero = actual.getEnlace();
			} else {
				anterior.setEnlace(actual.getEnlace());
			}

			actual = null;
		}
	}

	/**
	 * Buscar un elemento en la lista
	 * 
	 * @param dato
	 * @return
	 */
	public Nodo buscarLista(Object dato) {
		Nodo n = primero;

		while (n != null) {
			if (dato.equals(n.getDato())) {
				return n;
			}

			n = n.getEnlace();
		}

		return null;
	}

	/**
	 * Buscar un elemento en la lista mediante su posicion
	 * 
	 * @param posicion
	 * @return
	 */
	public Nodo buscarPosicion(int posicion) {
		Nodo indice = primero;

		// La posicion tiene que ser mayor a cero
		if (posicion < 0)
			return null;

		for (int i = 1; i < posicion; i++) {
			if (indice == null) {
				break;
			}

			indice = indice.getEnlace();
		}

		return indice;
	}

	/**
	 * Visualizar contenido de la lista
	 */
	public void visualizar() {
		Nodo n = primero;

		while (n != null) {
			System.out.print(n.getDato() + ", ");
			n = n.getEnlace();
		}
	}

	/**
	 * Visualizar contenido de la lista mediante iterador
	 */
	public void visualizarIterador() {
		ListaIterador iterador = new ListaIterador(this);
		Object dato = iterador.siguiente(); // Primer elemento

		while (dato != null) {
			System.out.print(dato + ", ");
			dato = iterador.siguiente();
		}
	}

	public Nodo leerPrimero() {
		return primero;
	}

	public boolean esVacia() {
		return primero == null;
	}

}
