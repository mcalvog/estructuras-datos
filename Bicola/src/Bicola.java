
public class Bicola {

	protected Nodo frente;
	protected Nodo fin;

	public Bicola() {
		frente = fin = null;
	}

	/**
	 * Insertar elemento al principio de la cola
	 * 
	 * @param elemento
	 */
	public void insertarFrente(Object elemento) {
		Nodo a = new Nodo(elemento);

		if (colaVacia()) {
			fin = a;
		}

		a.setSiguiente(frente);
		frente = a;
	}

	/**
	 * Insertar elemento al final de la cola
	 * 
	 * @param elemento
	 */
	public void insertarFinal(Object elemento) {
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
	public Object quitarFrente() throws Exception {
		Object aux;

		if (!colaVacia()) {
			aux = frente.getDato();
			frente = frente.getSiguiente();
		} else {
			throw new Exception("Eliminar de una bicola vacia");
		}

		return aux;
	}

	/**
	 * Quitar elemento al final de la cola
	 * 
	 * @return
	 * @throws Exception
	 */
	public Object quitarFinal() throws Exception {
		Object aux;

		if (!colaVacia()) {
			if (frente == fin) {
				// La bicola dispone de un solo nodo
				aux = quitarFrente();
			} else {
				Nodo a = frente;

				while (a.getSiguiente() != fin) {
					a = a.getSiguiente();
				}

				// Siguiente del nodo anterior se pone a null
				a.setSiguiente(null);
				aux = fin.getDato();
				fin = a;
			}
		} else {
			throw new Exception("Eliminar de una bicola vacia");
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
			throw new Exception("Error: bicola vacia");
		}

		return frente.getDato();
	}

	/**
	 * Obtener el ultimo elemento de la cola
	 * 
	 * @return
	 * @throws Exception
	 */
	public Object finalCola() throws Exception {
		if (colaVacia()) {
			throw new Exception("Error: bicola vacia");
		}

		return fin.getDato();
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
