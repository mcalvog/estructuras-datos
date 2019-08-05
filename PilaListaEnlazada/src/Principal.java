
public class Principal {

	public static void main(String[] args) {
		PilaLista pila = new PilaLista();

		// Añadir 10 enteros mediante un bucle for
		for (int i = 0; i < 10; i++) {
			pila.insertar(i);
		}

		// Imprimir datos de la pila
		pila.imprimir();

		System.out.println(); // Salto de linea

		// Quitar primer elemento de la pila
		try {
			int primero = (int) pila.quitar();
			System.out.println("Valor eliminado: " + primero);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Imprimir datos de la pila
		pila.imprimir();

		System.out.println(); // Salto de linea

		// Imprimir numero de elementos
		System.out.print("Hay " + pila.contarDatos() + " elementos.");
	}

}
