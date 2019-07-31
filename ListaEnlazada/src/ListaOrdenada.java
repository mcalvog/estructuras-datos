
public class ListaOrdenada extends Lista {

	/**
	 * Insertar elemento ordenado (entero)
	 * 
	 * @param dato
	 */
	public void insertaOrden(int dato) {
		Nodo nuevo = new Nodo(dato);

		if (esVacia()) {
			primero = nuevo;
		} else if (dato < (int) primero.getDato()) {
			nuevo.setEnlace(primero);
			primero = nuevo;
		} else {
			// Busqueda del nodo anterior a partir del que se debe insertar
			Nodo anterior, p;
			anterior = p = primero;

			while ((p.getEnlace() != null) && (dato > (int) p.getDato())) {
				anterior = p;
				p = p.getEnlace();
			}

			if (dato > (int) p.getDato()) {
				// Se inserta despues del ultimo nodo
				anterior = p;
			}

			// Se procede al enlace del nuevo nodo
			nuevo.setEnlace(anterior.getEnlace());
			anterior.setEnlace(nuevo);
		}
	}

}
