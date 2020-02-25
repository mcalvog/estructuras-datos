package grafos.tipos.lista;

public class Arco {

	int destino;
	double peso;

	public Arco(int d) {
		destino = d;
	}

	public Arco(int d, double p) {
		this(d);
		peso = p;
	}

	public int getDestino() {
		return destino;
	}
	
	public double getPeso() {
		return peso;
	}

	public boolean equals(Object n) {
		Arco a = (Arco) n;
		return destino == a.destino;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Destino: " + destino + ", peso: " + peso;
	}
}
