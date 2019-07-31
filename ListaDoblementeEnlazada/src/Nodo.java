
public class Nodo {
	private Object dato;
	private Nodo adelante, atras;

	public Nodo(Object dato) {
		this.dato = dato;
		adelante = atras = null;
	}
	
	public Object getDato() {
		return dato;
	}
	
	public Nodo getAdelante() {
		return adelante;
	}
	
	public Nodo getAtras() {
		return atras;
	}
	
	public void setAdelante(Nodo adelante) {
		this.adelante = adelante;
	}
	
	public void setAtras(Nodo atras) {
		this.atras = atras;
	}

}
