package arvoresbinarias;

public class TesteBTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedBinaryTree<Integer> arvore = 
				new LinkedBinaryTree<Integer>();
		
		arvore.insertNode(1);
		arvore.insertNode(2);
		arvore.insertNode(3);
		arvore.insertNode(4);
		arvore.insertNode(5);
		System.out.println("Pre ORDEM");
		arvore.preordem(arvore.root());
		System.out.println("POS ORDEM");
		arvore.posordem(arvore.root());
		System.out.println("IN ORDEM");
		arvore.inordem(arvore.root());
	}

}








