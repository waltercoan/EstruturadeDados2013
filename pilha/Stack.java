package pilha;

public interface Stack<E> {
	public void push(E element);
	public E pop();
	public E top();
	public boolean isEmpty();
	public int size();
}
