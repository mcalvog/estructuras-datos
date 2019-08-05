
public class Principal {

	public static void main(String[] args) {
		ColaArray cola = new ColaArray(10);

		// Añadir 10 enteros mediante un bucle for
		for (int i = 0; i < 10; i++) {
			try {
				cola.insertar(i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// Imprimir datos de la cola
		cola.imprimir();

		// Quitar primer elemento de la cola
		try {
			int primero = (int) cola.quitar();
			System.out.println("\nValor eliminado: " + primero);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Imprimir datos de la cola
		cola.imprimir();

		// Imprimir numero de elementos
		System.out.println("\nHay " + cola.contarDatos() + " elementos.");

		// Imprimir tamano maximo de la cola
		System.out.print("Tam maximo cola: " + cola.tamMax());
	}

}
