package jogodomino;

public class Jogo {
	protected Peca head;
	protected long size;
	
	public void addFirst(Peca novaPeca){
		if(head != null && novaPeca.getValorDepois() != head.getValorAntes()){
			System.out.println("jogada invalida!!!");
			return;
		}
		
		novaPeca.setNext(head);
		head = novaPeca;
		size++;
}
	
	public void addLast(Peca novaPeca){
		if(head != null){
			//existe pelo menos uma peça
			Peca ultima = head;
			while(ultima.getNext() != null){
				ultima = ultima.getNext();
			}

			if(ultima.getValorDepois() == novaPeca.getValorAntes()){
				ultima.setNext(novaPeca);
				size++;
			}else{
				System.out.println("Jogada invalida");
			}
			
		}else{
			//não existe nenhuma peça
			head = novaPeca;
			size++;
		}
	}
	
	public static void main(String[] args) {
		Peca p1 = new Peca(1, 4);
		Peca p2 = new Peca(2, 1);
		Peca p3 = new Peca(4, 6);
		Peca p4 = new Peca(3, 2);
		Peca p5 = new Peca(6, 5);
		
		Jogo domino = new Jogo();
		
		domino.addFirst(p1);
		domino.addFirst(p2);
		domino.addLast(p3);
		domino.addFirst(p4);
		domino.addLast(p5);
		
		
				
	}
}
