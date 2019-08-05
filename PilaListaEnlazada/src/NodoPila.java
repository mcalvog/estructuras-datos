
public class NodoPila {

	private Object dato;
	private NodoPila siguiente;

	public NodoPila(Object dato) {
		this.dato = dato;
		siguiente = null;
	}

	public NodoPila(Object dato, NodoPila siguiente) {
		this.dato = dato;
		this.siguiente = siguiente;
	}

	public Object getDato() {
		return dato;
	}

	public NodoPila getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoPila siguiente) {
		this.siguiente = siguiente;
	}

}
