package listacircular;

import java.util.Random;
import java.util.Scanner;

public class JogoAnel {

	private Crianca head;
	private int size;
	
	public JogoAnel() {
		head = null;
		size = 0;
	}
	
	public void entrada(Crianca novaCrianca){
		if(head == null){
			head = novaCrianca;
			novaCrianca.setNext(head);
		}else{
			Crianca ultimaCrianca = head;
			while(ultimaCrianca.getNext() != head){
				ultimaCrianca = ultimaCrianca.getNext();
			}
			ultimaCrianca.setNext(novaCrianca);
			novaCrianca.setNext(head);
		}
		size++;
	}
	public void jogar(){
		Random sorteador = new Random(System.currentTimeMillis());
		head.setTemAnel(true);
		
		Crianca umaCrianca = head;
		
		do{
			System.out.println("Cheat: Nome " + umaCrianca.getNome());
			if(umaCrianca.isTemAnel()){
				System.out.println("Cheat: Tem o anel");
				if(sorteador.nextBoolean() || 
						sorteador.nextBoolean()){
					System.out.println("Cheat: Passou o anel");
					umaCrianca.getNext().setTemAnel(true);
					umaCrianca.setTemAnel(false);
				}
			}
			umaCrianca = umaCrianca.getNext();
		}while(umaCrianca != head);
		
		
		Scanner leitor = new Scanner(System.in);
		System.out.println("Qual o nome da criança com o anel");
		String resposta = leitor.nextLine();
		
		umaCrianca = head;
		do{
			if(umaCrianca.getNome().equals(resposta) &&
					umaCrianca.isTemAnel()){
				System.out.println("Parabéns voce ganhou!!!");
				return;
			}
			umaCrianca = umaCrianca.getNext();
		}while(umaCrianca != head);
		System.out.println("Voce perdeu...");
		
	}
	public static void main(String[] args) {
		JogoAnel jogo = new JogoAnel();
		
		jogo.entrada(new Crianca("Huguinho"));
		jogo.entrada(new Crianca("Zezinho"));
		jogo.entrada(new Crianca("Luizinho"));
		jogo.entrada(new Crianca("Margarida"));
		jogo.entrada(new Crianca("Pato Donald"));
		jogo.entrada(new Crianca("Bafo"));
		jogo.entrada(new Crianca("Max"));
		jogo.entrada(new Crianca("Pateta"));
		jogo.entrada(new Crianca("Tio Patinhas"));
		
		jogo.jogar();
	}
}






