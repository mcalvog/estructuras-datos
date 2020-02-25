package grafos.tipos.lista;

import grafos.algoritmos.CaminoMinimo;
import grafos.algoritmos.TodoCaminoMinimo;
import grafos.recorrido.RecorridoProfundidad;
import listas.Lista;
import listas.Nodo;

public class GrafoAdcia {

	public static final int INFINITO = 0xFFFF;
	int numVerts;
	static int maxVerts = 20;
	VerticeAdy[] tablAdc;
	boolean[] visitados;
	int[][] matPeso;

	public GrafoAdcia(int mx) {
		tablAdc = new VerticeAdy[mx];
		numVerts = 0;
		maxVerts = mx;
		visitados = new boolean[mx];
		matPeso = new int[mx][mx];
		
		for (int i=0; i<mx; i++) {
			for (int j=0; j<mx; j++) {
				matPeso[i][j] = INFINITO;
			}
		}
	}

	public GrafoAdcia() {
		this(maxVerts);
	}

	public int numeroDeVertices() {
		return numVerts;
	}

	public VerticeAdy[] vertices() {
		return tablAdc;
	}

	// La operación listaAdyc() devuelve la lista de adyacencia del vértice v.
	public Lista listaAdyc(int v) throws Exception {
		if (v < 0 || v >= numVerts)
			throw new Exception(" Vértice fuera de rango ");
		return tablAdc[v].lad;
	}

	public void nuevoVertice(String nom) {
		boolean esta = numVertice(nom) >= 0;
		if (!esta) {
			VerticeAdy v = new VerticeAdy(nom);
			v.asigVert(numVerts);
			tablAdc[numVerts++] = v;
		}
	}
	
	public int pesoArco(String a, String b) {
		int va = numVertice(a);
		int vb = numVertice(b);
		return matPeso[va][vb];
	}

	// numVertice()busca el vértice en la tabla. Devuelve -1 si no lo encuentra:
	public int numVertice(String nm) {
		VerticeAdy v = new VerticeAdy(nm);
		boolean encontrado = false;
		int i = 0;
		for (; (i < numVerts) && !encontrado;) {
			encontrado = tablAdc[i].equals(v);
			if (!encontrado)
				i++;
		}
		return (i < numVerts) ? i : -1;
	}

	// Nueva arista
	public void nuevoArco(String a, String b, double peso) throws Exception {
		if (!adyacente(a, b)) {
			int va = numVertice(a);
			int vb = numVertice(b);
			if (va < 0 || vb < 0)
				throw new Exception("Vértice no existe");
			Arco ab = new Arco(vb, peso);
			tablAdc[va].lad.insertarCabezaLista(ab);
			matPeso[va][vb] = (int)peso;
		}
	}

	public void borrarArco(String a, String b) throws Exception {
		int va, vb;
		va = numVertice(a);
		vb = numVertice(b);
		if (va < 0 || vb < 0)
			throw new Exception("Vértice no existe");
		Arco ab = new Arco(vb);
		tablAdc[va].lad.eliminar(ab);
	}

	public boolean adyacente(String a, String b) throws Exception {
		int va, vb;
		va = numVertice(a);
		vb = numVertice(b);
		if (va < 0 || vb < 0)
			throw new Exception("Vértice no existe");
		if (tablAdc[va].lad.buscarLista(new Arco(vb)) != null)
			return true;
		else
			return false;
	}

	public boolean adyacente(int va, int vb) throws Exception {
		if (va < 0 || vb < 0)
			throw new Exception("Vértice no existe");
		if (tablAdc[va].lad.buscarLista(new Arco(vb)) != null)
			return true;
		else
			return false;
	}

	public Nodo nodoAdyacente(String a, String b) throws Exception {
		int va, vb;
		va = numVertice(a);
		vb = numVertice(b);
		if (va < 0 || vb < 0)
			throw new Exception("Vértice no existe");

		return tablAdc[va].lad.buscarLista(new Arco(vb));
	}
	
	public int getMaxVerts() {
		return maxVerts;
	}
	
	public int[][] getMatPeso() {
		return matPeso;
	}

	public void recorrerProfundidad(String verticeOrigen) throws Exception {
		RecorridoProfundidad rp = new RecorridoProfundidad(this);
		int[] verticesProfundidad = rp.recorrer(verticeOrigen);

		System.out.print("El resultado de recorrer en profundidad es: ");
		for (int v : verticesProfundidad) {
			System.out.print(vertices()[v].nombre + ", ");
		}
	}

	public void conectadas(String c1, String c2) {
		try {
			// ahorro de calculos, si el destino es adyacente al origen
			if (adyacente(c1, c2)) {
				Arco a = (Arco) nodoAdyacente(c1, c2).leerDato();
				System.out.println(c1 + " y " + c2 + " están conectadas. Distancia: " + (int) a.getPeso());
				return;
			} else {
				// si el destino no es adyacente al origen aplicar algoritmo dijkstra
				CaminoMinimo cm = new CaminoMinimo(this, numVertice(c1));
				cm.caminoMinimos();
				int peso = cm.getPesoHasta(numVertice(c2));
				
				if (peso != INFINITO) {
					System.out.println(c1 + " y " + c2 + " están conectadas. Distancia: " + peso);
					return;
				}
			}
		} catch (Exception e) {
			// nothing to do here
		}

		System.out.println(c1 + " y " + c2 + " NO están conectadas.");
	}

	public void conectadasFloyd(String c1, String c2) {
		try {
			// ahorro de calculos, si el destino es adyacente al origen
			if (adyacente(c1, c2)) {
				Arco a = (Arco) nodoAdyacente(c1, c2).leerDato();
				System.out.println(c1 + " y " + c2 + " están conectadas. Distancia: " + (int) a.getPeso());
				return;
			} else {
				// si el destino no es adyacente al origen aplicar algoritmo floyd
				TodoCaminoMinimo tcm = new TodoCaminoMinimo(this);
				tcm.todosCaminosMinimo();
				int peso = tcm.getPeso(numVertice(c1), numVertice(c2));
				
				if (peso != INFINITO) {
					System.out.println(c1 + " y " + c2 + " están conectadas. Distancia: " + peso);
					return;
				}
			}
		} catch (Exception e) {
			// nothing to do here
		}

		System.out.println(c1 + " y " + c2 + " NO están conectadas.");
	}
}
