package fila;

import listaduplamente.DLinkedList;
import listaduplamente.DNode;


public class LinkedListQueue<E> implements Queue<E>{
	
	DLinkedList<E> lista = new DLinkedList<E>();
	
	@Override
	public void enqueue(E element) {
		DNode<E> novoNo = new DNode<E>(element);
		lista.addFirst(novoNo);
	}
	@Override
	public E dequeue() {
		return lista.removeLast().getElement();
	}
	@Override
	public int size() {
		return lista.getSize();
	}
	@Override
	public E front() {
		return lista.getFirst().getElement();
	}
	@Override
	public boolean isEmpty() {
		return (lista.getSize()==0);
	}

}
