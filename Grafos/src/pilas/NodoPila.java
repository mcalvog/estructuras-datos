package pilas;

public class NodoPila {

	// declaramos que los elementos son de tipo Object para que sea una pila
	// gen�rica
	Object elemento;
	NodoPila siguiente;

	public NodoPila(Object x) {
		elemento = x;
		siguiente = null;
	}

}
