
public class ListaDoblementeEnlazada {

	private Nodo cabeza;

	/**
	 * Insertar elemento al principio de la lista
	 * 
	 * @param dato
	 */
	public void insertarCabezaLista(Object dato) {
		Nodo nuevo;
		nuevo = new Nodo(dato);
		nuevo.setAdelante(cabeza);

		if (cabeza != null) {
			cabeza.setAtras(nuevo);
		}

		cabeza = nuevo;
	}

	/**
	 * Insertar elemento despues de otro en la lista
	 * 
	 * @param anterior
	 * @param dato
	 */
	public void insertaDespues(Nodo anterior, Object dato) {
		Nodo nuevo;
		nuevo = new Nodo(dato);
		nuevo.setAdelante(anterior.getAdelante());

		if (anterior.getAdelante() != null)
			anterior.getAdelante().setAtras(nuevo);

		anterior.setAdelante(nuevo);
		nuevo.setAtras(anterior);
	}

	/**
	 * Eliminar elemento de la lista
	 * 
	 * @param dato
	 */
	public void eliminar(Object dato) {
		Nodo actual = cabeza;
		boolean encontrado = false;

		// Bucle de busqueda
		while ((actual != null) && (!encontrado)) {
			encontrado = (actual.getDato().equals(dato));

			if (!encontrado) {
				actual = actual.getAdelante();
			}
		}

		// Enlace de nodo anterior con el siguiente
		if (actual != null) {
			// Distingue entre nodo cabecera o resto de la lista
			if (actual == cabeza) {
				cabeza = actual.getAdelante();

				if (actual.getAdelante() != null) {
					actual.getAdelante().setAtras(null);
				}
			} else if (actual.getAdelante() != null) {
				// No es el ultimo nodo
				actual.getAtras().setAdelante(actual.getAdelante());
				actual.getAdelante().setAtras(actual.getAtras());
			} else {
				// Es el ultimo nodo
				actual.getAtras().setAdelante(null);
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
		Nodo n = cabeza;

		while (n != null) {
			if (dato.equals(n.getDato())) {
				return n;
			}

			n = n.getAdelante();
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
		Nodo indice = cabeza;

		// La posicion tiene que ser mayor a cero
		if (posicion < 0)
			return null;

		for (int i = 1; i < posicion; i++) {
			if (indice == null) {
				break;
			}

			indice = indice.getAdelante();
		}

		return indice;
	}

	/**
	 * Visualizar contenido de la lista
	 */
	public void visualizar() {
		Nodo n = cabeza;

		while (n != null) {
			System.out.print(n.getDato() + ", ");
			n = n.getAdelante();
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

	public Nodo leerCabeza() {
		return cabeza;
	}

	public boolean esVacia() {
		return cabeza == null;
	}

}
