package armazem;

public class Produto {
	private String descricao;
	private int categoria;
	private float peso;
	
	public Produto(String descricao, int categoria, float peso) {
		this.descricao = descricao;
		this.categoria = categoria;
		this.peso = peso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}
	
			
}
