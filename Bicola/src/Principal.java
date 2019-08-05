
public class Principal {

	public static void main(String[] args) {
		Bicola cola = new Bicola();

		// Añadir 10 enteros mediante un bucle for
		for (int i = 0; i < 10; i++) {
			cola.insertarFinal(i);
		}

		// Imprimir datos de la cola
		cola.imprimir();

		System.out.println(); // Salto de linea

		// Quitar primer y ultimo elemento de la cola
		try {
			int primero = (int) cola.quitarFrente();
			int ultimo = (int) cola.quitarFinal();

			System.out.println("Valor frente eliminado: " + primero);
			System.out.println("Valor fin eliminado: " + ultimo);
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
