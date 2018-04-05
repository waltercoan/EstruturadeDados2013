package listaduplamente;

public class DLinkedList<E> {

	protected DNode<E> head;
	protected DNode<E> trailer;
	protected int size;
	
	public DLinkedList() {
		head = new DNode<E>(null);
		trailer = new DNode<E>(null);
		size = 0;
		head.setNext(trailer);
		trailer.setPrev(head);
	}
	public void addFirst(DNode<E> novoNo){
		DNode<E> antigoPrimeiro=head.getNext();
		
		head.setNext(novoNo);
		antigoPrimeiro.setPrev(novoNo);
		novoNo.setPrev(head);
		novoNo.setNext(antigoPrimeiro);
		size++;
	}
	public void addLast(DNode<E> novoNo){
		DNode<E> antigoUltimo = trailer.getPrev();
		
		antigoUltimo.setNext(novoNo);
		novoNo.setPrev(antigoUltimo);
		novoNo.setNext(trailer);
		trailer.setPrev(novoNo);
		size++;
	}
	
	public DNode<E> removeFirst(){
		DNode<E> primeiro = head.getNext(); 
		DNode<E> segundo = primeiro.getNext();
		
		head.setNext(segundo);
		segundo.setPrev(head);
		primeiro.setNext(null);
		primeiro.setPrev(null);
		
		size--;
		return primeiro;
	}
	public DNode<E> removeLast(){
		DNode<E> ultimo = trailer.getPrev();
		DNode<E> penultimo = ultimo.getPrev();
		
		penultimo.setNext(trailer);
		trailer.setPrev(penultimo);
		ultimo.setNext(null);
		ultimo.setPrev(null);
		
		size--;
		return ultimo;
	}
	public DNode<E> getFirst(){
		return head.getNext();
	}
	
	public int getSize(){
		return size;
	}
	
	
}
