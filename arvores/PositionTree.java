package arvores;

import java.util.Iterator;

public class PositionTree<E> implements Tree<E>{
	
	private Position<E> root;
	
	@Override
	public int size() {
		return count(root);
	}
	
	private int count(Position<E> no){
		int c = 1;
		for(Position<E> umFilho:no.getChildren()){
			if(umFilho != null){
				c += count(umFilho);
			}
		}
		return c;
	}

	@Override
	public boolean isEmpty() {
		return root != null;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Position<E>> positions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E replace(Position<E> v, E e) throws InvalidPositionException {
		E aux = v.getElement();
		v.setElement(e);
		return aux;
	}

	@Override
	public Position<E> root() throws EmptyTreeException {
		if(root == null)
			throw new EmptyTreeException("Arvore vazia!");
		return root;
	}

	@Override
	public Position<E> parent(Position<E> v) throws InvalidPositionException,
			BoundaryViolationException {
		
		if(v == root){
			throw new 
			InvalidPositionException("Nó raiz não tem pai!");
		}
		if(v != root && v.getParent() == null){
			throw new 
			BoundaryViolationException("Nó não pertence a árvore");
		}
		return v.getParent();
	}

	@Override
	public Iterable<Position<E>> children(Position<E> v)
			throws InvalidPositionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isInternal(Position<E> v) throws InvalidPositionException {
		
		if(root != v && v.getParent() == null)
			throw new InvalidPositionException("Nó não válido");
		
		for(Position<E> element: v.getChildren()){
			if(element != null)
				return true;
		}
		return false;
	}

	@Override
	public boolean isExternal(Position<E> v) throws InvalidPositionException {
		
		if(root != v && v.getParent() == null)
			throw new InvalidPositionException("Nó não válido");
		
		for(Position<E> element: v.getChildren()){
			if(element != null)
				return false;
		}
		return true;
	}

	@Override
	public boolean isRoot(Position<E> v) throws InvalidPositionException {
		if(root != v && v.getParent() == null)
			throw new InvalidPositionException("Nó não válido");
		
		return v == root;
	}
	
	public void setRoot(Position<E> p){
		root = p;
	}

	
	public void preordem(Position<E> raiz){
		System.out.println(raiz.getElement());
		for(Position<E> umFilho:raiz.getChildren()){
			if(umFilho != null){
				preordem(umFilho);
			}
		}
	}
	
	
	public void posordem(Position<E> raiz){
		
		for(Position<E> umFilho:raiz.getChildren()){
			if(umFilho != null){
				posordem(umFilho);
			}
		}
		
		System.out.println(raiz.getElement());
	}
	
	
}
