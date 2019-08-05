
public class ColaArray {

	private int frente;
	private int fin;
	protected Object[] listaCola;

	public ColaArray(int tamMax) {
		frente = 0;
		fin = -1;
		listaCola = new Object[tamMax];
	}

	/**
	 * Insertar elemento al final de la cola
	 * 
	 * @param dato
	 * @throws Exception
	 */
	public void insertar(Object dato) throws Exception {
		if (!colaLlena()) {
			fin++;
			listaCola[fin] = dato;
		} else {
			throw new Exception("Error en la cola: Cola LLena");
		}
	}

	/**
	 * Eliminar elemento al frente de la cola
	 * 
	 * @return
	 * @throws Exception
	 */
	public Object quitar() throws Exception {
		if (!colaVacia()) {
			Object aux = listaCola[frente];

			for (int i = frente; i < fin; i++) {
				listaCola[i] = listaCola[i + 1];
			}

			listaCola[fin] = null;

			fin--;

			return aux;
		} else {
			throw new Exception("Cola vacia");
		}
	}

	/**
	 * Obtener el primer elemento de la cola
	 * 
	 * @return
	 * @throws Exception
	 */
	public Object frenteCola() throws Exception {
		if (!colaVacia()) {
			return listaCola[frente];
		} else {
			throw new Exception("Cola vacia");
		}
	}

	/**
	 * Obtener el ultimo elemento de la cola
	 * 
	 * @return
	 * @throws Exception
	 */
	public Object finalCola() throws Exception {
		if (!colaVacia()) {
			return listaCola[fin];
		} else {
			throw new Exception("Cola vacia");
		}
	}

	/**
	 * Vaciar cola
	 */
	public void borrarCola() {
		frente = 0;
		fin = -1;
	}

	/**
	 * Contar elementos de la cola
	 * 
	 * @return
	 */
	public int contarDatos() {
		int contador = 0;

		for (int i = 0; i < tamMax(); i++) {
			if (listaCola[i] != null) {
				contador++;
			}
		}

		return contador;
	}

	/**
	 * Imprimir elementos de la cola
	 */
	public void imprimir() {
		for (int i = 0; i < tamMax(); i++) {
			Object datoActual = listaCola[i];

			if (datoActual != null) {
				System.out.print(datoActual + ", ");
			}
		}
	}

	/**
	 * Obtener tamano maximo de la cola
	 * 
	 * @return
	 */
	public int tamMax() {
		return listaCola.length;
	}

	/**
	 * Comprobar si la cola esta vacia
	 * 
	 * @return
	 */
	public boolean colaVacia() {
		return frente > fin;
	}

	/**
	 * Comprobar si la cola esta llena
	 * 
	 * @return
	 */
	public boolean colaLlena() {
		return fin == tamMax() - 1;
	}

}
