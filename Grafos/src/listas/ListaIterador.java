package listas;

public class ListaIterador {
	
	private Nodo prm, actual;

	public ListaIterador(Lista list) {
		prm = actual = list.leerPrimero();
	}

	public Object siguiente() {
		Object elemento = null;
		if (actual != null) {
			elemento = actual.leerDato();
			actual = actual.siguiente();
		}
		return elemento;
	}

	public void inicIter() {
		actual = prm;
	}
}