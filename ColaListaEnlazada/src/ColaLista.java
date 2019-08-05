
public class ColaLista {

	protected Nodo frente;
	protected Nodo fin;

	public ColaLista() {
		frente = fin = null;
	}

	/**
	 * Insertar elemento al final de la cola
	 * 
	 * @param elemento
	 */
	public void insertar(Object elemento) {
		Nodo a = new Nodo(elemento);

		if (colaVacia()) {
			frente = a;
		} else {
			fin.setSiguiente(a);
		}

		fin = a;
	}

	/**
	 * Quitar elemento al frente de la cola
	 * 
	 * @return
	 * @throws Exception
	 */
	public Object quitar() throws Exception {
		Object aux;

		if (!colaVacia()) {
			aux = frente.getDato();
			frente = frente.getSiguiente();
		} else {
			throw new Exception("Eliminar de una cola vacia");
		}

		return aux;
	}

	/**
	 * Obtener el primer elemento de la cola
	 * 
	 * @return
	 * @throws Exception
	 */
	public Object frenteCola() throws Exception {
		if (colaVacia()) {
			throw new Exception("Error: cola vacia");
		}

		return (frente.getDato());
	}

	/**
	 * Vaciar cola
	 */
	public void borrarCola() {
		while (frente != null) {
			frente = frente.getSiguiente();
		}

		// Reciclar elementos en memoria
		System.gc();
	}

	/**
	 * Contar elementos de la cola
	 * 
	 * @return
	 */
	public int contarDatos() {
		int contador = 0;
		Nodo n = frente;

		while (n != null) {
			contador++;
			n = n.getSiguiente();
		}

		return contador;
	}

	/**
	 * Imprimir elementos de la cola
	 */
	public void imprimir() {
		Nodo n = frente;

		while (n != null) {
			System.out.print(n.getDato() + ", ");
			n = n.getSiguiente();
		}
	}

	/**
	 * Comprobar si la cola esta vacia
	 * 
	 * @return
	 */
	public boolean colaVacia() {
		return frente == null;
	}

}
