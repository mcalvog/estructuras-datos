package listas;

public class Lista {
	
	private Nodo primero;

	public Lista() {
		primero = null;
	}

	public Lista insertarCabezaLista(Object entrada) {
		Nodo nuevo;
		nuevo = new Nodo(entrada);
		nuevo.enlace = primero;
		primero = nuevo;
		return this;
	}
	
	public Lista insertarFinal(Object entrada) {
		if (primero==null) {
			primero = new Nodo(entrada);
			return this;
		}
		
		Nodo ult = primero;
		
		while(ult != null) {
			ult = ult.enlace;
		}
		
		ult = new Nodo(entrada);
		
		return this;
	}

	public Nodo leerPrimero() {
		return primero;
	}

	public Lista insertarLista(Nodo anterior, Object entrada) {
		Nodo nuevo;
		nuevo = new Nodo(entrada);
		nuevo.enlace = anterior.enlace;
		anterior.enlace = nuevo;
		return this;
	}

	public Nodo eliminar(Object entrada) {
		Nodo eliminado = new Nodo(entrada);
		Nodo actual, anterior;
		actual = primero;
		anterior = null;
		while ((actual != null) && !actual.dato.equals(entrada)) {
			if (!actual.dato.equals(entrada)) {
				anterior = actual;
				actual = actual.enlace;
			}
		}

		if (actual != null) {
			if (actual == primero) {
				primero = actual.enlace;
			} else {
				anterior.enlace = actual.enlace;
			}
			actual = null;
		}
		
		return eliminado;
	}

	public Nodo buscarLista(Object destino) {
		Nodo indice;
		for (indice = primero; indice != null; indice = indice.enlace)
			if (indice.dato.equals(destino))
				return indice;
		return null;
	}
	
	public boolean colaVacia() {
		return (primero == null);
	}

	public void visualizar() {
		Nodo n;
		n = primero;
		while (n != null) {
			System.out.print(n.dato + " ");
			n = n.enlace;
		}
	}
}

