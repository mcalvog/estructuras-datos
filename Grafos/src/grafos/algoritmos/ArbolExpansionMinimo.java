package grafos.algoritmos;

import grafos.tipos.lista.GrafoAdcia;

/**
 * Prim
 * 
 * @author Marcos
 *
 */
public class ArbolExpansionMinimo {
	private int[][] Pesos;
	private int n; // v�rtice origen y n�mero de v�rtices

	public ArbolExpansionMinimo(GrafoAdcia gp) {
		n = gp.numeroDeVertices();
		Pesos = gp.getMatPeso();
	}

	// implementaci�n del algoritmo
	public int arbolExpansionPrim() {
		int longMin, menor;
		int z;
		int[] coste = new int[n];
		int[] masCerca = new int[n];
		boolean[] W = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			W[i] = false; // conjunto vac�o
		}
		
		longMin = 0;
		W[0] = true; // se parte del v�rtice 0
		
		// inicialmente, coste[i] es la arista (0,i)
		for (int i = 1; i < n; i++) {
			coste[i] = Pesos[0][i];
			masCerca[i] = 0;
		}
		
		for (int i = 1; i < n; i++) { // busca v�rtice z de V-W mas cercano,
										// de menor longitud de arista, a alg�n v�rtice de W
			menor = coste[1];
			z = 1;
			
			for (int j = 2; j < n; j++) {
				if (coste[j] < menor) {
					menor = coste[j];
					z = j;
				}
			}
			
			longMin += menor;
			
			// se escribe el arco incorporado al �rbol de expansi�n
			System.out.println("V" + masCerca[z] + " -> " + "V" + z);
			W[z] = true; // v�rtice z se a�ade al conjunto W
			coste[z] = GrafoAdcia.INFINITO;
			
			// debido a la incorporaci�n de z,
			// se ajusta coste[] para el resto de v�rtices
			for (int j = 1; j < n; j++) {
				if ((Pesos[z][j] < coste[j]) && !W[j]) {
					coste[j] = Pesos[z][j];
					masCerca[j] = z;
				}
			}
		}
		
		return longMin;
	}
}
