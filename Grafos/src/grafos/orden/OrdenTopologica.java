package grafos.orden;

import colas.ColaListaEnlazada;
import grafos.tipos.lista.Arco;
import grafos.tipos.lista.GrafoAdcia;
import grafos.tipos.lista.VerticeAdy;
import listas.ListaIterador;

public class OrdenTopologica {

	public static int gradoEntrada(GrafoAdcia g, int v) throws Exception {
		int cuenta = 0;
		
		for (int origen = 0; origen < g.numeroDeVertices(); origen++) {
			if (g.adyacente(origen, v)) // arco incidente a v
				cuenta++;
		}
		
		return cuenta;
	}

	// M�todo para obtener una ordenaci�n topol�gica.
	// Muestra los v�rtices que pasan a formar parte de la
	// ordenaci�n, y se guardan en T[]
	public static void ordenTopologica(GrafoAdcia g, int[] T) throws Exception {
		int[] arcosInciden;
		int v, w, nvert;
		ColaListaEnlazada cola = new ColaListaEnlazada();
		
		nvert = g.numeroDeVertices();
		arcosInciden = new int[nvert];
		
		// grado de entrada de cada v�rtice
		for (v = 0; v < nvert; v++) {
			arcosInciden[v] = gradoEntrada(g, v);
		}
		
		System.out.println("\n Ordenaci�n topol�gica ");
		
		for (v = 0; v < nvert; v++) {
			if (arcosInciden[v] == 0) {
				cola.insertar(new Integer(v));
			}
		}
		
		VerticeAdy[] vs = new VerticeAdy[nvert];
		vs = g.vertices();
		
		while (!cola.colaVacia()) {
			Integer a;
			Arco elemento;
			ListaIterador itl;
			int j = 0;
			a = (Integer) cola.quitar();
			w = a.intValue();
			System.out.print(" " + vs[w].toString());
			T[j++] = w;

			itl = new ListaIterador(g.listaAdyc(w)); // iterador de lista
			// decrementa grado entrada de v�rtices adyacentes
			while ((elemento = (Arco) itl.siguiente()) != null) {
				v = elemento.getDestino();
				arcosInciden[v]--;
				
				if (arcosInciden[v] == 0) {
					cola.insertar(new Integer(v));
				}
			}
		}
	}

}
