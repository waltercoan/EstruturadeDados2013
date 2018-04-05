package pilha;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class InverteArray {

	
	public static int[] inverte(int numeros[]){
		int[] vetRetorn = new int[numeros.length];
		
		ArrayStack<Integer> pilha = new ArrayStack<Integer>();
		
		for(int umNumero:numeros){
			pilha.push(umNumero);
		}
		int c=0;
		while(!pilha.isEmpty())
			vetRetorn[c++] = pilha.pop();
		
		return vetRetorn;
	}
	
	public static void main(String[] args) {
		
		
		int [] r =
			InverteArray.inverte(
					new int[]{1,2,3,4,5,6,7});
		
		System.out.println(Arrays.toString(r));
	}
}
