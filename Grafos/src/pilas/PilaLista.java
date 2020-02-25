package pilas;

public class PilaLista {

	private NodoPila cima;

	public PilaLista() {
		cima = null;
	}

	// implementación operaciones

	/*
	 * operaciones insertar, quitar, cima acceden a la lista directamente con la
	 * referencia cima (apunta al último nodo apilado). Entonces, no se necesitan
	 * recorrer los nodos de la lista.
	 */

	public boolean pilaVacia() {
		return cima == null;
	}

	public void insertar(Object elemento) {
		NodoPila nuevo = new NodoPila(elemento);
		nuevo.siguiente = cima;
		cima = nuevo;
	}

	public Object quitar() throws Exception {
		if (pilaVacia())
			throw new Exception("Pila vacía, no se puede extraer.");

		Object aux = cima.elemento;
		cima = cima.siguiente;
		return aux;
	}

	public Object cimaPila() throws Exception {
		if (pilaVacia())
			throw new Exception("Pila vacía, no se puede leer la cima.");

		return cima.elemento;
	}

	public void limpiarPila() {
		NodoPila t;
		while (!pilaVacia()) {
			t = cima;
			cima = cima.siguiente;
			t.siguiente = null;
		}
	}

}
