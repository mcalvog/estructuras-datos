package grafos.tipos.matriz;

/**
 * Vertice para GrafoMatriz
 * @author Marcos
 *
 */
public class Vertice {

	public String nombre;
	int numVertice;

	public Vertice(String x) {
		nombre = x;
		numVertice = -1;

	}

	public String nomVertice() {
		return nombre;
	}

	public boolean equals(Vertice n) {
		return nombre.equals(n.nombre);
	}

	public void asigVert(int n) {
		numVertice = n;
	}

	public String toString() {
		return nombre + "( " + numVertice + " )";
	}
}
