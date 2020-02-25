package grafos.recorrido;

import colas.ColaListaEnlazada;
import grafos.tipos.lista.GrafoAdcia;

/**
 * Clase para recorrer en produndidad un GrafoAdcia
 * @author Marcos
 *
 */
public class RecorridoProfundidad {

	private GrafoAdcia g;
	boolean[] visitados;

	public RecorridoProfundidad(GrafoAdcia g) {
		super();
		this.g = g;
		visitados = new boolean[g.getMaxVerts()];
	}

	/**
	 * Devuelve el recorrido en profundidad a partir del nombre de un vertice origen
	 * @param verticeOrigen
	 * @return
	 * @throws Exception
	 */
	public int[] recorrer(String verticeOrigen) throws Exception {
		ColaListaEnlazada recorridos = new ColaListaEnlazada();
		ColaListaEnlazada cola = new ColaListaEnlazada();
		int v = g.numVertice(verticeOrigen);
		int tamRecorridos = 0;

		recorridos.insertar(v);
		tamRecorridos++;

		if (!visitados[v]) {
			cola.insertar(v);
			visitados[v] = true;
		}
		
		while (!cola.colaVacia()) {
			cola.quitar();
			
			for (int i = 0; i < g.vertices().length; i++) {
				if (g.adyacente(verticeOrigen, g.vertices()[i].nomVertice()) && !visitados[i]) { // deberia entrar
					cola.insertar(i);
					int[] newL = recorrer(g.vertices()[i].nomVertice());
					for (int j = 0; j < newL.length; j++) {
						recorridos.insertar(newL[j]);
						tamRecorridos++;
					}

					visitados[i] = true;
				}
			}
		}

		int[] itms = new int[tamRecorridos];
		
		for (int k = 0; k < tamRecorridos; k++) {
			itms[k] = (int) recorridos.quitar();
		}

		return itms;
	}

}
