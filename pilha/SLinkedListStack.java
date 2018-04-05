package pilha;

import listasencadeadas.SLinkedList;
import listasencadeadas.*;
public class SLinkedListStack<E> implements Stack<E>{

	SLinkedList<E> lista = new SLinkedList<E>();
	
	@Override
	public void push(E element) {
		Node<E> novoNo = new Node<E>(element,null); 
		lista.addFirst(novoNo);
	}

	@Override
	public E pop() {
		if(isEmpty())
			throw new EmptyStackException("Pilha vazia!");
		return lista.removeFirst().getElement();
	}

	@Override
	public E top() {
		if(isEmpty())
			throw new EmptyStackException("Pilha vazia!");
		return lista.getFirst().getElement();
	}

	@Override
	public boolean isEmpty() {
		return lista.size() == 0;
	}

	@Override
	public int size() {
		return lista.size();
	}

}
