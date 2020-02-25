package grafos.tipos.matriz;

import grafos.recorrido.RecorridoAnchura;

public class GrafoMatriz {

	// esta clase define la matriz de adyacencia, el array de vertices y los metodos
	// para añadir nodos y arcos al grafo

	public static final int INFINITO = 0xFFFF;

	int numVerts;
	static int MaxVerts = 20;
	Vertice[] verts;
	int[][] matAd;

	// constructor
	public GrafoMatriz() {
		this(MaxVerts);
	}

	public GrafoMatriz(int mx) {
		matAd = new int[mx][mx];
		verts = new Vertice[mx];
		for (int i = 0; i < mx; i++)
			for (int j = 0; j < mx; j++)
				matAd[i][j] = 0;
		numVerts = 0;
	}

	// operaciones

	public void nuevoVertice(String nom) {
		boolean esta = numVertice(nom) >= 0;
		if (!esta) {
			Vertice v = new Vertice(nom);
			v.asigVert(numVerts);
			verts[numVerts++] = v;
		}
	}

	public int numVertice(String vs) {
		// busca e vertice en el array, si no lo encuentra devuelve -1
		Vertice v = new Vertice(vs);
		boolean encontrado = false;
		int i = 0;

		for (; (i < numVerts) && !encontrado;) {
			encontrado = verts[i].equals(v);
			if (!encontrado)
				i++;

		}
		return (i < numVerts) ? i : -1;
	}

	public void nuevoArco(String a, String b) throws Exception {
		int va, vb;
		va = numVertice(a);
		vb = numVertice(b);

		if (va < 0 || vb < 0)
			throw new Exception("Vértice no existe");
		matAd[va][vb] = 1;
	}

	public boolean adyacente(String a, String b) throws Exception {
		int va, vb;
		va = numVertice(a);
		vb = numVertice(b);
		if (va < 0 || vb < 0)
			throw new Exception("Vértice no existe");
		return matAd[va][vb] == 1;
	}
	
	public int getNumVerts() {
		return numVerts;
	}
	
	public int[][] getMatAd() {
		return matAd;
	}
	
	public Vertice[] getVerts() {
		return verts;
	}

	public void recorrerAnchura(String verticeOrigen) throws Exception {
		RecorridoAnchura ra = new RecorridoAnchura(this);
		int[] verticesProfundidad = ra.recorrer(verticeOrigen);

		System.out.print("El resultado de recorrer en profundidad es: ");
		for (int v : verticesProfundidad) {
			System.out.print(verts[v].nombre + ", ");
		}
	}

}
