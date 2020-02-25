package grafos.recorrido;

import colas.ColaListaEnlazada;
import grafos.tipos.matriz.GrafoMatriz;

/**
 * Clase para recorrer en produndidad un GrafoAdcia
 * 
 * @author Marcos
 *
 */
public class RecorridoAnchura {

	private GrafoMatriz g;

	public RecorridoAnchura(GrafoMatriz g) {
		super();
		this.g = g;
	}

	public int[] recorrer(String verticeOrigen) throws Exception {
		ColaListaEnlazada cola = new ColaListaEnlazada();
		int w, v = g.numVertice(verticeOrigen);
		int[] itms = new int[g.getNumVerts()];

		for (int i = 0; i < g.getNumVerts(); i++) {
			itms[i] = GrafoMatriz.INFINITO;
		}

		itms[v] = 0; // vértice origen queda marcado
		cola.insertar(v);

		while (!cola.colaVacia()) {
			w = (int) cola.quitar();

			for (int u = 0; u < g.getNumVerts(); u++) {
				if ((g.getMatAd()[w][u] == 1) && (itms[u] == GrafoMatriz.INFINITO)) {
					// se marca vertice u con número de arcos hasta el
					itms[u] = itms[w] + 1;
					cola.insertar(new Integer(u));
				}
			}
		}

		return itms;
	}

}
