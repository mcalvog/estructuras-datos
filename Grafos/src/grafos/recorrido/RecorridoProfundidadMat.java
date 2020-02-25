package grafos.recorrido;

import grafos.tipos.matriz.GrafoMatriz;
import pilas.PilaLista;

/**
 * Clase para recorrer en produndidad un GrafoAdcia
 * 
 * @author Marcos
 *
 */
public class RecorridoProfundidadMat {

	private GrafoMatriz g;

	public RecorridoProfundidadMat(GrafoMatriz g) {
		super();
		this.g = g;
	}

	/**
	 * Devuelve el recorrido en profundidad a partir del nombre de un vertice origen
	 * 
	 * @param verticeOrigen
	 * @return
	 * @throws Exception
	 */
	public int[] recorrer(String org) throws Exception {
		int v, w;
		PilaLista pila = new PilaLista();
		int[] m;
		m = new int[g.getNumVerts()];
		// inicializa los vértices como no marcados
		v = g.numVertice(org);
		if (v < 0)
			throw new Exception(" Vértice origen no existe");
		for (int i = 0; i < g.getNumVerts(); i++)
			m[i] = GrafoMatriz.INFINITO;
		m[v] = 0; // vértice origen queda marcado
		pila.insertar(new Integer(v));
		while (!pila.pilaVacia()) {
			Integer cw;
			cw = (Integer) pila.quitar();
			w = cw.intValue();
			System.out.println("Vértice " + g.getVerts()[w] + " visitado");
			// inserta en la pila los adyacentes de w no marcados
			for (int u = 0; u < g.getNumVerts(); u++)
				// adyacente y no marcado
				if ((g.getMatAd()[w][u] == 1) && (m[u] == GrafoMatriz.INFINITO)) {
					pila.insertar(new Integer(u));
					m[u] = 1;
				}
		}
		return m;

	}

}
