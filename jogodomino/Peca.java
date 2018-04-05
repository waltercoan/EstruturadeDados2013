package jogodomino;

public class Peca {
	private int valorAntes;
	private int valorDepois;
	private Peca next;
	
	public Peca(int valorAntes,
				int valorDepois){
		this.valorAntes = valorAntes;
		this.valorDepois = valorDepois;
	}
	
	public int getValorAntes() {
		return valorAntes;
	}
	public void setValorAntes(int valorAntes) {
		this.valorAntes = valorAntes;
	}
	public int getValorDepois() {
		return valorDepois;
	}
	public void setValorDepois(int valorDepois) {
		this.valorDepois = valorDepois;
	}
	public Peca getNext() {
		return next;
	}
	public void setNext(Peca next) {
		this.next = next;
	}
	
}
