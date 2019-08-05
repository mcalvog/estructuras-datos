
public class Principal {

	public static void main(String[] args) {
		PilaArray pila = new PilaArray(10);

		// Añadir 10 enteros mediante un bucle for
		for (int i = 0; i < 10; i++) {
			try {
				pila.insertar(i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// Imprimir datos de la pila
		pila.imprimir();

		// Quitar primer elemento de la pila
		try {
			int primero = (int) pila.quitar();
			System.out.println("\nValor eliminado: " + primero);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Imprimir datos de la pila
		pila.imprimir();

		// Imprimir numero de elementos
		System.out.println("\nHay " + pila.contarDatos() + " elementos.");

		// Imprimir tamano de la pila
		System.out.print("Tam pila: " + pila.tamPila());
	}

}
