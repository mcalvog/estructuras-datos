package arbol;

/**
 * Arbol binario avanzado - Con la ayuda de:
 * https://aprenderaprogramar.com/foros/index.php?topic=1428.0.
 * 
 * @author Marcos Angel Calvo Garcia
 *
 */
public class ArbolBinario {

	private Nodo raiz;
	private int altura;

	public ArbolBinario() {
		raiz = null;
	}

	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}

	/**
	 * Recorrer arbol en preorden
	 * @param n
	 */
	public void recorridoPreOrden(Nodo n) {
		if (n != null) {
			System.out.print(n.getInfo() + ", ");
			recorridoPreOrden(n.getIzquierdo());
			recorridoPreOrden(n.getDerecho());
		}
	}

	/**
	 * Recorrer arbol en orden
	 * @param n
	 */
	public void recorridoEnOrden(Nodo n) {
		if (n != null) {
			recorridoEnOrden(n.getIzquierdo());
			System.out.print(n.getInfo() + ", ");
			recorridoEnOrden(n.getDerecho());
		}
	}

	/**
	 * Recorrer arbol en postorden
	 * @param n
	 */
	public void recorridoPostOrden(Nodo n) {
		if (n != null) {
			recorridoEnOrden(n.getIzquierdo());
			recorridoEnOrden(n.getDerecho());
			System.out.print(n.getInfo() + ", ");
		}
	}

	/**
	 * Insertar dato en el arbol
	 * @param datoInsertar
	 */
	public void insertar(int datoInsertar) {
		insertar(datoInsertar, raiz);
	}

	/**
	 * Insertar dato en el arbol partiendo de otro
	 * @param datoInsertar
	 * @param n
	 */
	public void insertar(int datoInsertar, Nodo n) {
		if (raiz == null)
			raiz = new Nodo(datoInsertar);
		else {
			if (datoInsertar < n.getInfo()) {
				if (n.getIzquierdo() == null)
					n.setIzquierdo(new Nodo(datoInsertar));
				else
					insertar(datoInsertar, n.getIzquierdo());
			} else {
				if (n.getDerecho() == null)
					n.setDerecho(new Nodo(datoInsertar));
				else
					insertar(datoInsertar, n.getDerecho());
			}
		}
	}

	/**
	 * Comprobar si existe un dato en el arbol
	 * @param dato
	 * @return
	 */
	public boolean existe(int dato) {
		return buscar(dato) != null;
	}

	/**
	 * Buscar un dato en el arbol
	 * @param dato
	 * @return
	 */
	public Nodo buscar(int dato) {
		Nodo aux = raiz;

		while (aux != null) {
			if (dato == aux.getInfo()) {
				return aux;
			} else if (dato > aux.getInfo()) {
				aux = aux.getDerecho();
			} else {
				aux = aux.getIzquierdo();
			}
		}

		return null;
	}

	// Este metodo no es del todo efectivo, de hecho no termina de funcionar
	// Revisar metodo eliminar de arbol binario de busqueda, el cual elimina hojas
	/**
	 * Eliminar dato del arbol
	 * @param n
	 * @param dato
	 * @return
	 */
	public Nodo eliminar(Nodo n, int dato) {
		if (n == null) {
			System.out.println("No se encuentra el valor " + dato + " en el arbol.");
			return n;
		}

		// Se quiere eliminar la raiz!!
		if (dato == raiz.getInfo()) {
			raiz = null;
			return null;
		}

		if (dato == n.getInfo()) {
			if (n.getIzquierdo() == null) {
				return n.getDerecho();
			} else if (n.getDerecho() == null) {
				return n.getIzquierdo();
			}
		}

		if (dato < n.getInfo()) {
			n.setIzquierdo(eliminar(n.getIzquierdo(), dato));
		} else if (dato > n.getInfo()) {
			n.setDerecho(eliminar(n.getDerecho(), dato));
		}

		return n;
	}

	/**
	 * Contar los nodos del arbol
	 * @param n
	 * @return
	 */
	public int contarNodos(Nodo n) {
		int count = 0;

		if (n != null) {
			count++;
			count += contarNodos(n.getDerecho());
			count += contarNodos(n.getIzquierdo());
		}

		return count;
	}

	/**
	 * Contar los nodos del arbol entre otros dos
	 * @param n
	 * @param a
	 * @param b
	 * @return
	 */
	public int contarNodosEntre(Nodo n, int a, int b) {
		int count = 0;

		if (n != null && n.getInfo() >= a && n.getInfo() <= b) {
			count++;

			count += contarNodosEntre(n.getDerecho(), a, b);
			count += contarNodosEntre(n.getIzquierdo(), a, b);
		}

		return count;
	}

	/**
	 * Contar las hojas del arbol
	 * @param n
	 * @return
	 */
	public int contarHojas(Nodo n) {
		int count = 0;

		if (n != null) {
			if (n.getIzquierdo() == null && n.getDerecho() == null) {
				count++;
			}

			count += contarHojas(n.getIzquierdo());
			count += contarHojas(n.getDerecho());
		}

		return count;
	}

	/**
	 * Obtener altura del arbol desde un nivel determinado
	 * @param aux
	 * @param nivel
	 */
	public void altura(Nodo aux, int nivel) {
		if (aux != null) {
			altura(aux.getIzquierdo(), nivel + 1);
			altura = nivel;
			altura(aux.getDerecho(), nivel + 1);
		}
	}

	/**
	 * Obtener altura del arbol desde su nivel inicial
	 * @return
	 */
	public int getAltura() {
		altura(raiz, 0);
		return altura;
	}

	/**
	 * Imprimir un nivel de un arbol partiendo de un inicial y un final
	 * @param n
	 * @param nivelInicial
	 * @param nivelFinal
	 */
	public void imprimirNivel(Nodo n, int nivelInicial, int nivelFinal) {
		int altura = getAltura();
		if (nivelFinal > altura || nivelInicial > nivelFinal) {
			System.out.print("No existe el nivel " + nivelFinal + "!");
			return;
		}

		if (nivelInicial < nivelFinal) {
			imprimirNivel(n.getDerecho(), nivelInicial + 1, nivelFinal);
			imprimirNivel(n.getIzquierdo(), nivelInicial + 1, nivelFinal);
		} else if (nivelInicial == nivelFinal) {
			System.out.print(n.getInfo() + ", ");
		}
	}

	/**
	 * Imprimir un nivel de un arbol
	 * @param nivel
	 */
	public void imprimirNivel(int nivel) {
		imprimirNivel(raiz, 0, nivel);
	}

	// Metodo NO recursivo
	/**
	 * Buscar valor minimo del arbol
	 * @return
	 */
	public Nodo buscarMin() {
		if (raiz != null) {
			Nodo reco = raiz;

			while (reco.getIzquierdo() != null) {
				reco = reco.getIzquierdo();
			}

			return reco;
		}

		return null;
	}

	// Metodo recursivo
	/**
	 * Buscar valor minimo del arbol
	 * @return
	 */
	public Nodo buscarMinRecu(Nodo n) {
		if (n != null) {
			Nodo reco = n;

			if (reco.getIzquierdo() != null) {
				reco = buscarMinRecu(reco.getIzquierdo());
			}

			return reco;
		}

		return null;
	}

	// Metodo NO recursivo
	/**
	 * Buscar valor maximo del arbol
	 * @return
	 */
	public Nodo buscarMax() {
		if (raiz != null) {
			Nodo reco = raiz;

			while (reco.getDerecho() != null) {
				reco = reco.getDerecho();
			}

			return reco;
		}

		return null;
	}

	// Metodo recursivo
	/**
	 * Buscar valor maximo del arbol
	 * @return
	 */
	public Nodo buscarMaxRecu(Nodo n) {
		if (n != null) {
			Nodo reco = n;

			if (reco.getDerecho() != null) {
				reco = buscarMaxRecu(reco.getDerecho());
			}

			return reco;
		}

		return null;
	}

}
