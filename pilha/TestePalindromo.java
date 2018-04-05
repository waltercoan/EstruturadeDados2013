package pilha;

import java.util.Scanner;

public class TestePalindromo {
	
	public static void main(String[] args) {

		ArrayStack<Character> pilha = new ArrayStack<Character>();
		String contrario="";
		
		Scanner leitor = new Scanner(System.in);
		System.out.println("Digite uma palavra");
		String palavra = leitor.nextLine();
		
		for(char umaLetra:palavra.toCharArray()){
			pilha.push(umaLetra);
		}
		
		while(!pilha.isEmpty()){
			contrario += pilha.pop();
		}

		System.out.println(contrario);
		
		if(palavra.equalsIgnoreCase(contrario)){
			System.out.println("É palindromo...");
		}else{
			System.out.println("NÃO É palindromo...");
		}
	}
}





