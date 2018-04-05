package carla;

public class impressao {
	
	private int numero;
	private int tamanho;
	private String usuario;
	private int prioridade;
	
	//construtor
	public impressao(int numero, int tamanho, String usuario, int prioridade) {
		this.numero = numero;
		this.tamanho = tamanho;
		this.usuario = usuario;
		this.prioridade = prioridade;
	}
	
	public int getNumero() {
		return numero;
		
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public int getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	
}
