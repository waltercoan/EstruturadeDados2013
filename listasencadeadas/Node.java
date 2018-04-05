package listasencadeadas;

public class Node<E> {
	private E element;
	private Node next;
	
	public Node(E element, Node next) {
		this.element = element;
		this.next = next;
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
