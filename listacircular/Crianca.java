package listacircular;

public class Crianca {
	private String nome;
	private boolean temAnel;
	private Crianca next;
	
	public Crianca(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isTemAnel() {
		return temAnel;
	}

	public void setTemAnel(boolean temAnel) {
		this.temAnel = temAnel;
	}

	public Crianca getNext() {
		return next;
	}

	public void setNext(Crianca next) {
		this.next = next;
	}
}
