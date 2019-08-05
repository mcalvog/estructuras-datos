
public class PilaArray {

	private int cima;
	private Object[] listaPila;

	public PilaArray(int tamMax) {
		cima = -1;
		listaPila = new Object[tamMax];
	}

	/**
	 * Insertar elemento como cima de la pila
	 * 
	 * @param dato
	 * @throws Exception
	 */
	public void insertar(Object dato) throws Exception {
		if (pilaLlena()) {
			throw new Exception("La pila esta completa. Desbordamiento.");
		}

		cima++;
		listaPila[cima] = dato;
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

		Object aux = listaPila[cima];
		listaPila[cima] = null;
		cima--;
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

		return listaPila[cima];
	}

	/**
	 * Vaciar pila
	 */
	public void limpiarPila() {
		for (int i = 0; i < tamMax(); i++) {
			listaPila[i] = null;
		}

		cima = -1;
	}

	/**
	 * Contar elementos de la pila
	 * 
	 * @return
	 */
	public int contarDatos() {
		int contador = 0;

		for (int i = 0; i < tamMax(); i++) {
			if (listaPila[i] != null) {
				contador++;
			}
		}

		return contador;
	}

	/**
	 * Imprimir elementos de la pila
	 */
	public void imprimir() {
		for (int i = 0; i < tamMax(); i++) {
			Object datoActual = listaPila[i];

			if (datoActual != null) {
				System.out.print(datoActual + ", ");
			}
		}
	}

	/**
	 * Obtener tamano maximo de la pila
	 * 
	 * @return
	 */
	public int tamMax() {
		return listaPila.length;
	}

	/**
	 * Comprobar si la pila esta vacia
	 * 
	 * @return
	 */
	public boolean pilaVacia() {
		return cima == -1;
	}

	/**
	 * Comprobar si la pila esta llena
	 * 
	 * @return
	 */
	public boolean pilaLlena() {
		return cima == tamMax() - 1;
	}

}
