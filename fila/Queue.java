package fila;

public interface Queue<E> {
	public void enqueue(E element);
	public E dequeue();
	public int size();
	public E front();
	public boolean isEmpty();
}
