package pilha;

public class TestePilha {

	public static void main(String[] args) {

		ArrayStack<Prato> pilha = new ArrayStack<Prato>();
		for (int i = 0; i < 100; i++)
			pilha.push(new Prato(i));
		
		while(!pilha.isEmpty())
			System.out.println(pilha.pop());
	
	}

}
class Prato{
	private int numero;
	public Prato(int numero) {
		this.numero = numero;
	}
	public String toString(){
		return String.valueOf(numero);
	}
}