package fila;

public class TesteFila {
	public static void main(String[] args) {
		
		ArrayQueue<String> filaNomesPessoas = 
				new ArrayQueue<String>();
		
		filaNomesPessoas.enqueue("Zezinho");
		filaNomesPessoas.enqueue("Luizinho");
		filaNomesPessoas.enqueue("Hugo");
		filaNomesPessoas.enqueue("Tio Patinhas");
		filaNomesPessoas.enqueue("Pateta");
		filaNomesPessoas.enqueue("Pato Donald");
		filaNomesPessoas.enqueue("Max");
		filaNomesPessoas.enqueue("Bafo");
		filaNomesPessoas.enqueue("Pluto");
		
		while(!filaNomesPessoas.isEmpty()){
			String nome = 
					filaNomesPessoas.dequeue();
			System.out.println(nome);
		}
		
		
	}
}
