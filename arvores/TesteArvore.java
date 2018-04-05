package arvores;

public class TesteArvore {
	public static void main(String[] args) {
		PositionTree<String> arvore = new PositionTree<String>();
		
		Position<String> noSC = new Position<String>();
		noSC.setElement("Santa Catarina");
		
		arvore.setRoot(noSC);
		
		Position<String> regiaoNorte = new Position<String>();
		regiaoNorte.setElement("Região Norte");
		
		noSC.addChild(regiaoNorte);
		
		Position<String> cidadeJlle = new Position<String>();
		cidadeJlle.setElement("Joinville");
		
		regiaoNorte.addChild(cidadeJlle);
		
		Position<String> regiaoOeste = new Position<String>();
		regiaoOeste.setElement("Região Oeste");
		
		noSC.addChild(regiaoOeste);
		
		Position<String> cidadeChap = new Position<String>();
		cidadeChap.setElement("Chapecó");
		
		regiaoOeste.addChild(cidadeChap);
		
		System.out.println("\n\n\nAlgoritmo PRE ORDEM\n\n\n");
		arvore.preordem(arvore.root());
		
		System.out.println("\n\n\nAlgoritmo POS ORDEM\n\n\n");
		arvore.posordem(arvore.root());
		
		System.out.println("Numero de nos: " + arvore.size());
		
	}
}
