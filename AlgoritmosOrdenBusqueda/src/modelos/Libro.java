package modelos;

public class Libro {
	
	private int numero;
	private String nombre;
	
	public Libro(int numero, String nombre) {
		super();
		this.numero = numero;
		this.nombre = nombre;
	}
	public int getNumero() {
		return numero;
	}
	public String getNombre() {
		return nombre;
	}

}
