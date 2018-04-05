package fila;

public class ListMerge {
	
	
	public ArrayQueue<Integer> merge(ArrayQueue<Integer> a,
										ArrayQueue<Integer> b){
		int tamMaximo = a.size() + b.size();
		ArrayQueue<Integer> result = new ArrayQueue<Integer>(tamMaximo);
		
		while(!a.isEmpty() || !b.isEmpty()){
			
			if(!a.isEmpty())
				result.enqueue(a.dequeue());
			if(!b.isEmpty())
				result.enqueue(b.dequeue());

		}
		return result;
	}
	
	public static void main(String[] args) {
		ArrayQueue<Integer> lista1 = new ArrayQueue<Integer>(10);
		ArrayQueue<Integer> lista2 = new ArrayQueue<Integer>(20);
		ListMerge lm = new ListMerge();
		
		lista1.enqueue(1);
		lista1.enqueue(3);
		lista1.enqueue(5);
		lista1.enqueue(7);
		lista2.enqueue(2);
		lista2.enqueue(4);
		lista2.enqueue(6);
		lista2.enqueue(8);
		
		ArrayQueue<Integer> listaJuntada = 
				lm.merge(lista1,lista2);
		
		while(!listaJuntada.isEmpty())
			System.out.println(listaJuntada.dequeue());
	}
	
}







