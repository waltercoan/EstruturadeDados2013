package pilha;

public class ArrayStack<E> implements Stack<E> {
	//Tamanho REAL da pilha
	private int capacity;
	private final static int CAPACITY=1000;
	private E S[];
	private int top=-1;
	
	public ArrayStack() {
		this(CAPACITY);
	}
	public ArrayStack(int capacity) {
		this.capacity = capacity;
		S = (E[]) new Object[capacity];
	}
	
	@Override
	public void push(E element) {
		if(top >= (capacity-1))
			throw new FullStackException("Pilha cheia");
		S[++top] = element;
	}

	@Override
	public E pop() {
		if(isEmpty())
			throw new EmptyStackException("Pilha vazia!");
		E aux = S[top];
		S[top--] = null;
		return aux;
	}

	@Override
	public E top() {
		if(isEmpty())
			throw new EmptyStackException("Pilha vazia!");
		return S[top];
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public int size() {
		return top + 1;
	}

}
