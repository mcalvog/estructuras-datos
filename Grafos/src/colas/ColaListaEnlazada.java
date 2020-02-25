package colas;

public class ColaListaEnlazada {

	protected Nodo frente;
	protected Nodo fin;

	public ColaListaEnlazada() {
		frente = null;
		fin = null;
	}

	public void insertar(Object elemento) {
		Nodo a = new Nodo(elemento);
		if (colaVacia()) {
			frente = a;
		} else {
			fin.siguiente = a;
		}
		fin = a;
	}

	public boolean colaVacia() {
		// TODO Auto-generated method stub
		return (frente == null);
	}

	public Object quitar() throws Exception {
		Object aux;
		if (!colaVacia()) {
			aux = frente.elemento;
			frente = frente.siguiente;
		} else
			throw new Exception("Eliminar de una cola vacía");

		return aux;
	}

	public void borrarCola() {
		while (frente != null) {
			frente = frente.siguiente;
		}
		System.gc();
	}

	public Object frenteCola() throws Exception {
		if (colaVacia()) {
			throw new Exception("Error. Cola vacía");
		}
		return frente.elemento;
	}
	
	public Nodo getFrente() {
		return frente;
	}

}
