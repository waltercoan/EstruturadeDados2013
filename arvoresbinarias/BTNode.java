package arvoresbinarias;
public class BTNode<E> implements BTPosition<E>{
    private E element;
    private BTPosition<E> left, right, parent;
    
    public BTNode(E element,BTPosition<E> left, 
    		BTPosition<E> right, BTPosition<E> parent ){
        setElement(element);
        setParent(parent);
        setLeft(left);
        setRight(right);
    }
    public E element() {
        return element;
    }
    public BTPosition<E> getLeft() {
        return left;
    }
    public BTPosition<E> getParent() {
        return parent;
    }
    public BTPosition<E> getRight() {
        return right;
    }
    public void setElement(E e) {
        this.element = e;
    }
    public void setLeft(BTPosition<E> p) {
        this.left = p;
    }
    public void setParent(BTPosition<E> p) {
        this.parent = p;
    }
    public void setRight(BTPosition<E> p) {
        this.right = p;
    }
}
