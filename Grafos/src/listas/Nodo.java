package listas;

public class Nodo {
	
	Object dato;
	Nodo enlace;

	public Nodo(Object x) {
		dato = x;
		enlace = null;
	}

	public Nodo(Object x, Nodo n) {
		dato = x;
		enlace = n;
	}

	public Object leerDato() {
		return dato;
	}

	public Nodo siguiente() {
		return enlace;
	}
}
