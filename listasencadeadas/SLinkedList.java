package listasencadeadas;

public class SLinkedList<E> {
	protected Node<E> head;
	protected int size;

	public SLinkedList() {
		head = null;
		size = 0;
	}
	public int size(){
		return size;
	}

	public Node<E> getFirst(){
		return head;
	}
	
	public void addFirst(Node<E> novo){
		novo.setNext(head);
		head = novo;
		size++;
	}
	public void addLast(Node<E> novo){
		if(head != null){
			Node<E> ultimo = head;

			while(ultimo.getNext() != null){
				ultimo = ultimo.getNext();
			}
			ultimo.setNext(novo);
		}else{
			head = novo;
		}
		size++;
	}
	public Node<E> removeFirst(){
		Node<E> aux = head;
		head = head.getNext();
		size--;
		aux.setNext(null);
		return aux; // aqui NAO vai ficar null...deve retornar o 
		//nodo removido...
	}
	
	public Node<E> removeLast(){
		if(head==null)
			throw new NullPointerException("Lista vazia");
		Node<E> ultimo = head;
		Node<E> penultimo = null;
		
		while(ultimo.getNext() != null){
			penultimo = ultimo;
			ultimo = ultimo.getNext();
		}

		penultimo.setNext(null);
		size--;
		return ultimo;
	}
	public String toString(){
		StringBuilder listaString = new StringBuilder();
		
		Node<E> umNo = head;
		while(umNo != null){
			listaString.append(String.format("%s -> ", umNo.getElement()));
			umNo = umNo.getNext();
		}
		listaString.append(" null");
		return listaString.toString();
	}
//	public static void main(String[] args) {
//		SLinkedList listaEnc = new SLinkedList();
//		Node n1 = new Node("JAN", null);
//		Node n2 = new Node("FEV", null);
//		Node n3 = new Node("MAR", null);
//		Node n4 = new Node("ABR", null);
//		Node n5 = new Node("MAI", null);
//		listaEnc.addLast(n1);
//		listaEnc.addLast(n2);
//		listaEnc.addLast(n3);
//		listaEnc.addLast(n4);
//		listaEnc.addLast(n5);
//		System.out.println(listaEnc);
//	}
}
