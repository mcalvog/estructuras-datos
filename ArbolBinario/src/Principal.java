import arbol.ArbolBinario;

public class Principal {

	public static void main(String[] args) {
		ArbolBinario arbol = new ArbolBinario();
		arbol.insertar(10);
		arbol.insertar(5);
		arbol.insertar(13);
		arbol.insertar(1);
		arbol.insertar(6);
		arbol.insertar(17);
		arbol.insertar(12);

		// arbol.eliminar(arbol.getRaiz(), 12);

		System.out.print("Preorden: ");
		arbol.recorridoPreOrden(arbol.getRaiz());
		System.out.println();

		System.out.print("Enorden: ");
		arbol.recorridoEnOrden(arbol.getRaiz());
		System.out.println();

		System.out.print("Postorden: ");
		arbol.recorridoPostOrden(arbol.getRaiz());
		System.out.println();

		System.out.println("");

		System.out.println("Numero de nodos: " + arbol.contarNodos(arbol.getRaiz()));
		System.out.println("Numero de hojas: " + arbol.contarHojas(arbol.getRaiz()));
		System.out.println("Altura: " + arbol.getAltura());
		System.out.println("Nodos entre 5 y 13 (incluidos): " + arbol.contarNodosEntre(arbol.getRaiz(), 5, 13));
		
		System.out.println("");
		System.out.print("Nivel 2: ");
		arbol.imprimirNivel(2);

		System.out.println("\n");
		System.out.println("Minimo: " + arbol.buscarMin().getInfo());
		System.out.println("Minimo recu: " + arbol.buscarMinRecu(arbol.getRaiz()).getInfo());
		System.out.println("Maximo: " + arbol.buscarMax().getInfo());
		System.out.println("Maximo recu: " + arbol.buscarMaxRecu(arbol.getRaiz()).getInfo());
	}

}
