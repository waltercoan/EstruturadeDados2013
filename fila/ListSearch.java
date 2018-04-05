package fila;

import java.util.Scanner;

public class ListSearch {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		
		Queue<Integer> lista = new LinkedListQueue<Integer>();
		lista.enqueue(10);
		lista.enqueue(30);
		lista.enqueue(50);
		lista.enqueue(60);
		lista.enqueue(70);
		lista.enqueue(80);
		lista.enqueue(320);
		
		System.out.println("Digite o numero procurado");
		int buscar = leitor.nextInt();
		
		int resul = searchList(lista,buscar);
		
		System.out.println("Resultado: " + resul);
		
	}
	public static Integer searchList(Queue<Integer> l, int vBusca){
		if(!l.isEmpty()){
			if(vBusca == l.dequeue()){
				return vBusca;
			}
			searchList(l, vBusca);
		}
		return null;
	}
}




