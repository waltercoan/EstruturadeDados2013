package arvores;

import java.lang.reflect.Array;

public class Position<E> {
    private E element;
    private Position<E> parent;
    private Position<E>[] children;
    private final static int CAPACITY = 1000;
    private int capacity;
    private int proxLivre=0;
    
    public Position(int capacity) {
        this.capacity = capacity;
        children = (Position<E>[]) 
        		Array.newInstance(Position.class, capacity);
    }
    public Position() {
        this(CAPACITY);
    }
    public E getElement() {
        return element;
    }
    public void setElement(E element) {
        this.element = element;
    }
    public Position<E> getParent() {
        return parent;
    }
    public void setParent(Position<E> parent) {
        this.parent = parent;
    }
    public Position<E>[] getChildren() {
        return children;
    }
    public void setChildrens(Position<E>[] children) {
        this.children = children;
    }
    public int getCapacity() {
        return capacity;
    }
    public void addChild(Position<E> p){
    	if(proxLivre < capacity){
    		children[proxLivre++] = p;
    		p.setParent(this);
    	}
    }
    
    
}
