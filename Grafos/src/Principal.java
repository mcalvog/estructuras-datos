import grafos.algoritmos.ArbolExpansionMinimo;
import grafos.tipos.lista.GrafoAdcia;

public class Principal {

	public static void main(String[] args) {
		GrafoAdcia g = new GrafoAdcia(6);
		g.nuevoVertice("Huesca");
		g.nuevoVertice("Zaragoza");
		g.nuevoVertice("Barcelona");
		g.nuevoVertice("Madrid");
		g.nuevoVertice("Valencia");
		g.nuevoVertice("Alicante");

		try {
			g.nuevoArco("Huesca", "Zaragoza", 100);
			g.nuevoArco("Zaragoza", "Barcelona", 300);
			g.nuevoArco("Madrid", "Zaragoza", 300);
			g.nuevoArco("Madrid", "Valencia", 300);
			g.nuevoArco("Valencia", "Alicante", 200);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			g.recorrerProfundidad("Madrid");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("\n"); // doble salto de linea

		System.out.println("*** Usando Dijkstra ***\n"); // doble salto de linea

		g.conectadas("Valencia", "Madrid");
		
		g.conectadas("Madrid", "Alicante");
		System.out.println();
		
		/**
		 * Usando floyd
		 */

		System.out.println("*** Usando Floyd ***\n"); // doble salto de linea

		g.conectadasFloyd("Valencia", "Madrid");
		
		g.conectadasFloyd("Madrid", "Alicante");
		System.out.println();

		System.out.println("*** Usando Prim ***\n"); // doble salto de linea
		
		ArbolExpansionMinimo arm = new ArbolExpansionMinimo(g);
		System.out.println("Longitud min: " + arm.arbolExpansionPrim());
		
	}

}
