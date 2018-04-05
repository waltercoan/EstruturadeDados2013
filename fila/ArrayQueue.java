package fila;

public class ArrayQueue<E> implements Queue<E>{
	private int f=0;
	private int r=0; // proxima posicao livre...
	private E[] Q;
	private int N;
	private static final int CAPACITY = 1000; 
	
	public ArrayQueue() {
		this(CAPACITY);
	}
	public ArrayQueue(int capacity) {
		N = capacity;
		Q = (E[]) new Object[N];
	}
	@Override
	public void enqueue(E element) {
		Q[r] = element;
		r = (r + 1) % N;
	}
 	@Override
	public E dequeue() {
		E aux = Q[f];
		Q[f] = null;
		f = (f + 1) % N;
		return aux;
	}

	@Override
	public int size() {
		if(f==r && Q[f] != null){
			return N;
		}
		return (N - f + r) % N;
	}

	@Override
	public E front() {
		return Q[f];
	}

	@Override
	public boolean isEmpty() {
		return (f==r && Q[f]==null);
	}

}
