package grafos.algoritmos;

import grafos.tipos.lista.GrafoAdcia;

/**
 * Floyd
 * @author Marcos
 *
 */
public class TodoCaminoMinimo {
	private int[][] pesos;
	private int[][] traza;
	private int[][] d;
	private int n; // número de vértices

	public TodoCaminoMinimo(GrafoAdcia gp) {
		n = gp.numeroDeVertices();
		pesos = gp.getMatPeso();
		d = new int[n][n];
		traza = new int[n][n];
	}

	public void todosCaminosMinimo() {
		// matriz inicial es la de pesos.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				d[i][j] = pesos[i][j];
				traza[i][j] = -1; // indica que camino mas corto es el arco
			}
		}

		// Camino mínimo de un vértice a si mismo: 0
		for (int i = 0; i < n; i++) {
			d[i][i] = 0;
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if ((d[i][k] + d[k][j]) < d[i][j]) { // nuevo mínimo
						d[i][j] = d[i][k] + d[k][j];
						traza[i][j] = k;
					}
				}
			}
		}
	}

	public int getPeso(int desde, int hasta) {
		return d[desde][hasta];
	}

	/**
	 * Seguramente esté mal
	 * @param vi
	 * @param vj
	 */
	public void recuperaCamino(int vi, int vj) {
		int anterior = traza[vi][vj];
		
		if (vi != vj) {
			recuperaCamino(anterior, vj); // vuelve al último del último

			System.out.print(" -> V" + vj);
		} else {
			System.out.print("V" + vi);
		}
	}
}