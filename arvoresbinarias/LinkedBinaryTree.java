package arvoresbinarias;

import java.util.Iterator;

public class LinkedBinaryTree<E extends Comparable<E>> 
implements BinaryTree<E> {
	private BTPosition<E> root;
	private int size;
	private int profundidade=0;
	public static int searchDeepth=0;

	public LinkedBinaryTree() {
	}
	public E remove(BTPosition<E> e){
		//Guardo a referencia para o PAI
		BTPosition<E> parent = e.getParent();
		//Guardo o valor do nodo
		E value = e.element();
		//Crio uma variavel para guardar o filho
		BTPosition<E> filho = null;
		// Se tem filhos a direita e esquerda
		if(hasLeft(e) && hasRight(e)){
			//Nao faz nada
			return null;
		}else{
			//Senão indica que tem um filho a direita ou esquerda
			//Desliga o nodo do pai
			e.setParent(null);
			//Se tiver filho a esquerda ou direita
			if(hasLeft(e) || hasRight(e)){ 
				//Se tiver filho a esquerda
				if(hasLeft(e)){
					//Guarda a referencia do filho a esquerda
					filho = e.getLeft();
				}else{
					//Guarda a referencia do filho a direita
					filho = e.getRight();
				}
			}
			if(e == root){
				root = filho;
			}else{
				//Se o nodo a esquerda do pai foi o removido
				if(parent.getLeft() == e)
					//Nodo a esquerda do pai recebe filho
					parent.setLeft(filho);
				else
					//Nodo a direita do pai recebe filho
					parent.setRight(filho);
			}
			return value;
		}
	}

	public boolean search(E element){
		searchDeepth=0;
		return binarySearch(root, element);
	}
	private boolean binarySearch(BTPosition<E> node, E element){
		searchDeepth++;
		if(node.element().compareTo(element) == 0){
			return true;
		}else{
			if(node.element().compareTo(element) < 0){
				if(hasLeft(node)){
					return binarySearch(node.getLeft(), element);
				}
			}else{
				if(hasRight(node)){
					return binarySearch(node.getRight(), element);
				}
			}
		}
		return false;
	}


	private int calcLongWay(BTPosition<E> ref){
		int factor=0;
		if(hasLeft(ref)) factor = 1 + calcLongWay(ref.getLeft());
		if(hasRight(ref)) factor = Math.max(factor, 1 + 
				calcLongWay(ref.getRight()));
		return factor;
	}

	public int calcBalanceFactor(BTPosition<E> ref){
		int leftFactor = 0;
		int rightFactor = 0;
		if(hasLeft(ref))
			leftFactor = calcLongWay(ref.getLeft()) + 1;
		if(hasRight(ref))
			rightFactor = calcLongWay(ref.getRight()) + 1;
		return leftFactor - rightFactor; 
	}
	private void rotationR(BTPosition<E> ref){
		System.out.println("Rot DIR");
		BTPosition<E> parent = ref.getParent();

		BTPosition<E> p = ref;
		BTPosition<E> q = (p!=null)?p.getLeft():null;
		BTPosition<E> h = (q!=null)?q.getRight():null;
		q.setRight(p);
		if(p!=null)
			p.setParent(q);
		p.setLeft(h);
		if(h!=null)
			h.setParent(p);

		if(!isRoot(ref)){
			if(parent.getLeft() == ref){
				parent.setLeft(q);
			}
			if(parent.getRight() == ref){
				parent.setRight(q);
			}
			q.setParent(parent);
		}else{
			root = q;
		}
	}


	private void rotationL(BTPosition<E> ref){
		System.out.println("Rot ESQ");
		BTPosition<E> parent = ref.getParent();

		BTPosition<E> p = ref;
		BTPosition<E> q = (p!=null)?p.getRight():null;
		BTPosition<E> h = (q!=null)?q.getLeft():null;
		q.setLeft(p);
		if(p!=null)
			p.setParent(q);
		p.setRight(h);
		if(h!=null)
			h.setParent(p);
		if(!isRoot(ref)){
			if(parent.getLeft() == ref){
				parent.setLeft(q);
			}else{
				parent.setRight(q);
			}
			q.setParent(parent);
		}else{
			root = q;
		}
	}

	private void rotationLR(BTPosition<E> ref){
		System.out.println("Rot Dupla ESQ-DIR");
		rotationL(ref.getLeft());
		rotationR(ref);
	}


	private void rotationRL(BTPosition<E> ref){
		System.out.println("Rot Dupla DIR-ESQ");
		rotationR(ref.getRight());
		rotationL(ref);
	}
	public void balance(BTPosition<E> ref){
		int factor = calcBalanceFactor(ref);
		if(Math.abs(factor) <= 1){
			if(hasLeft(ref))
				balance(ref.getLeft());
			if(hasRight(ref))
				balance(ref.getRight());
		}else{
			if(factor >= 2){
				int subFactor = calcBalanceFactor(ref.getLeft());
				if (subFactor >= 0)
					rotationR(ref);
				else
					rotationLR(ref);
			}
			if(factor <= -2){
				int subFactor = calcBalanceFactor(ref.getRight());
				if (subFactor < 0)
					rotationL(ref);
				else
					rotationRL(ref);
			}
		}
	}


	public void insertNode(E element){
		profundidade = 0;
		if(root == null){
			root = posicionaNode(root, element);
		}else{
			posicionaNode(root, element);
		}
		balance(root);
	}

	public void preordem(BTPosition<E> raiz){
		System.out.println(raiz.element());
		if(raiz.getLeft() != null)
			preordem(raiz.getLeft());
		if(raiz.getRight() != null)
			preordem(raiz.getRight());
	}
	public void posordem(BTPosition<E> raiz){
		if(raiz.getLeft() != null)
			posordem(raiz.getLeft());
		if(raiz.getRight() != null)
			posordem(raiz.getRight());
		System.out.println(raiz.element());
	}
	public void inordem(BTPosition<E> raiz){
		if(raiz.getLeft() != null)
			inordem(raiz.getLeft());

		System.out.println(raiz.element());

		if(raiz.getRight() != null)
			inordem(raiz.getRight());
	}


	private BTPosition<E> posicionaNode
	(BTPosition<E> nodoRef, E element){
		profundidade++;
		if(nodoRef != null){
			if(element.compareTo(nodoRef.element()) < 0){
				//novo valor é menor que a ref
				if(nodoRef.getLeft()==null){
					nodoRef.setLeft(new 
							BTNode<E>(element, null, null, nodoRef));
				}else{
					posicionaNode(nodoRef.getLeft(),element);
				}
			}else{
				//novo valor é maior que a ref
				if(nodoRef.getRight() == null){
					nodoRef.setRight(new 
							BTNode<E>(element, null, null, nodoRef));
				}else{
					posicionaNode(nodoRef.getRight(),element);
				}
			}
		}else{
			nodoRef = new BTNode<E>(element, null, null, null);
		}
		return nodoRef;
	}

	public int size(){
		return size;
	}
	public boolean isInternal(BTPosition<E> p){
		return p.getLeft() != null || p.getRight() != null;
	}
	public boolean isRoot(BTPosition<E> p){
		return root == p;
	}
	public BTPosition<E> root(){
		return root;
	}

	@Override
	public BTPosition<E> left(BTPosition<E> p) {
		return p.getLeft();
	}

	@Override
	public BTPosition<E> right(BTPosition<E> p) {
		return p.getRight();
	}

	@Override
	public boolean hasLeft(BTPosition<E> p) {
		return p.getLeft() != null;
	}

	@Override
	public boolean hasRight(BTPosition<E> p) {
		return p.getRight() != null;
	}
	public Iterator<E> children(BTPosition<E> p){
		//tarefa de casa...!!!
		return null;
	}
	public Iterator<E> iterator(){
		return null;
	}
	public Iterator<E> positions(){
		return null;
	}
	public E replace(BTPosition<E> v, E e){
		return null;
	}
	public BTPosition<E> sibling(BTPosition<E> v){
		return null;
	}
	public BTPosition<E> addRoot(E e){
		root =
				new BTNode<E>(e, null, null, null);
		size++;
		return root;
	}
	public BTPosition<E> insertLeft(BTPosition<E> base, E novo){
		BTNode<E> novoNo = new BTNode<E>(novo, null, null, base);
		base.setLeft(novoNo);
		size++;
		return novoNo;
	}
	public void attach(BTPosition<E> v, BinaryTree<E> t1, 
			BinaryTree<E> t2){

	}
	public BTPosition<E> checkPosition(BTPosition<E> v){
		return null;
	}
	public BTPosition<E> createNode(E element,BTPosition<E> left,
			BTPosition<E> right, BTPosition<E> parent){
		BTNode<E> novoNo = new BTNode<E>(element, left, 
				right, parent);
		return novoNo;
	}

}
