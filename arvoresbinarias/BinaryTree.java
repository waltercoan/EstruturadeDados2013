package arvoresbinarias;

public interface BinaryTree<E> {
	public BTPosition<E> left (BTPosition<E> p);
	public BTPosition<E> right (BTPosition<E> p);
	public boolean hasLeft (BTPosition<E> p);
	public boolean hasRight (BTPosition<E> p);
}
