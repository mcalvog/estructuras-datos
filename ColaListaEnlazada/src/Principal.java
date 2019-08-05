
public class Principal {

	public static void main(String[] args) {
		ColaLista cola = new ColaLista();

		// Añadir 10 enteros mediante un bucle for
		for (int i = 0; i < 10; i++) {
			cola.insertar(i);
		}

		// Imprimir datos de la cola
		cola.imprimir();

		System.out.println(); // Salto de linea

		// Quitar primer elemento de la cola
		try {
			int primero = (int) cola.quitar();
			System.out.println("Valor eliminado: " + primero);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Imprimir datos de la cola
		cola.imprimir();

		System.out.println(); // Salto de linea

		// Imprimir numero de elementos
		System.out.print("Hay " + cola.contarDatos() + " elementos.");
	}

}
