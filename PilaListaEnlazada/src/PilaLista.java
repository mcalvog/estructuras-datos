
public class PilaLista {

	private NodoPila cima;

	public PilaLista() {
		cima = null;
	}

	/**
	 * Insertar elemento como cima de la pila
	 * 
	 * @param elemento
	 */
	public void insertar(Object elemento) {
		NodoPila nuevo = new NodoPila(elemento, cima);
		cima = nuevo;
	}

	/**
	 * Quitar elemento cima de la pila
	 * 
	 * @return
	 * @throws Exception
	 */
	public Object quitar() throws Exception {
		if (pilaVacia()) {
			throw new Exception("Pila vacia, no se puede extraer.");
		}

		Object aux = cima.getDato();
		cima = cima.getSiguiente();
		return aux;
	}

	/**
	 * Obtener elemento cima de la pila
	 * 
	 * @return
	 * @throws Exception
	 */
	public Object cimaPila() throws Exception {
		if (pilaVacia()) {
			throw new Exception("Pila vacia, no se puede leer la cima.");
		}

		return cima.getDato();
	}

	/**
	 * Vaciar pila
	 */
	public void limpiarPila() {
		NodoPila n;

		while (!pilaVacia()) {
			n = cima;
			cima = cima.getSiguiente();
			n.setSiguiente(null);
		}
	}

	/**
	 * Contar elementos de la pila
	 * 
	 * @return
	 */
	public int contarDatos() {
		int contador = 0;
		NodoPila n = cima;

		while (n != null) {
			contador++;
			n = n.getSiguiente();
		}

		return contador;
	}

	/**
	 * Imprimir elementos de la pila
	 */
	public void imprimir() {
		NodoPila n = cima;

		while (n != null) {
			System.out.print(n.getDato() + ", ");
			n = n.getSiguiente();
		}
	}

	/**
	 * Comprobar si la pila esta vacia
	 * 
	 * @return
	 */
	public boolean pilaVacia() {
		return cima == null;
	}

}
