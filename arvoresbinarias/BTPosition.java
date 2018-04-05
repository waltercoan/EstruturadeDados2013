package arvoresbinarias;

public interface BTPosition<E> {
    public E element();
    public void setElement(E e);
    public BTPosition<E> getLeft();
    public void setLeft(BTPosition<E> p);
    public BTPosition<E> getRight();
    public void setRight(BTPosition<E> p);
    public BTPosition<E> getParent();
    public void setParent(BTPosition<E> p);
}